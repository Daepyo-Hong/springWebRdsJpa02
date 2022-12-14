package com.green.nowon.service;


import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import org.springframework.ui.Model;

public interface MybatisBoardService {
    void list(Model model);

    void save(MyBoardDTO dto);

    void detail(long bno, Model model);

    void delete(long bno);

    void update(long bno, MyBoardDTO dto);
}
