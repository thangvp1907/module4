package com.codegym.Entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tac_gia" ,columnDefinition = "varchar(50)")
    private String author;
    @Column(name = "nhan_xet" ,columnDefinition = "varchar(50)")
    private String feedBack;
    @Column(name = "thang_diem" ,columnDefinition = "varchar(50)")
    private String rating;

    @Column(name = "luot_thich" ,columnDefinition = "int")
    private int like;
    @Column(name = "ngay_thang" ,columnDefinition = "varchar(50)")
    private String date;

    public Picture() {

    }

    public Picture(int id, String author, String feedBack, String rating, int like, String date) {
        this.id = id;
        this.author = author;
        this.feedBack = feedBack;
        this.rating = rating;
        this.like = like;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        this.date = today.format(formatter);
    }
}
