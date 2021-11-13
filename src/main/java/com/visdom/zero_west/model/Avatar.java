package com.visdom.zero_west.model;

import com.visdom.zero_west.dto.AvatarDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "AVATAR")
public class Avatar {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name="NAME", length = 45, nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name="COLOR", nullable = false)
    private String color;

    public Avatar(AvatarDto avatarDto) {
        this.color = avatarDto.getColor();
        this.name = avatarDto.getName();
    }
}
