package com.visdom.zero_west.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "ACHIEVEMENT")
public class Achievement {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private int count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_of_achievement")
    private TypeOfAchievement typeOfAchievement;
}
