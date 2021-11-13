package com.visdom.zero_west.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "USER_HAS_ACHIEVEMENT")
public class UserAchievement {
    @EmbeddedId
    private UserAchievementKey id;

    @Column(name = "count", nullable = false)
    private Integer count;

    public UserAchievement(UserAchievementKey id, Integer count) {
        this.id = id;
        this.count = count;
    }
}
