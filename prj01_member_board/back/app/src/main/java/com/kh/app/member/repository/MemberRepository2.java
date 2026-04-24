//package com.kh.app.member.repository;
//
//import com.kh.app.member.entity.MemberEntity;
//import jakarta.persistence.EntityManager;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//@Repository
//@RequiredArgsConstructor
//public class MemberRepository {
//    private final EntityManager entityManager;
//
//    public void save(MemberEntity entity) {
//        entityManager.persist(entity);
//    }
//
//    public MemberEntity findById(Long id) {
//        return entityManager.find(MemberEntity.class, id);
//    }
//}
