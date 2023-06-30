package com.codegym.Service;

import com.codegym.Entity.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface iServiceMusic {
    List<Music> findAll();

    Music findById(int id);

    void create(Music music);

    void delete(int id);

    void write(MultipartFile file, Path dir);

}
