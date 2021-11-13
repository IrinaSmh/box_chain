package com.visdom.zero_west.service;

import com.google.common.collect.Lists;
import com.visdom.zero_west.dao.*;
import com.visdom.zero_west.dto.*;
import com.visdom.zero_west.exception.GarbageNameNotFoundException;
import com.visdom.zero_west.exception.UserNotFoundException;
import com.visdom.zero_west.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private UserAchievementDao userAchievementDao;
    private UserDao userDao;
    private GarbageDao garbageDao;
    private LevelDao levelDao;
    private RoleDao roleDao;
    private AchievementDao achievementDao;
    private ImageDao imageDao;
    private MessageDao messageDao;

    @Autowired
    public UserService(UserDao userDao, GarbageDao garbageDao, LevelDao levelDao,
                       RoleDao roleDao, UserAchievementDao userAchievementDao,
                       AchievementDao achievementDao, ImageDao imageDao, MessageDao messageDao) {
        this.userDao = userDao;
        this.garbageDao = garbageDao;
        this.levelDao = levelDao;
        this.roleDao = roleDao;
        this.userAchievementDao = userAchievementDao;
        this.achievementDao = achievementDao;
        this.imageDao = imageDao;
        this.messageDao = messageDao;
    }

    public UserDto handOverGarbage(Long userId, GarbageDto garbageDto) {
        int countGarbage = garbageDto.getCount();
        User user = getUserById(userId);
        if (countGarbage > 0) {
            Garbage garbage = getGarbageByName(garbageDto.getName());


            if((garbage.getName().equals("Батарейка") || garbage.getName().equals("Крышка")) && countGarbage < 5) {
                throw new RuntimeException("Данный вид мусора ожидается в количестве от пяти единиц");
            }
            if(garbage.getName().equals("Чек") && countGarbage < 10) {
                throw new RuntimeException("Данный вид мусора ожидается в количестве от десяти единиц");
            }

            user.setCoins(user.getCoins() + garbage.getCoins()*countGarbage);
            user.setXp(user.getXp() + garbage.getXp()*countGarbage);
            updateLevel(user);

            user.setUpdateRatingData(LocalDateTime.now());
            setAchievement(userId, garbage.getName());

            return new UserDto(userDao.save(user));
        } else return new UserDto(user);

    }

    public List<UserDto> getRatingUsersForWeek() {
        List<UserDto> usersDto = new ArrayList<>();
        userDao.findAllByRole_IdAndUpdateRatingDataGreaterThanOrderByXpDesc(1, LocalDateTime.now().minusDays(7))
                .ifPresent(users -> users.forEach(user -> usersDto.add(new UserDto(user))));
        return usersDto;
    }

    public AllUserDto checkUserInDB(Long userId) {
        User user = getUserById(userId);
        return new AllUserDto(user, getMascotImagesByLevel(user.getLevel().getId()));
    }

    public List<UserDto> getRatingUsersForAllTime() {
        List<UserDto> usersDto = new ArrayList<>();
        userDao.findAllByRole_IdOrderByXpDesc(1)
                .ifPresent(users -> users.forEach(user -> usersDto.add(new UserDto(user))));
        return usersDto;
    }

    @Transactional
    public UserDto saveUser(UserRegistrationDto userRegistrationDto) {
        Role role = roleDao.findById(userRegistrationDto.getRoleId())
                .orElseThrow(()->new RuntimeException("Role not found"));
        User user = new User(userRegistrationDto, role);
        return new UserDto(userDao.save(user));
    }

    public List<Achievement> getLastUserAchievements(Long userId) {
        List<Achievement> result = new ArrayList<>();
        List<UserAchievement> userAchievements = userAchievementDao.findAllById_UserId(userId)
                .orElseThrow(()->new RuntimeException("Not found user achievements"));
        List<Achievement> achievementList = Lists.newArrayList(achievementDao.findAll());

        userAchievements.forEach(a -> {
            int userCount = a.getCount() > 5 ? 5 : a.getCount();
            achievementList.stream().filter(al ->
                    al.getTypeOfAchievement().getId().equals(a.getId().getTypeOfAchievementId()) && al.getCount() == userCount)
                    .findFirst().ifPresent(result::add);
        });

        return result;
    }

    public UserDto changeRoleToOperator(Long userId) {
        User user = getUserById(userId);
        if (user.getRole().getId() != 2) {
            user.setRole(new Role(2, "operator"));
            return new UserDto(userDao.save(user));
        } else return new UserDto(user);
    }

    public List<UserDto> getOperators() {
        List<UserDto> usersDto = new ArrayList<>();
        userDao.findAllByRole_Id(2).ifPresent(users -> users.forEach(user -> usersDto.add(new UserDto(user))));
        return usersDto;
    }

    private List<Image> getMascotImagesByLevel(Integer level) {
        List<Image> result = new ArrayList<>();
        if (level > 0) {
            if (level <= 3) {
                result = imageDao.findAllByMaxLevel(3).orElse(new ArrayList<>());
            } else if (level <= 5) {
                result = imageDao.findAllByMaxLevel(5).orElse(new ArrayList<>());
            } else {
                result = imageDao.findAllByMaxLevel(10).orElse(new ArrayList<>());
            }
        }
        return result;
    }

    public MessageDto getWelcomeMessage() {
        int number = (int) (Math.random() * (6 - 1) + 1);
        return new MessageDto(messageDao.findById(number).orElse(new Message(1, "ERROR")).getText());
    }

    private void setAchievement(Long userId, String garbageName) {
        int typeAchievementId = 0;
        switch (garbageName) {
            case ("Батарейка"):
                typeAchievementId = 2;
                break;
            case ("Крышка"):
                typeAchievementId = 3;
                break;
            case ("Бутылка"):
                typeAchievementId = 5;
                break;
            case ("Бумага"):
            case ("Чек"):
                typeAchievementId = 4;
                break;
            default:
                throw new RuntimeException("Нет такого вида мусора");
        }
        UserAchievementKey userAchievementKey = new UserAchievementKey(typeAchievementId, userId);
        UserAchievement userAchievement = userAchievementDao.findById(userAchievementKey)
                .orElse(new UserAchievement(userAchievementKey, 0));
        userAchievement.setCount(userAchievement.getCount() + 1);
       userAchievementDao.save(userAchievement);
    }

    private User getUserById(Long userId) {
        return userDao.findById(userId)
                .orElseThrow(()->new UserNotFoundException("User with id " + userId + " not found."));
    }

    private Garbage getGarbageByName(String name) {
        return garbageDao.findGarbageByName(name)
                .orElseThrow(()->new GarbageNameNotFoundException("Garbage with name " + name + " not found."));
    }

    private Level getLevelById(Integer id) {
        return levelDao.findById(id)
                .orElseThrow(()->new RuntimeException("Level with id " + id + " not found."));
    }

    private void updateLevel(User user) {
        Level level = levelDao.findFirstByMinXpLessThanOrderByMinXpDesc(user.getXp())
                .orElseThrow(()->new RuntimeException("Level in divide " + user.getXp() + " not found"));
        if(!level.getId().equals(user.getLevel().getId())) {
            user.setLevel(getLevelById(level.getId()));
        }
    }
}
