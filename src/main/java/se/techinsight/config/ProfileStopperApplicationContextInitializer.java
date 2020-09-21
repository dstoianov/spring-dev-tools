package se.techinsight.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ProfileStopperApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (applicationContext.getEnvironment().getActiveProfiles().length == 0) {
            throw new IllegalStateException("Without profile can't the run, please pass profile to the app");
        }
    }
}
