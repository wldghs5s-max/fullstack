package com.kh.app.board.service;

import com.kh.app.board.dto.request.BoardCreateReqDto;
import com.kh.app.board.dto.request.BoardSearchCondition;
import com.kh.app.board.dto.response.BoardRespDto;
import com.kh.app.board.entity.BoardEntity;
import com.kh.app.board.repository.BoardRepository;
import com.kh.app.member.entity.MemberEntity;
import com.kh.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void insert(BoardCreateReqDto dto, String username) {
        MemberEntity memberEntity = memberRepository.findByUsername(username);
        BoardEntity entity = dto.toEntity(memberEntity);
        boardRepository.save(entity);
    }


    public List<BoardRespDto> seletList() {
        return boardRepository
                .selectList()
                .stream()
                .map(BoardRespDto::from)
                .toList();
    }

    public BoardRespDto selectOne(Long id) {
        BoardEntity entity = boardRepository.selectOne(id);
        return BoardRespDto.from(entity);
    }

    @Transactional
    public void delete(Long id, String username) {
        BoardEntity entity = boardRepository.edit(id, username);
        entity.delete();
    }
    @Transactional
    public BoardRespDto update(BoardCreateReqDto dto, Long id, String username) {
        BoardEntity entity = boardRepository.edit(id, username);
        entity.update(dto);
        return BoardRespDto.from(entity);
    }

    public List<BoardRespDto> search(BoardSearchCondition condition) {
        List<BoardEntity> entityList = boardRepository.search(condition);
        return entityList.stream().map(BoardRespDto::from).toList();
    }
}
