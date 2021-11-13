package com.visdom.zero_west.dto;

import com.sun.istack.NotNull;
import com.visdom.zero_west.model.Garbage;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GarbageDto {

    @NotNull
    private String name;

    @NotNull
    private Integer count;

//    public GarbageDto(Garbage garbage) {
//        this.id = garbage.getId();
//        this.xp = garbage.getXp();
//        this.coins = garbage.getCoins();
//        this.name = garbage.getName();
//        this.typeOfGarbage = garbage.getTypeOfGarbage().getId();
//    }
}
