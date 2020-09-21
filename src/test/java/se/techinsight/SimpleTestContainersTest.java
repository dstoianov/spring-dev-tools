package se.techinsight;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Testcontainers
class SimpleTestContainersTest {


//    private RedisBackedCache underTest;

    // container {
//    @Container
//    public GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
//            .withExposedPorts(6379);
    // }

    //    will be shared between test methods
    @Container
    static final MySQLContainer mySQLContainer = new MySQLContainer<>();

    //    will be started before and stopped after each test method
    @Container
    PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>();
//            .withDatabaseName("test")
//            .withUsername("foo")
//            .withPassword("foo");

//    public GenericContainer container = new GenericContainer(DockerImageName.parse("orientdb:3.0.13"))
//            .withExposedPorts(2424, 2480)
//            .withLogConsumer(new Slf4jLogConsumer(log));
//

//    @BeforeEach
//    public void setUp() {
//        String address = redis.getHost();
//        Integer port = redis.getFirstMappedPort();
//
//        // Now we have an address and port for Redis, no matter where it is running
////        underTest = new RedisBackedCache(address, port);
//    }

    @Test
    void nameTest() {
        assertThat(mySQLContainer.isRunning(), is(true));
        assertThat(postgreSQLContainer.isRunning(), is(true));
    }


    //    @Test
//    public void testSimplePutAndGet() {
//        underTest.put("test", "example");
//
//        String retrieved = underTest.get("test");
//        assertEquals("example", retrieved);
//    }
}
