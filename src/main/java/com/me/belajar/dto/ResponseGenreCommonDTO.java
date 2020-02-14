package com.me.belajar.dto;

import com.me.belajar.entity.Genre;

import java.util.List;

public class ResponseGenreCommonDTO<T> extends ResponseBaseDTO<T> {
    public void success(String message){
        setStatus(true);
        setCode("200");
        setMessage(message);
    }

    public void success(){
        setStatus(true);
        setCode("200");
        setMessage("success");
    }

    public void internalServerError(String message){
        setStatus(false);
        setCode("500");
        setMessage(message);
    }
}
