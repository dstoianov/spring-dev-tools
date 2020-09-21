package example.prototypeVSsingleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("example.prototypeVSsingleton");
        context.close();
    }
}
