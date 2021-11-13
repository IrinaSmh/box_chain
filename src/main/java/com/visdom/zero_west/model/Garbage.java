package com.visdom.zero_west.model;

import com.visdom.zero_west.dto.GarbageDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "GARBAGE")
public class Garbage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="NAME", length = 45, nullable = false)
    private String name;

    @Column(name="XP", nullable = false)
    private Integer xp;

    @Column(name="COINS", nullable = false)
    private Integer coins;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_of_garbage")
    private TypeOfGarbage typeOfGarbage;

//    public Garbage(GarbageDto garbageDto) {
//        this.id = garbageDto.getId();
//        this.name = garbageDto.getName();
//        this.xp = garbageDto.getXp();
//        this.coins = garbageDto.getCoins();
//    }
}
