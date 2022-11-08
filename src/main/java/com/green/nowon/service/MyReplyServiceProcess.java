package com.green.nowon.service;

import com.green.nowon.domain.dao.MyReplyMapper;
import com.green.nowon.domain.dto.mybatis.MyReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class MyReplyServiceProcess implements MyReplyService {


    @Autowired
    private MyReplyMapper mapper;
    @Override
    public void save(long bno, MyReply dto) {
        dto.setBno(bno);
        mapper.save(dto);

    }

    @Override
    public void delete(long rno) {
        mapper.deleteByRno(rno);
    }

    @Override
    public void update(long rno, String text) {
        mapper.update(rno, text);
    }

    @Override
    public void getList(long bno, Model model) {
        List<MyReply> replies = mapper.findByBno(bno);
        model.addAttribute("list", replies);
    }
}
