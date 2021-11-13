package com.visdom.zero_west.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "IMAGE")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="SVG", nullable = false)
    private String svg;

    @Column(name="MAX_LEVEL", nullable = false)
    private Integer maxLevel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_img_id")
    private TypeOfImage typeOfImage;
}
