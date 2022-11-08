package com.green.nowon.domain.dao;

import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MyBoardMapper {

//    @Select("select * from my_board")
    List<MyBoardDTO> findAll();

//    @Insert("insert into my_board(title, content, writer) " +
//            "values(#{title}, #{content}, #{writer}) ")
    void save(MyBoardDTO obj);

//    @Select("select * from my_board where bno=#{bno}")
    MyBoardDTO findByBno(long bno);

//    @Delete("delete from my_board where bno=#{bno}")
    void deleteByBno(long bno);

//    @Update("update my_board set title=#{title}, content=#{content} where bno=#{bno}")
    void updateByBno(MyBoardDTO dto);
}
