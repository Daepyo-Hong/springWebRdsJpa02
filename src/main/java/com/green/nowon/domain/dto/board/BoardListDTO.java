package com.green.nowon.domain.dto.board;

import com.green.nowon.domain.entity.BoardEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class BoardListDTO {
    private int bno;
    private String title;
    private int readCount;
    private String writer;
    private LocalDateTime updatedDate;


    //BoardEntity 객체를 매개변수로 하는 생성자
    public BoardListDTO(BoardEntity e) {
        bno=e.getBno();
        title=e.getTitle();
        readCount=e.getReadCount();
        writer=e.getWriter();
        updatedDate=e.getUpdatedDate();
    }
}
