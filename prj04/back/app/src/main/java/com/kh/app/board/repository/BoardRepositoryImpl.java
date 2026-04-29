package com.kh.app.board.repository;

import com.kh.app.board.dto.request.BoardSearchCondition;
import com.kh.app.board.entity.BoardEntity;
import com.kh.app.board.entity.QBoardEntity;
import com.kh.app.member.entity.QMemberEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom{

    private static QBoardEntity b = QBoardEntity.boardEntity;
    private final JPAQueryFactory queryFactory;
    private final QMemberEntity m = QMemberEntity.memberEntity;

    @Override
    public Page<BoardEntity> getList(BoardSearchCondition condition, Pageable pageable) {

        List<BoardEntity> content = queryFactory
                .selectFrom(b)
                .join(b.writer, m).fetchJoin()
                .where(
                        delYnEq(),
                        titleContains(condition.getTitle()),
                        contentContains(condition.getContent()),
                        nickContains(condition.getNick())
                )
                .orderBy(b.id.desc())
                .offset(pageable.getOffset())    //페이징설정
                .limit(pageable.getPageSize())   //페이징설정
                .fetch();
        Long total = queryFactory
                .select(b.count())
                .from(b)
                .join(b.writer,m)
                .where(
                        delYnEq(),
                        titleContains(condition.getTitle()),
                        contentContains(condition.getContent()),
                        nickContains(condition.getNick())
                )
                .fetchOne();
        return new PageImpl<>(content, pageable,total);
    }

    @Override
    public Optional<BoardEntity> getOneById(Long id) {
        return Optional.ofNullable(queryFactory
                .selectFrom(b)
                .where(
                        idEq(id),
                        delYnEq()
                )
                .fetchOne());
    }
    private BooleanExpression idEq(Long id){
        return id == null ? null : b.id.eq(id);
    }
    private BooleanExpression delYnEq(){
        return b.delYn.eq("N");
    }
    private BooleanExpression titleContains(String str){
        return StringUtils.hasText(str) ? b.title.contains(str) : null ;
    }
    private BooleanExpression contentContains(String str){
        return StringUtils.hasText(str) ? b.content.contains(str) : null ;
    }
    private BooleanExpression nickContains(String str){
        return StringUtils.hasText(str) ? m.nick.contains(str) : null ;
    }

}
