package com.visdom.zero_west.dto;

import com.sun.istack.NotNull;
import com.visdom.zero_west.model.Role;
import com.visdom.zero_west.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class UserDto {
    @NotNull
    private Long id;
    @NotNull
    private Integer coins;
    @NotNull
    private Integer xp;
    @NotNull
    private int level;
    private String avatarName;
    private Role role;

    public UserDto(User user) {
        this.id = user.getId();
        this.coins = user.getCoins();
        this.xp = user.getXp();
        this.level = user.getLevel().getId();
        if(user.getAvatar() != null)
            this.avatarName = user.getAvatar().getName();
        this.role = user.getRole();
    }
}
