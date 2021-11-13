package com.visdom.zero_west.controller;

import com.visdom.zero_west.dto.GarbageDto;
import com.visdom.zero_west.dto.UserRegistrationDto;
import com.visdom.zero_west.exception.UserNotFoundException;
import com.visdom.zero_west.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/sendGarbage/{userId}")
    public ResponseEntity<?> sendGarbage(@RequestBody GarbageDto garbageDto, @PathVariable Long userId) {
        try {
            return new ResponseEntity<>(userService.handOverGarbage(userId, garbageDto), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/checkUser/{userId}")
    public ResponseEntity<?> checkUserInDB(@PathVariable Long userId) {
        try {
            return new ResponseEntity<>(userService.checkUserInDB(userId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        try {
            return new ResponseEntity<>(userService.saveUser(userRegistrationDto), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/userToOperator/{userId}")
    public ResponseEntity<?> changeRoleToOperator(@PathVariable Long userId) {
        try {
            return new ResponseEntity<>(userService.changeRoleToOperator(userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/operators")
    public ResponseEntity<?> getOperators() {
        return new ResponseEntity<>(userService.getOperators(), HttpStatus.OK);
    }

    @GetMapping("/globalRating")
    public ResponseEntity<?> getGlobalRating() {
        return new ResponseEntity<>(userService.getRatingUsersForAllTime(), HttpStatus.OK);
    }

    @GetMapping("/weekRating")
    public ResponseEntity<?> getWeekRating() {
        return new ResponseEntity<>(userService.getRatingUsersForWeek(), HttpStatus.OK);
    }

    @GetMapping("/lastAchievements/{userId}")
    public ResponseEntity<?> getLastAchievements(@PathVariable Long userId) {
        try {
            return new ResponseEntity<>(userService.getLastUserAchievements(userId), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/message")
    public ResponseEntity<?> getWelcomeMessage() {
        return new ResponseEntity<>(userService.getWelcomeMessage(), HttpStatus.OK);
    }

}
