package com.me.belajar.service;

import com.me.belajar.dto.RequestAuthorDTO;
import com.me.belajar.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public List<Author> findAll();

    //find by single id
    public Author findById (Integer id);

    //Create Author
    public Author save(RequestAuthorDTO requestAuthorDTODTO);

    //Update Role
    public Author update(RequestAuthorDTO requestAuthorDTODTO, Integer id);

    //delete user by id
    public Author deleteById(Integer id);

//    public Author updateById(int theId);
}
