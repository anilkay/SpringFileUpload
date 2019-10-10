package com.anilkaynar.kitap.service;

import com.anilkaynar.kitap.dao.BookDao;
import com.anilkaynar.kitap.model.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookDao dao;

    public BookService(@Qualifier("FakeDAO") BookDao dao) {
        this.dao = dao;
    }

    public List<Book> getBooks(){
        return dao.getBooks();
    }
}
