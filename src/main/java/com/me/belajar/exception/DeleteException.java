package com.me.belajar.exception;

import org.springframework.http.HttpStatus;

public class DeleteException extends BaseErrorException {
    /**
     *
     */
    public DeleteException(Integer id, String modul, String modulRelation) {
        this.setCode("400");
        this.setMessage(modul+" with id " + id.toString()+" can not be deleted because has relation with modul "+modulRelation);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
}
