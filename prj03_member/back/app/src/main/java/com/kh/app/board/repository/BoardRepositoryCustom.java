package com.kh.app.board.repository;

import com.kh.app.board.dto.request.BoardSearchCondition;
import com.kh.app.board.entity.BoardEntity;

import java.util.List;

public interface BoardRepositoryCustom {
    List<BoardEntity> selectList();

    BoardEntity selectOne(Long id);

    BoardEntity edit(Long id, String username);

    List<BoardEntity> search(BoardSearchCondition condition);
}
