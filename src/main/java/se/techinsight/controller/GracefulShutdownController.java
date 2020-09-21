package se.techinsight.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GracefulShutdownController {

    @GetMapping("/fly")
    public String fly() throws InterruptedException {
        Thread.sleep(10_000);
        return "i'm flying...\n";
    }
}
