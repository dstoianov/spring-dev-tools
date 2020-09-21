package se.techinsight.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

    private static final Logger log = LoggerFactory.getLogger(SecondController.class);

    @GetMapping("/second")
    public String hello() {
        log.info("Print some data");
        return "Hello world - 1245\n";
    }

}
