package com.codegym.Entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Setter
@Getter
@Validated
public class Product implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Size(min = 5, max = 50, message = "Tên sản phẩm quá dài")
    @NotBlank(message = "Tên không được để trống!!")
    private String nameProduct;

    @NotNull(message = "Giá không được để trống!!")
    @Min(100000)
    private double price;

    @NotBlank(message = "Trạng thái không được để trống!!")
    private String status;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        Double price = product.getPrice();
        if (price == null) {
            errors.rejectValue("price", "null"
                    , null, "content không được để trống");
        }
        String name = product.getNameProduct();
        if (name == null) {
            errors.rejectValue("name", "null"
                    , null, "name  không được để trống");
        }
    }
}
