package com.kh.app.board.service;

import com.kh.app.board.dto.request.BoardCreateReqDto;
import com.kh.app.board.dto.request.BoardSearchCondition;
import com.kh.app.board.dto.response.BoardRespDto;
import com.kh.app.board.entity.BoardEntity;
import com.kh.app.board.repository.BoardRepository;
import com.kh.app.member.entity.MemberEntity;
import com.kh.app.member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public void create(BoardCreateReqDto reqDto, String username) {
        MemberEntity memberEntity = memberRepository
                .findByUsernameAndDelYn(username, "N")
                .orElseThrow(() -> new EntityNotFoundException("MEMBER NOT FOUND .......")
                );
        BoardEntity entity = reqDto.toEntity(memberEntity);
        boardRepository.save(entity);
    }


    public Page<BoardRespDto> getList(BoardSearchCondition condition, int pno) {

        Pageable pageable = PageRequest.of(pno, 10);
        return boardRepository
                .getList(condition,pageable)
                .map(BoardRespDto::from);
    }

    public BoardRespDto getOne(Long id) {
        BoardEntity entity = boardRepository
                .getOneById(id)
                .orElseThrow(EntityNotFoundException::new);
        return BoardRespDto.from(entity);
    }
    @Transactional
    public void remove(Long id, String username) {
        BoardEntity boardEntity = boardRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        if (!boardEntity.getWriter().getUsername().equals(username)){
            throw new AccessDeniedException("check writer...");
        }
        boardEntity.delete();
    }
    @Transactional
    public BoardRespDto update(Long id, BoardCreateReqDto reqDto, String username) {
        BoardEntity boardEntity = boardRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        if (!boardEntity.getWriter().getUsername().equals(username)){
            throw new AccessDeniedException("check writer...");
        }
        boardEntity.update(reqDto);
        return BoardRespDto.from(boardEntity);
    }
}
