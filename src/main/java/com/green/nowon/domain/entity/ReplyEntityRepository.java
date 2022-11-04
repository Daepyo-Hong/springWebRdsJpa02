package com.green.nowon.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyEntityRepository extends JpaRepository<ReplyEntity, Integer> {

    //쿼리메서드 : 쿼리를 생성해주는 메서드
    List<ReplyEntity> findByBoardBno(int bno);
}
