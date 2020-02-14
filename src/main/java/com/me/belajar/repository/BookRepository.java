package com.me.belajar.repository;

import com.me.belajar.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BookRepository extends BaseRepository<Book>{
    @Transactional(readOnly = true)
    @Query(value = "select id from book where pengarang_id = ?1 and e.isDeleted is null", nativeQuery = true)
    Optional<Book> findByAuthorId(Integer id);
}
