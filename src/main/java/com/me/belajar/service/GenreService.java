package com.me.belajar.service;

import com.me.belajar.dto.RequestAuthorDTO;
import com.me.belajar.dto.ResponseAuthorCommonDTO;

import java.util.List;

public interface GenreService {
    public List<GenreService> findAll();

    //find by single id
    public GenreService findById(int theId);

    //Create Author
    public void save(RequestAuthorDTO requestAuthorDTODTO, ResponseAuthorCommonDTO responseAuthorDTO);

    //Update Role
    public void update(RequestAuthorDTO requestAuthorDTODTO);

    //delete user by id
    public void deleteById(RequestAuthorDTO requestAuthorDTODTO, ResponseAuthorCommonDTO responseAuthorDTO);

//    public GenreService updateById(int theId);
}
