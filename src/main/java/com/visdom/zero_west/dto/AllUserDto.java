package com.visdom.zero_west.dto;

import com.sun.istack.NotNull;
import com.visdom.zero_west.model.Image;
import com.visdom.zero_west.model.Role;
import com.visdom.zero_west.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AllUserDto {
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
    private List<Image> images;

    public AllUserDto(User user, List<Image> images) {
        this.id = user.getId();
        this.coins = user.getCoins();
        this.xp = user.getXp();
        this.level = user.getLevel().getId();
        if(user.getAvatar() != null)
            this.avatarName = user.getAvatar().getName();
        this.role = user.getRole();
        this.images = images;
    }
}
