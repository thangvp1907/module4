package com.codegym.Service.impl;

import com.codegym.Entity.Product;
import com.codegym.Repository.ProductRepository;
import com.codegym.Service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean create(Product product) {
        productRepository.save(product);
        return true;
    }

    @Override
    public Optional<Product> findById(Integer id)    {
        return productRepository.findById(id);
    }

    @Override
    public String saveImage(MultipartFile imgFile) throws IOException {
        String folder = "D:\\photos";
        byte[] bytes = imgFile.getBytes();
        Path path = Paths.get(folder + imgFile.getOriginalFilename());
        FileCopyUtils.copy(bytes,new File("D:\\photos"));
        Files.write(path,bytes);
        return folder;
    }
}
