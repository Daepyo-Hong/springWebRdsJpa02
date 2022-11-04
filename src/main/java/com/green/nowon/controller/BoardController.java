package com.green.nowon.controller;

import com.green.nowon.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("/boards")
    public String list(Model model){
        //service.listAll(model);
        service.getListAll(model);
        return "board/list";    //Model 객체는 응답 페이지까지 유효
    }


}
