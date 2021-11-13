package com.visdom.zero_west.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TYPE_OF_IMAGE")
public class TypeOfImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="NAME", length = 45, nullable = false)
    private String name;
}
