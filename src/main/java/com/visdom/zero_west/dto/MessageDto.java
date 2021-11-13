package com.visdom.zero_west.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MessageDto {
    @NotNull
    private String text;

    public MessageDto(String text) {
        this.text = text;
    }
}
