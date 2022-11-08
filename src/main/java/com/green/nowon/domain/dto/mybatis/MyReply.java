package com.green.nowon.domain.dto.mybatis;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class MyReply {
    private long rno;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private long bno;       //FK
    private String writer;
    private String text;
}
