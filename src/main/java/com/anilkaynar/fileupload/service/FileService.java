package com.anilkaynar.kitap.service;

import com.anilkaynar.kitap.dao.FileUploadDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    private final FileUploadDao uploadDao;

    public FileService(@Qualifier("macos") FileUploadDao uploadDao) {
        this.uploadDao = uploadDao;

    }
    public String saveFile(MultipartFile file){
        return uploadDao.saveFile(file);
    }
    public String[] saveFiles(MultipartFile[]files){
        return uploadDao.saveFiles(files);
    }
}
