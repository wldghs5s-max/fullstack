package com.kh.app.book.repository;

import com.kh.app.book.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByDelYnOrderByIdDesc(String n);

    BookEntity findByIdAndDelYn(Long id, String n);
}
