package se.techinsight.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;


public class DevProfileResolverEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (environment.getActiveProfiles().length == 0) {
            if (System.getProperty("os.name").contains("Mac OS")) {
                environment.addActiveProfile("PROD"); // DEV, PROD
            }
        }
    }
}
