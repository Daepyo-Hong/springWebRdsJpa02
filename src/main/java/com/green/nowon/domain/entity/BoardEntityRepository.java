package com.green.nowon.domain.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity,Integer> {

    @Query("select b from BoardEntity b")
    List<BoardEntity> myFindAll();
}
