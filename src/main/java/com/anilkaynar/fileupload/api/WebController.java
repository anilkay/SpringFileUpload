package com.anilkaynar.kitap.api;

import com.anilkaynar.kitap.model.Book;
import com.anilkaynar.kitap.service.BookService;
import com.anilkaynar.kitap.service.FileService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RequestMapping("/web")
@Controller()
public class WebController {
    public final BookService bookService;
    public final FileService fileService;

    @Autowired
    public WebController(BookService bookService, FileService fileService) {
        this.bookService = bookService;
        this.fileService = fileService;
    }

    @GetMapping
    public String index(ModelMap map) {
        String name = "Gary Payton";
        map.addAttribute("message", name);
        //İt work interestingly.
        List<Book> liste = bookService.getBooks();
        map.addAttribute("books", liste);
        return "index"; //İt is interesting always say 1
        //Evet Böylece işlemi kolayca halletttik.
    }

    @PostMapping(path = "/upload")
    public String result(ModelMap map,@RequestParam("file") MultipartFile file) {
        String filename = file.getName();
        var logger = LoggerFactory.getLogger("default");
        logger.warn(filename + " added");
        //  String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        //        .path("/downloadFile/")
        //      .path(filename)
        //    .toUriString();
        String[] path=new String[1];
        path[0]= fileService.saveFile(file);
        map.addAttribute("files",path);
        return "success";

    }

    @PostMapping(path = "/uploadsingle")
    public String upresult(@RequestParam("file") File file) {
        String filename = file.getName();
        var logger = LoggerFactory.getLogger("default");
        logger.warn(filename + " added");
        //Dosya Geliyor ama herhangi bir servis olmadığı için öylece kalıyor.
        return "success";
    }

    @PostMapping(path = "/uploadmultifile")
    public String upMultiFile(ModelMap map, @RequestParam("file") MultipartFile[] multipartFiles) {
        var logger = LoggerFactory.getLogger("default");
        logger.warn("How many: " + multipartFiles.length);
        //Hiç bir file gelmiyor. Demekki basitçe array vererek bu işi halledemiyoruz.
        // for (MultipartFile multipartfile:
        //    multipartFiles) {
        //  fileService.saveFile(multipartfile);
        //}
        String[] filepaths = fileService.saveFiles(multipartFiles);
        map.addAttribute("files", filepaths);
        return "success";
        //Spring boot is too logical man. Literally akıyor.
    }
    //İt's worked just fine. 
}
