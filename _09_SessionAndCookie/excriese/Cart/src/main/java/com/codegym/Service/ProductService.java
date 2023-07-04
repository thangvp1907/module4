package com.codegym.Service;

import com.codegym.Entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    boolean create (Product product);

    Optional<Product> findById(Integer id);


    String saveImage(MultipartFile imgFile) throws IOException;
}
