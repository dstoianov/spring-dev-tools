package example.prototypeVSsingleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope(value = "prototype")
@Component
public class T800 {

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct prototype - Give me your clothes");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy prototype - Hasta la vista, baby");
    }
}
