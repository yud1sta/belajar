package com.me.belajar.service;

import com.me.belajar.dto.RequestBookDTO;
import com.me.belajar.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll();

    //find by single id
    public Book findById (Integer id);

    //Create Book
    public Book save(RequestBookDTO requestBookDTODTO);

    //Update Role
    public Book update(RequestBookDTO requestBookDTODTO, Integer id);

    //delete user by id
    public Book deleteById(Integer id);
}
