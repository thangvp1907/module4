package com.codegym.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idCategory;

    @Column(name = "Ten_danh_muc",columnDefinition = "varchar(50)")
    private String nameCategory;

    @OneToMany(mappedBy="category",cascade = CascadeType.ALL)
    public List<Blog> listBlog;

    public Category() {

    }

    public Category(int idCategory, String nameCategory, List<Blog> listBlog) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.listBlog = listBlog;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Blog> getListBlog() {
        return listBlog;
    }

    public void setListBlog(List<Blog> listBlog) {
        this.listBlog = listBlog;
    }
}
