package se.techinsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
//@EnableScheduling
@SpringBootApplication
public class DevToolsApplication {

    public static void main(String[] args) {
//        SpringApplication.run(String.class, args);
        SpringApplication.run(DevToolsApplication.class, args);
    }

}
