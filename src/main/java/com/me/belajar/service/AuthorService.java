package com.me.belajar.service;

import com.me.belajar.dto.RequestAuthorDTO;
import com.me.belajar.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public List<Author> findAll();

    //find by single id
    public Author findById (int theId);

    //Create Author
    public Author save(RequestAuthorDTO requestAuthorDTODTO);

    //Update Role
    public Author update(RequestAuthorDTO requestAuthorDTODTO);

    //delete user by id
    public Author deleteById(RequestAuthorDTO requestAuthorDTODTO);

    public Author updateById(int theId);
}
