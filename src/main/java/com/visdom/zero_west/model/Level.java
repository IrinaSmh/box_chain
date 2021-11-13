package com.visdom.zero_west.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "LEVEL")
public class Level {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(name="NAME", length = 45, nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name="MIN_XP", nullable = false)
    private Integer minXp;

    public Level(Integer id, String name, Integer minXp) {
        this.id = id;
        this.name = name;
        this.minXp = minXp;
    }
}
