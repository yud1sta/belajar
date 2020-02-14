package com.me.belajar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBaseDTO<T> {
    private boolean status = false;

    private String code = "500";

    private String message = "internal server error";

    private String currentPage;

    private T data;
}


