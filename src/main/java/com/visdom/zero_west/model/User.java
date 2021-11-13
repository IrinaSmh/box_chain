package com.visdom.zero_west.model;

import com.visdom.zero_west.dto.UserRegistrationDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    private Long id;

    @Column(name="COINS")
    private int coins;

    @Column(name="XP")
    private Integer xp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
    private Avatar avatar;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "level_id")
    private Level level;

    @Column(name="UPDATE_RATING")
    private LocalDateTime updateRatingData;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
//    @JoinTable(
//            name = "USER_HAS_ACHIEVEMENT",
//            joinColumns = @JoinColumn(name = "ID_USER", referencedColumnName = "ID"),
//            inverseJoinColumns = @JoinColumn(name = "ID_TYPE_OF_ACHIEVEMENT", referencedColumnName = "ID")
//    )
//    private Map<TypeOfAchievement, Integer> achievements;

    public User(UserRegistrationDto userRegistrationDto, Role role) {
        this.id = userRegistrationDto.getId();
        this.coins = 0;
        this.xp = 0;
        this.avatar = new Avatar(userRegistrationDto.getAvatar());
        this.level = new Level(1, "1 уровень", 0);
        this.role = role;
    }
}
