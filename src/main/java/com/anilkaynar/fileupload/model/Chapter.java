package com.anilkaynar.kitap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;

import java.util.UUID;

@Data

public class Chapter {
    private final UUID id;
    private final String chapterName;

    public Chapter(@JsonProperty("id") UUID id,@JsonProperty("chapterName") String chapterName) {
        this.id = UUID.randomUUID();
        this.chapterName = chapterName;
    }

    public UUID getId() {
        return id;
    }

    public String getChapterName() {
        return chapterName;
    }
}
