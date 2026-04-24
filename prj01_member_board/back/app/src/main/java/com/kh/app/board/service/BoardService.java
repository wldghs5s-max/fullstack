package com.kh.app.board.service;

import com.kh.app.board.dto.request.BoardCreateReqDto;
import com.kh.app.board.dto.response.BoardResDto;
import com.kh.app.board.entity.BoardEntity;
import com.kh.app.board.repository.BoardRepository;
import com.kh.app.member.dto.response.MemberResDto;
import com.kh.app.member.entity.MemberEntity;
import com.kh.app.member.repository.MemberRepository;
import com.kh.app.member.service.MemberService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void save(BoardCreateReqDto reqDto) {
        MemberEntity memberEntity = memberRepository.findById(reqDto.getWriterId()).orElseThrow(
                ()->new EntityNotFoundException("MemberEntity NOT FOUND~~~")
        );
        BoardEntity boardEntity = reqDto.toEntity(memberEntity);
        boardRepository.save(boardEntity);
    }

    public BoardResDto findById(Long id) {
         BoardEntity boardEntity =  boardRepository.findById(id).orElseThrow(
                 ()->new EntityNotFoundException("BoardEntity  NOT FOUND~~~")
         );
         return BoardResDto.from(boardEntity);
    }

    public List<BoardResDto> findAll() {
        List<BoardEntity> entityList = boardRepository.findAllActive();
        return entityList.stream()
                .map(BoardResDto::from)
                .toList();
    }
}
