package com.green.nowon.controller;

import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import com.green.nowon.service.MybatisBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MybatisBoardController {

    @Autowired
    private MybatisBoardService service ;

    @GetMapping("/mybatis/boards/registration")
    public String write(){
        return "board/mybatis-write";
    }

    @GetMapping("/mybatis/boards")
    public String list(Model model){
        service.list(model);
        return "board/list";
    }

    @PostMapping("/mybatis/boards")
    public String save(MyBoardDTO dto){
        service.save(dto);
        return "redirect:/mybatis/boards";  //get요청방식으로 .
    }
}
