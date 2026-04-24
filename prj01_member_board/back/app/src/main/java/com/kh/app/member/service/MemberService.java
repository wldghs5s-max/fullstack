package com.kh.app.member.service;

import com.kh.app.member.dto.request.MemberJoinReqDto;
import com.kh.app.member.dto.response.MemberResDto;
import com.kh.app.member.entity.MemberEntity;
import com.kh.app.member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void join(MemberJoinReqDto reqDto) {
        MemberEntity entity = reqDto.toEntity();
        memberRepository.save(entity);

    }

    public MemberResDto findById(Long id) {
        MemberEntity entity = memberRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("그런 회원 없음")
        );
        return MemberResDto.from(entity);
    }
}
