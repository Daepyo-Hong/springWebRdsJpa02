package com.green.nowon.service.board;

import org.springframework.ui.Model;

public interface BoardService {
    void listAll(Model model);

    void getListAll(Model model);
}
