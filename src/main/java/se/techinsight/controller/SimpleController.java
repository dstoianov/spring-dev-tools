package se.techinsight.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class SimpleController {

    @GetMapping("/simple")
    public String get() {
        log.info("Simple controller  - GET");
        return "test get test - 15274S\n";
    }

    @Async
    @GetMapping("/async")
    public void getAsync() {
        log.info("Simple async controller  - GET");
//        return "test get test - 15274S\n";
//        my super logic here
    }

}
