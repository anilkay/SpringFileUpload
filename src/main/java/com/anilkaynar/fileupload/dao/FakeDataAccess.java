package com.anilkaynar.kitap.dao;

import com.anilkaynar.kitap.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("FakeDAO")
public class FakeDataAccess implements BookDao {
    static List<Book> books=new ArrayList<>();
    static {
        books=new ArrayList<>();
        books.add(new Book("Java ile Nesne Tabanlı Tasrım",300));
        books.add(new Book("Kim Korkad Java'dan",500));
        books.add(new Book("Diğer Kitap",100));
    }
    @Override
    public List<Book> getBooks() {

        return books;
    }
}
