package com.green.nowon.controller;

import com.green.nowon.domain.dto.mybatis.MyReply;
import com.green.nowon.service.MyReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class MyReplyController {

    @Autowired
    private MyReplyService service;

    @PostMapping("/mybatis/boards/{bno}/reply")
    public String save(@PathVariable long bno, MyReply dto) {

        service.save(bno, dto);

        return "redirect:/mybatis/boards/" + bno;
    }

    @DeleteMapping("/mybatis/boards/{bno}/reply/{rno}")
    public String delete(@PathVariable long bno, @PathVariable long rno){
        service.delete(rno);
        return "redirect:/mybatis/boards/" + bno;
    }

    @PutMapping("/mybatis/boards/{bno}/reply/{rno}")
    public String update(@PathVariable long bno, @PathVariable long rno, String text){
        service.update(rno, text);
        return "redirect:/mybatis/boards/" + bno;
    }
}
