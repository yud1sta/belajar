package com.me.belajar.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseErrorException {
    /**
     *
     */
    private static final long serialVersionUID = -5500758039232749808L;

    public NotFoundException(String modul) {
        this.setCode("404");
        this.setMessage(modul+" not found");
        this.setStatus(HttpStatus.EXPECTATION_FAILED);
    }

    public NotFoundException(Integer userId,String modul) {
        this.setCode("404");
        this.setMessage(modul+" not found with id " + userId.toString());
        this.setStatus(HttpStatus.EXPECTATION_FAILED);
    }
}
