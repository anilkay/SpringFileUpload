package com.anilkaynar.kitap.api;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/deneme")
@RestController
public class DenemeController {
    @GetMapping(path = "/adlar")
    public String[] isimler() {
        var log=LoggerFactory.getLogger("Default");
        log.error("Ben Çağırıldım");
        return new String[]{"Anil", "Taurean Prince",
                 "Lebron James", "Carruso"};
        //It looks it's worked.
    }
}
