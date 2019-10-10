package com.anilkaynar.kitap.dao;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository("macos")
public class FileUpload implements FileUploadDao {
    private static final String abspath = "/Users/anilkaynar/Downloads";

    @Override
    public String saveFile(MultipartFile file) {
        Path path=null;
        try {
            byte[] files = file.getBytes();
            String name = file.getOriginalFilename()+" uploaded" ;
            path=Paths.get(abspath + "/" + name);
            Files.write(path, files);
        } catch (Exception e) {
            e.printStackTrace();
            return "bos";
        }
        return path.toString();
    }

    @Override
    public String[] saveFiles(MultipartFile[] files) {
        int numberOfFiles=files.length;
        String[] filepaths=new String[numberOfFiles];
        int i=0;
        for(MultipartFile file:files){
           String path= saveFile(file);
           filepaths[i++]=path;
        }
        return filepaths;
    }

    @Override
    public String deleteFile() {
        try {
            throw new ExecutionControl.NotImplementedException("Not Implemented");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
