package com.anilkaynar.kitap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Book {
    private final UUID id;
    private final String name;
    private final int pagenumber;

    public Book(@JsonProperty("id") UUID id,@JsonProperty("name") String name,@JsonProperty("pagenumber") int pagenumber) {
        this.id = id;
        this.name = name;
        this.pagenumber = pagenumber;
    }

    public Book(String name, int pagenumber) {
        this.id=UUID.randomUUID();
        this.name = name;
        this.pagenumber = pagenumber;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPagenumber() {
        return pagenumber;
    }
}
