package com.me.belajar.service;

import com.me.belajar.dto.RequestAuthorDTO;
import com.me.belajar.dto.ResponseAuthorCommonDTO;

import java.util.List;

public interface BookService {
    public List<BookService> findAll();

    //find by single id
    public BookService findById(int theId);

    //Create Author
    public void save(RequestAuthorDTO requestAuthorDTODTO, ResponseAuthorCommonDTO responseAuthorDTO);

    //Update Role
    public void update(RequestAuthorDTO requestAuthorDTODTO);

    //delete user by id
    public void deleteById(RequestAuthorDTO requestAuthorDTODTO, ResponseAuthorCommonDTO responseAuthorDTO);

//    public BookService updateById(int theId);
}
