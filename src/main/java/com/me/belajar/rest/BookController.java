package com.me.belajar.rest;

import com.me.belajar.dto.RequestBookDTO;
import com.me.belajar.dto.ResponseBookCommonDTO;
import com.me.belajar.entity.Book;
import com.me.belajar.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@Tag(name = "Book Api")
@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public ResponseEntity<ResponseBookCommonDTO<List<Book>>> findAll() {
        ResponseBookCommonDTO<List<Book>> response = new ResponseBookCommonDTO<>();
        try
        {
            List<Book> bookList = bookService.findAll();
            response.success();
            response.setData(bookList);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return new ResponseEntity<>(response ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<ResponseBookCommonDTO<Book>> findById(@PathVariable Integer id) {
        ResponseBookCommonDTO<Book> response = new ResponseBookCommonDTO<>();
        try
        {
            Book book =  bookService.findById(id);
            response.success();
            response.setData(book);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return new ResponseEntity<>(response ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/book")
    // @PreBookize("hasBookity('SUPERVISOR') or hasBookity('SYSTEMADMIN') or hasBookity('SUPERADMIN') or hasBookity('COORDINATOR')")
    public ResponseEntity<ResponseBookCommonDTO<Book>> save(@RequestBody RequestBookDTO requestBookDTO)
    {
        ResponseBookCommonDTO<Book> response = new ResponseBookCommonDTO<>();

        try
        {
            Book book =  bookService.save(requestBookDTO);
            response.success();
            response.setData(book);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/book/{id}")
    // @PreBookize("hasBookity('SUPERVISOR') or hasBookity('SYSTEMADMIN') or hasBookity('SUPERADMIN') or hasBookity('COORDINATOR')")
    public ResponseEntity<ResponseBookCommonDTO<Book>> update(@RequestBody RequestBookDTO requestBookDTO, @PathVariable Integer id)
    {
        ResponseBookCommonDTO<Book> response = new ResponseBookCommonDTO<>();

        try
        {
            Book book =  bookService.update(requestBookDTO,id);
            response.success();
            response.setData(book);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/book/{id}")
    // @PreBookize("hasBookity('SUPERVISOR') or hasBookity('SYSTEMADMIN') or hasBookity('SUPERADMIN') or hasBookity('COORDINATOR')")
    public ResponseEntity<ResponseBookCommonDTO<Book>> deleteById(@PathVariable Integer id)
    {
        ResponseBookCommonDTO<Book> response = new ResponseBookCommonDTO<>();

        try
        {
            Book book =  bookService.deleteById(id);
            response.success();
            response.setData(book);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
