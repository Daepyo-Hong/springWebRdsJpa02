package com.green.nowon.service;

import com.green.nowon.domain.dao.MyReplyMapper;
import com.green.nowon.domain.dto.mybatis.MyReply;
import org.apache.ibatis.session.RowBounds;
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
    public int delete(long rno) {
        return mapper.deleteByRno(rno);
        //System.out.println("삭제행 개수 : "+count);
    }

    @Override
    public void update(long rno, String text) {
        mapper.update(rno, text);
    }

    @Override
    public void getList(long bno, Model model) {
        //List<MyReply> replies = mapper.findAllByBno(bno);
        int offset=0;
       ;
        //List<MyReply> replies = mapper.findByBno(bno,offset,size);
        RowBounds rowBounds = new RowBounds(offset, size);
        List<MyReply> replies = mapper.findByBnoAndRowBounds(bno,rowBounds);

        model.addAttribute("list", replies);
    }


    private int size=3;
    @Override
    public void getList(long bno, int page, Model model) {
        int offset=(page-1)*size;
        RowBounds rowBounds = new RowBounds(offset, size);
        List<MyReply> replies = mapper.findByBnoAndRowBounds(bno,rowBounds);

        model.addAttribute("list", replies);
    }

    @Override
    public int getCount(long bno) {
        int rowTotal = mapper.countAll(bno);
        int pageTotal = rowTotal/size;
        if(rowTotal%size>0)pageTotal++;
        return pageTotal;
    }
}
