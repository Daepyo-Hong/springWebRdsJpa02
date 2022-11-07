package com.green.nowon.service.board;

import com.green.nowon.domain.dao.MyBoardMapper;
import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import com.green.nowon.service.MybatisBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class MybatisBoardServiceProcess  implements MybatisBoardService {

    //Mybatis를 이용한 DB : DAO 역할-Mapper

    @Autowired
    MyBoardMapper mapper;

    @Override
    public void list(Model model) {

        List<MyBoardDTO> result =  mapper.findAll();

        model.addAttribute("list",result);
    }

    @Override
    public void save(MyBoardDTO dto) {
        mapper.save(dto);
    }

    //상세페이지 처리
    @Override
    public void detail(long bno, Model model) {
        MyBoardDTO result = mapper.findByBno(bno);
        model.addAttribute("detail",result);
    }

    @Override
    public void delete(long bno) {
        mapper.deleteByBno(bno);
    }
}
