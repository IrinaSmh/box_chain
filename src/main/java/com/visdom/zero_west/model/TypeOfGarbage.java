package com.visdom.zero_west.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "TYPE_OF_GARBAGE")
public class TypeOfGarbage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="NAME", length = 45, nullable = false)
    private String name;
}
