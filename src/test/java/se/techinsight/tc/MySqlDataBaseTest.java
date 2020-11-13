package se.techinsight.tc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

// for only data layer testing
//@ExtendWith(SpringExtension.class)
//@DataJpaTest

@Slf4j
@SpringBootTest
@Testcontainers
class MySqlDataBaseTest {

    @Container
    private static MySQLContainer database = new MySQLContainer();

    @Autowired
    private DataSource dataSource;

    //    @Autowired or
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", database::getJdbcUrl);
        registry.add("spring.datasource.username", database::getUsername);
        registry.add("spring.datasource.password", database::getPassword);
    }

    @Test
    void name() throws SQLException {

        assertThat(dataSource, is(notNullValue()));
        assertThat(jdbcTemplate, is(notNullValue()));
        assertThat(entityManager, is(notNullValue()));

        try (Connection connection = dataSource.getConnection()) {
            log.info("catalog: " + connection.getCatalog());
        }

        log.info("EXECUTING  run: command line runner");
        Query query = entityManager.createNativeQuery("select now() from dual");
        final var resultList = query.getResultList();
        log.info("Current date is: " + resultList.get(0));
    }
}
