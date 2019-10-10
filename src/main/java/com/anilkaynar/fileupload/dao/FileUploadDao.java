package com.anilkaynar.kitap.dao;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadDao {
    public String saveFile(MultipartFile file); //Save File and return
    public String[] saveFiles(MultipartFile[]files);
    public String deleteFile();

}
