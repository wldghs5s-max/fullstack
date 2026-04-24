package com.kh.app.member.repository;

import com.kh.app.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity , Long> {

    MemberEntity findByUsername(String username);

}
