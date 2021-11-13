package com.visdom.zero_west.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class UserAchievementKey implements Serializable {
    @Column(name = "id_type_of_achievement", nullable = false)
    private Integer typeOfAchievementId;

    @Column(name = "id_user", nullable = false)
    private Long userId;

    public UserAchievementKey(Integer typeAchId, Long userId) {
        this.typeOfAchievementId = typeAchId;
        this.userId = userId;
    }
}
