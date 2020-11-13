package example.prototypeVSsingleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope(value = "singleton")
@Component
public class T1000 {

    @Autowired
    private T800 t800;

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct singleton - Where is John Connor");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy singleton - Scary sounds");
    }

}
