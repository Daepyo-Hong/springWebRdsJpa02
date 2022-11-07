package com.green.nowon.domain.dao;

import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyBoardMapper {

    @Select("select * from my_board")
    List<MyBoardDTO> findAll();

    @Insert("insert into my_board(title, content, writer) " +
            "values(#{title}, #{content}, #{writer}) ")
    void save(MyBoardDTO obj);
}
