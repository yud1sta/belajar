package com.me.belajar.dto;

import com.me.belajar.entity.Author;

import java.util.List;

public class ResponseAuthorCommonDTO<T> extends ResponseBaseDTO<T> {
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
