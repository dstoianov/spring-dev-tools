package se.techinsight.config.log;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

public class MdcThreadTaskDecorator implements TaskDecorator {

    @Override
    public Runnable decorate(Runnable runnable) {
        var contextMap = MDC.getCopyOfContextMap();
        return () -> {
            try {
                MDC.setContextMap(contextMap);
                runnable.run();
            } finally {
                MDC.clear();
            }
        };

    }
}
