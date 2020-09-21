package example.springqualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("example.springqualifier");
        boolean running = context.isRunning();
        System.out.println("isRunning: " + running);

        JekaService jekaService = context.getBean(JekaService.class);
        BaruchService baruchService = context.getBean(BaruchService.class);


        System.out.println("Jeka   " + jekaService.list.toString());
        System.out.println("Baruch " + baruchService.list.toString());

        context.close();
    }

}
