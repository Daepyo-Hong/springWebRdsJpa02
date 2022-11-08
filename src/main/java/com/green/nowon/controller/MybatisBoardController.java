package com.green.nowon.controller;

import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import com.green.nowon.service.MybatisBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //상세페이지 요청
    @GetMapping("/mybatis/boards/{bno}")
    public String detail(@PathVariable long bno, Model model){
        service.detail(bno, model);
        return "board/detail";
    }

    //삭제처리 요청
    @DeleteMapping("/mybatis/boards/{bno}")
    public String delete(@PathVariable long bno){
        service.delete(bno);
        return "redirect:/mybatis/boards";      //get요청방식으로
    }
    //수정처리 요청
    @PutMapping("/mybatis/boards/{bno}")
    public String update(@PathVariable long bno, MyBoardDTO dto){
        //bno : 수정할 대상PK, dto : 수정할 데이터
        service.update(bno, dto);
        return "redirect:/mybatis/boards/"+bno; //get요청방식으로 -default-mode
    }
}
