package com.visdom.zero_west.dto;

import com.sun.istack.NotNull;
import com.visdom.zero_west.model.Avatar;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRegistrationDto {
    @NotNull
    private Long id;
    private AvatarDto avatar;
    @NotNull
    private int roleId;
}
