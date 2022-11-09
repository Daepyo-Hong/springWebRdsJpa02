package com.green.nowon.domain.dao;

import com.green.nowon.domain.dto.mybatis.MyReply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MyReplyMapper {

    @Insert("insert into my_reply(text, writer, bno) values(#{text}, #{writer}, #{bno})")
    void save(MyReply dto);

    @Select("select * from my_reply where bno=#{fk} order by rno desc")
    List<MyReply> findByBno(@Param("fk") long bno);

    @Delete("delete from my_reply where rno=#{rno}")
    int deleteByRno(long rno);

    @Update("update my_reply set text=#{text} where rno=#{rno}")
    void update(long rno, String text);
}
