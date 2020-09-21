package se.techinsight;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class DevToolsApplicationTests {

    @Autowired
    private Environment environment;

    @Test
    void contextLoads() {
        String[] activeProfiles = environment.getActiveProfiles();
        for (String prof : activeProfiles) {
            System.out.println("Active profiles '" + prof + "'");
        }
    }

}
