package com.green.nowon.service;

import com.green.nowon.domain.dto.mybatis.MyReply;
import org.springframework.ui.Model;

public interface MyReplyService {

    void save(long bno, MyReply dto);

    void delete(long rno);

    void update(long rno, String text);

    void getList(long bno, Model model);
}
