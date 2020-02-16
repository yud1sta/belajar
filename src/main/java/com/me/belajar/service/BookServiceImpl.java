package com.me.belajar.service;

import com.me.belajar.dto.RequestBookDTO;
import com.me.belajar.entity.Author;
import com.me.belajar.entity.Book;
import com.me.belajar.entity.Genre;
import com.me.belajar.exception.NotFoundException;
import com.me.belajar.helper.CopyProperties;
import com.me.belajar.repository.AuthorRepository;
import com.me.belajar.repository.BookRepository;
import com.me.belajar.repository.GenreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private GenreRepository genreRepository;

    @Autowired
    BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        Book book =  bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id,"Book"));

        return book;
    }

    @Override
    @Transactional
    public Book save(RequestBookDTO requestBookDTO) {
        // if author doesnt exist throw exception
        Author author =  authorRepository.findById(requestBookDTO.getPengarang_id())
                .orElseThrow(() -> new NotFoundException(requestBookDTO.getPengarang_id(),"Author"));

        Book book = new Book();
        BeanUtils.copyProperties(requestBookDTO, book);
        book.setCreateTime(new Date());
        book.setAuthor(author);

        for (Integer genreId : requestBookDTO.getGenres()){
            // if genre doesnt exist throw exception
            Genre genre =  genreRepository.findById(genreId)
                    .orElseThrow(() -> new NotFoundException(genreId,"Genre"));
            book.getGenres().add(genre);
            genre.getBooks().add(book);
        }

        // save to database
        bookRepository.save(book);
        return book;
    }

    @Override
    @Transactional
    public Book update(RequestBookDTO requestBookDTO, Integer id) {
        Book book =  bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id,"Book"));

        Author author =  authorRepository.findById(requestBookDTO.getPengarang_id())
                .orElseThrow(() -> new NotFoundException(requestBookDTO.getPengarang_id(),"Author"));

        BeanUtils.copyProperties(requestBookDTO, book,CopyProperties.getNullPropertyNames(requestBookDTO));
        book.setUpdateTime(new Date());
        book.setAuthor(author);
        // remove all relation before insert
        for (Genre g: book.getGenres()){
            g.getBooks().remove(book);
            book.getGenres().remove(g);
        }

        for (Integer genreId : requestBookDTO.getGenres()){
//             if genre doesnt exist throw exception
            Genre genre =  genreRepository.findById(2)
                    .orElseThrow(() -> new NotFoundException(genreId,"Genre"));
            book.getGenres().add(genre);
            genre.getBooks().add(book);
        }


        bookRepository.save(book);
        return book;
    }

    @Override
    public Book deleteById(Integer id) {
        Book book =  bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id,"Book"));

        book.setDeleteTime(new Date());
        book.setIsDeleted(1);

        bookRepository.save(book);
        return  book;
    }
}
