package com.me.belajar.service;

import com.me.belajar.dto.RequestGenreDTO;
import com.me.belajar.entity.Genre;

import java.util.List;

public interface GenreService {
    public List<Genre> findAll();

    //find by single id
    public Genre findById (Integer id);

    //Create Genre
    public Genre save(RequestGenreDTO requestGenreDTODTO);

    //Update Role
    public Genre update(RequestGenreDTO requestGenreDTODTO, Integer id);

    //delete user by id
    public Genre deleteById(Integer id);
}
