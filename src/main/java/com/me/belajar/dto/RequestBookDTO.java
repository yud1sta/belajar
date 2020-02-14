package com.me.belajar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.me.belajar.entity.Author;
import com.me.belajar.entity.Genre;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

public class RequestBookDTO {

    private Integer id;
    private String judul;
    private Integer jumlahHalaman;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT+7")
    private Date tanggalTerbit;

    private String deskripsi;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Date create_time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Date update_time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Date delete_time;

    private Integer is_deleted;
}
