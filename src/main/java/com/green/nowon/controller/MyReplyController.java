package com.green.nowon.controller;

import com.green.nowon.domain.dto.mybatis.MyReply;
import com.green.nowon.service.MyReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyReplyController {

    @Autowired
    private MyReplyService service;


    @ResponseBody
    @GetMapping("/mybatis/boards/{bno}/count")
    public int count(@PathVariable long bno){
        return service.getCount(bno);
    }

    //댓글 모두 읽어오기
    @GetMapping("/mybatis/boards/{bno}/replies")
    public String replies(@PathVariable long bno, int page, Model model){
        System.out.println("page : "+page);
        service.getList(bno,page ,model);
        //@ResponseBody 는 값을 전달하는 것임,
        return "board/replies"; //응답을 다른 페이지로 처리(HTML 페이지 결과 페이지)
    }
    //댓글등록
    @ResponseBody   //단일데이터, 객체, 등등 으로 값을 보낼(void로 응답할) 수 있음
                    //자바스크립트 데이터 JSON(키:벨류) 로 자동 변환해줌(ajax success 함수로)
    @PostMapping("/mybatis/boards/{bno}/reply")
    public boolean save(@PathVariable long bno, MyReply dto) {
        service.save(bno, dto);
        return true;
    }

    //댓글삭제
    @ResponseBody
    @DeleteMapping("/mybatis/boards/{bno}/reply/{rno}")
    public int delete(@PathVariable long bno, @PathVariable long rno){
        return service.delete(rno);
    }

    @ResponseBody       //응답데이터는 void지만 정상적으로 처리되고 응답하였다는걸 의미(ajax success함수실행)
    @PutMapping("/mybatis/boards/{bno}/reply/{rno}")
    public void update(@PathVariable long bno, @PathVariable long rno, String text){
        service.update(rno, text);
        //return "redirect:/mybatis/boards/" + bno;
    }
}
