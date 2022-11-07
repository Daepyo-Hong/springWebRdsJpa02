package com.green.nowon.domain.dto.mybatis;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
public class MyBoardDTO {

    private long bno;
    private String title;
    private String content;
    private int readCount;
    private String writer;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}
