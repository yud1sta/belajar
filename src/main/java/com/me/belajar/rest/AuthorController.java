package com.me.belajar.rest;

import com.me.belajar.dto.RequestAuthorDTO;
import com.me.belajar.dto.ResponseAuthorCommonDTO;
import com.me.belajar.entity.Author;
import com.me.belajar.service.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@Tag(name = "Author Api")
@RestController
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping("/author")
    public ResponseEntity<ResponseAuthorCommonDTO<List<Author>>> findAll() {
        ResponseAuthorCommonDTO<List<Author>> response = new ResponseAuthorCommonDTO<>();
        try
        {
            List<Author> authorList = authorService.findAll();
            response.success();
            response.setData(authorList);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return new ResponseEntity<>(response ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<ResponseAuthorCommonDTO<Author>> findById(@PathVariable Integer id) {
        ResponseAuthorCommonDTO<Author> response = new ResponseAuthorCommonDTO<>();
        try
        {
            Author author =  authorService.findById(id);
            response.success();
            response.setData(author);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return new ResponseEntity<>(response ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/author")
    // @PreAuthorize("hasAuthority('SUPERVISOR') or hasAuthority('SYSTEMADMIN') or hasAuthority('SUPERADMIN') or hasAuthority('COORDINATOR')")
    public ResponseEntity<ResponseAuthorCommonDTO<Author>> save(@RequestBody RequestAuthorDTO requestAuthorDTO)
    {
        ResponseAuthorCommonDTO<Author> response = new ResponseAuthorCommonDTO<>();

        try
        {
            Author author =  authorService.save(requestAuthorDTO);
            response.success();
            response.setData(author);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/author/{id}")
    // @PreAuthorize("hasAuthority('SUPERVISOR') or hasAuthority('SYSTEMADMIN') or hasAuthority('SUPERADMIN') or hasAuthority('COORDINATOR')")
    public ResponseEntity<ResponseAuthorCommonDTO<Author>> update(@RequestBody RequestAuthorDTO requestAuthorDTO, @PathVariable Integer id)
    {
        ResponseAuthorCommonDTO<Author> response = new ResponseAuthorCommonDTO<>();

        try
        {
            Author author =  authorService.update(requestAuthorDTO,id);
            response.success();
            response.setData(author);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/author/{id}")
    // @PreAuthorize("hasAuthority('SUPERVISOR') or hasAuthority('SYSTEMADMIN') or hasAuthority('SUPERADMIN') or hasAuthority('COORDINATOR')")
    public ResponseEntity<ResponseAuthorCommonDTO<Author>> deleteById(@PathVariable Integer id)
    {
        ResponseAuthorCommonDTO<Author> response = new ResponseAuthorCommonDTO<>();

        try
        {
            Author author =  authorService.deleteById(id);
            response.success();
            response.setData(author);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
