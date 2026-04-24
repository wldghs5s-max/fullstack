package com.kh.app.board.repository;

import com.kh.app.board.dto.request.BoardSearchCondition;
import com.kh.app.board.entity.BoardEntity;
import com.kh.app.board.entity.QBoardEntity;
import com.kh.app.member.entity.QMemberEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private static final QBoardEntity b = QBoardEntity.boardEntity;
    private static final QMemberEntity m = QMemberEntity.memberEntity;
    @Override
    public List<BoardEntity> selectList() {
        return queryFactory
                .selectFrom(b)
                .join(b.writer,m).fetchJoin()
                .where(delYnEqN())
                .orderBy(b.id.desc())
                .fetch();
    }

    @Override
    public BoardEntity selectOne(Long id) {
        return queryFactory
                .selectFrom(b)
                .where(
                        idEq(id),
                        delYnEqN()
                )
                .fetchOne();
    }

    @Override
    public BoardEntity edit(Long id, String username) {
        return queryFactory
                .selectFrom(b)
                .join(b.writer,m)
                .where(
                        b.id.eq(id),
                        writerUsernameEq(username),
                        delYnEqN()
                )
                .fetchOne();
    }

    @Override
    public List<BoardEntity> search(BoardSearchCondition condition) {
        return queryFactory
                .selectFrom(b)
                .join(b.writer,m).fetchJoin()
                .where(
                        titleContains(condition.getTitle()),
                        contentContains(condition.getContent()),
                        writerNickContains(condition.getWriterNick()),
                        delYnEqN()
                )
                .orderBy(b.id.desc())
                .fetch();
    }
    private BooleanExpression delYnEqN(){
        return b.delYn.eq("N");
    }
    private BooleanExpression titleContains(String title){
        return StringUtils.hasText(title) ? b.title.contains(title) : null;
    }
    private BooleanExpression contentContains(String content){

        return StringUtils.hasText(content) ? b.content.contains(content) :null;
    }
    private BooleanExpression writerNickContains(String writerNick){
        return StringUtils.hasText(writerNick) ? m.nick.contains(writerNick) : null;
    }
    private BooleanExpression idEq(Long id){
        return b.id.eq(id);
    }
    private BooleanExpression writerUsernameEq(String writerNick){
        return m.username.eq(writerNick);
    }
}
