package com.me.belajar.service;

import com.me.belajar.dto.RequestGenreDTO;
import com.me.belajar.entity.Genre;
import com.me.belajar.exception.NotFoundException;
import com.me.belajar.helper.CopyProperties;
import com.me.belajar.repository.GenreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private GenreRepository genreRepository;

    @Autowired
    GenreServiceImpl(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(Integer id) {
        Genre genre =  genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id,"Genre"));

        return genre;
    }

    @Override
    @Transactional
    public Genre save(RequestGenreDTO requestGenreDTO) {
        Genre genre = new Genre();
        BeanUtils.copyProperties(requestGenreDTO, genre);
        genre.setCreateTime(new Date());
        // save to database
        genreRepository.save(genre);
        return genre;
    }

    @Override
    @Transactional
    public Genre update(RequestGenreDTO requestGenreDTO, Integer id) {
        Genre genre =  genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id,"Genre"));

        BeanUtils.copyProperties(requestGenreDTO, genre, CopyProperties.getNullPropertyNames(requestGenreDTO));
        genre.setUpdateTime(new Date());

        return genreRepository.save(genre);
    }

    @Override
    public Genre deleteById(Integer id) {
        Genre genre =  genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id,"Genre"));

        genre.setDeleteTime(new Date());
        genre.setIsDeleted(1);

        genreRepository.save(genre);
        return  genre;
    }
}
