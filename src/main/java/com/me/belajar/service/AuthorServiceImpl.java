package com.me.belajar.service;

import com.me.belajar.dto.RequestAuthorDTO;
import com.me.belajar.entity.Author;
import com.me.belajar.entity.Book;
import com.me.belajar.exception.DeleteException;
import com.me.belajar.exception.NotFoundException;
import com.me.belajar.helper.CopyProperties;
import com.me.belajar.repository.AuthorRepository;
import com.me.belajar.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Author> findAll() {
      return authorRepository.findAll();
    }

    @Override
    public Author findById(Integer id) {
        Author author =  authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id,"Author"));

        return author;
    }

    @Override
    @Transactional
    public Author save(RequestAuthorDTO requestAuthorDTO) {
        Author author = new Author();
        BeanUtils.copyProperties(requestAuthorDTO, author);
        author.setCreateTime(new Date());
        // save to database
        authorRepository.save(author);
        return author;
    }

    @Override
    @Transactional
    public Author update(RequestAuthorDTO requestAuthorDTO, Integer id) {
        Author author =  authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id,"Author"));

        // copy field from request to entity if not null
        BeanUtils.copyProperties(requestAuthorDTO, author, CopyProperties.getNullPropertyNames(requestAuthorDTO));
        author.setUpdateTime(new Date());

        return authorRepository.save(author);
    }

    @Override
    public Author deleteById(Integer id) {
        Author author =  authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id,"Author"));

        Book book =  bookRepository.findByAuthorId(id)
                .orElseThrow(() -> new DeleteException(id,"Author","Book"));

        author.setDeleteTime(new Date());
        author.setIsDeleted(1);

        authorRepository.save(author);
        return  author;
    }

//    @Override
//    public Author updateById(int theId) {
//        return null;
//    }
}
