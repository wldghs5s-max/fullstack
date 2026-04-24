//package com.kh.app.board.repository;
//
//import com.kh.app.board.entity.BoardEntity;
//import jakarta.persistence.EntityManager;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class BoardRepository {
//    private final EntityManager em;
//    public void save(BoardEntity entity) {
//        em.persist(entity);
//    }
//
//    public BoardEntity findById(Long id) {
//        String jpql = """
//                select b from BoardEntity b join fetch b.writer where b.delYn = 'N' and b.id = :id
//                """;
//        return em.createQuery(jpql, BoardEntity.class)
//                .setParameter("id",id)
//                .getSingleResult();
//    }
//
//    public List<BoardEntity> findAll() {
//        String jpql = """
//                select b
//                from BoardEntity b
//                join fetch b.writer
//                where b.delYn = 'N'
//                order by b.id desc
//                """;
//        return em.createQuery(jpql, BoardEntity.class).getResultList();
//    }
//}
