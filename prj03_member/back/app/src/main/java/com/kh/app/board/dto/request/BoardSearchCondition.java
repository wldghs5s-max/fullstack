package com.kh.app.board.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSearchCondition {
    private String title;
    private String content;
    private String writerNick;
}
