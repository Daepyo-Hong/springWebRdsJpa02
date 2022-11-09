package com.green.nowon.domain.dao;

import com.green.nowon.domain.dto.mybatis.MyReply;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface MyReplyMapper {

    @Insert("insert into my_reply(text, writer, bno) values(#{text}, #{writer}, #{bno})")
    void save(MyReply dto);

    @Select("select * from my_reply where bno=#{fk} order by rno desc")
    List<MyReply> findAllByBno(@Param("fk") long bno);

    @Delete("delete from my_reply where rno=#{rno}")
    int deleteByRno(long rno);

    @Update("update my_reply set text=#{text} where rno=#{rno}")
    void update(@Param("rno") long rno,@Param("text") String text);

    @Select("select * from my_reply where bno=#{fk} order by rno desc limit #{offset},#{size}")
    List<MyReply> findByBno(@Param("fk") long bno,@Param("offset") int offset,@Param("size") int size);

    @Select("select * from my_reply where bno=#{fk} order by rno desc")
    List<MyReply> findByBnoAndRowBounds(long bno, RowBounds rowBounds);

    @Select("select count(*) from my_reply where bno=#{bno}")
    int countAll(@Param("bno") long bno);
}
