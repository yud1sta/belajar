package com.me.belajar.repository;
//import com.me.belajar.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Integer> {

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.isDeleted is null")
    List<T> findAll();

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.isDeleted is null")
    Page<T> findAll(Pageable pageable);

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.id = ?1 and e.isDeleted is null")
    Optional<T> findById(Integer id);

    @Query("update #{#entityName} e set e.isDeleted=1, e.deleteTime = current_timestamp() where e.id = ?1 ")
    @Modifying
    @Transactional
    void deleteById(Integer id);

//    @Override
//    @Transactional
//    default void delete(T entity) {
//        deleteById(entity.getId());
//    }

    @Query("select e from #{#entityName} e where e.isDeleted = 1")
    @Transactional(readOnly = true)
    List<T> findDeleted();

    @Override
    @Transactional(readOnly = true)
    @Query("select count(e) from #{#entityName} e where e.isDeleted is null")
    long count();

}


