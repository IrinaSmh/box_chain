package com.visdom.zero_west.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AvatarDto {
    @NotNull
    private String name;

    @NotNull
    private String color;
}
