package example.springqualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JekaConfig {

    @Bean
    @JekaQualifier
    public List<String> messages() {
        List<String> strings = new ArrayList<>();
        strings.add("Groovy1");
        strings.add("Spring1");
        return strings;
    }
}
