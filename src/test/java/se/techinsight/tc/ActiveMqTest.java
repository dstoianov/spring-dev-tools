package se.techinsight.tc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.jms.Message;
import java.util.Map;

@Slf4j
@Testcontainers
@SpringBootTest
class ActiveMqTest {

    @Container
    private static GenericContainer<?> activeMQContainer = new GenericContainer<>("rmohr/activemq:latest")
        .withExposedPorts(61616, 8161);
// 61616 JMS
// 8161  UI

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.activemq.broker-url", () -> "tcp://localhost:" + activeMQContainer.getMappedPort(61616));
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    static void beforeAll() {
        log.info("61616 JMS is now: {}", activeMQContainer.getMappedPort(61616));
        log.info("8161  UI  is now: {}", activeMQContainer.getMappedPort(8161));
    }

    @Test
    void name() throws JsonProcessingException, InterruptedException {
        var map = Map.of("field", "data message");
        String message = objectMapper.writeValueAsString(map);
        jmsTemplate.convertAndSend("deu.local.message", message);
        Thread.sleep(3_000);

        Message receive = jmsTemplate.receive("deu.local.message");
        System.out.println(receive);
    }
}
