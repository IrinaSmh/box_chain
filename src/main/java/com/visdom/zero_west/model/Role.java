package com.visdom.zero_west.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "role")
public class Role {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(name="NAME", length = 45, nullable = false)
    private String name;

    public Role (int id, String name) {
        this.id = id;
        this.name = name;
    }
}
