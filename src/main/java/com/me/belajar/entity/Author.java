package com.me.belajar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(name="author")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nama",nullable = false)
    private String nama;

    @Column(name="alamat")
    private String alamat;

    @Column(name="no_hp")
    private String noHp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", updatable = false)
    private Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delete_time")
    private Date deleteTime;

    @Column(name = "is_deleted")
    private Integer isDeleted;

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", alamat=" + alamat +
                ", no hp=" + noHp +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteTime=" + deleteTime +
                ", is deleted=" + isDeleted +
                '}';
    }
}
