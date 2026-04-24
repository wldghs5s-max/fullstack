package com.kh.app.board.repository;

import com.kh.app.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    @Query("""
        select b
        from BoardEntity b
        left join fetch b.writer
        where b.delYn = "N"
        order by b.id desc
    """)
    List<BoardEntity> findAllActive();

}
