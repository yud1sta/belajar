package com.me.belajar.rest;

import com.me.belajar.dto.RequestGenreDTO;
import com.me.belajar.dto.ResponseGenreCommonDTO;
import com.me.belajar.entity.Genre;
import com.me.belajar.service.GenreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@Tag(name = "Genre Api")
@RestController
public class GenreController {
    private GenreService genreService;

    @Autowired
    GenreController(GenreService genreService){
        this.genreService = genreService;
    }

    @GetMapping("/genre")
    public ResponseEntity<ResponseGenreCommonDTO<List<Genre>>> findAll() {
        ResponseGenreCommonDTO<List<Genre>> response = new ResponseGenreCommonDTO<>();
        try
        {
            List<Genre> genreList = genreService.findAll();
            response.success();
            response.setData(genreList);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return new ResponseEntity<>(response ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<ResponseGenreCommonDTO<Genre>> findById(@PathVariable Integer id) {
        ResponseGenreCommonDTO<Genre> response = new ResponseGenreCommonDTO<>();
        try
        {
            Genre genre =  genreService.findById(id);
            response.success();
            response.setData(genre);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return new ResponseEntity<>(response ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/genre")
    // @PreGenreize("hasGenreity('SUPERVISOR') or hasGenreity('SYSTEMADMIN') or hasGenreity('SUPERADMIN') or hasGenreity('COORDINATOR')")
    public ResponseEntity<ResponseGenreCommonDTO<Genre>> save(@RequestBody RequestGenreDTO requestGenreDTO)
    {
        ResponseGenreCommonDTO<Genre> response = new ResponseGenreCommonDTO<>();

        try
        {
            Genre genre =  genreService.save(requestGenreDTO);
            response.success();
            response.setData(genre);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/genre/{id}")
    // @PreGenreize("hasGenreity('SUPERVISOR') or hasGenreity('SYSTEMADMIN') or hasGenreity('SUPERADMIN') or hasGenreity('COORDINATOR')")
    public ResponseEntity<ResponseGenreCommonDTO<Genre>> update(@RequestBody RequestGenreDTO requestGenreDTO, @PathVariable Integer id)
    {
        ResponseGenreCommonDTO<Genre> response = new ResponseGenreCommonDTO<>();

        try
        {
            Genre genre =  genreService.update(requestGenreDTO,id);
            response.success();
            response.setData(genre);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/genre/{id}")
    // @PreGenreize("hasGenreity('SUPERVISOR') or hasGenreity('SYSTEMADMIN') or hasGenreity('SUPERADMIN') or hasGenreity('COORDINATOR')")
    public ResponseEntity<ResponseGenreCommonDTO<Genre>> deleteById(@PathVariable Integer id)
    {
        ResponseGenreCommonDTO<Genre> response = new ResponseGenreCommonDTO<>();

        try
        {
            Genre genre =  genreService.deleteById(id);
            response.success();
            response.setData(genre);
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.internalServerError(e.getMessage());
            return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
