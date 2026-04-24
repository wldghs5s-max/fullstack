package com.kh.app.member.service;

import com.kh.app.member.dto.request.MemberJoinReqDto;
import com.kh.app.member.dto.response.MemberResDto;
import com.kh.app.member.entity.MemberEntity;
import com.kh.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public void join(MemberJoinReqDto dto) {
        String encodedPw = encoder.encode(dto.getPassword());
        memberRepository.save(dto.toEntity(encodedPw));
    }

    public MemberResDto findByUsername(String username){
        MemberEntity entity = memberRepository.findByUsername(username);
        return MemberResDto.from(entity) ;
    }
}
