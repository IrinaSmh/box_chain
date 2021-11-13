package com.visdom.zero_west.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "MESSAGE")
public class Message {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(name="TEXT", nullable = false)
    private String text;

    public Message(Integer id, String text) {
        this.id = id;
        this.text = text;
    }
}
