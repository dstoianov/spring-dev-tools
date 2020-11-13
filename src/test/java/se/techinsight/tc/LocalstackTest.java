package se.techinsight.tc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

import static org.testcontainers.containers.localstack.LocalStackContainer.Service;

@Slf4j
@Testcontainers
@SpringBootTest
class LocalstackTest {

    @Container
    private static LocalStackContainer localstack = new LocalStackContainer().withServices(Service.S3);

    private S3Client s3;

    @BeforeEach
    public void beforeAll() {
        URI endpointOverride = localstack.getEndpointOverride(Service.S3);
        AwsBasicCredentials credentials =
            AwsBasicCredentials.create(localstack.getAccessKey(), localstack.getSecretKey());
        s3 = S3Client.builder()
            .endpointOverride(endpointOverride)
            .credentialsProvider(StaticCredentialsProvider.create(credentials))
            .region(Region.of(localstack.getRegion()))
            .build();
    }

    @Test
    void name() {
        s3.createBucket(b -> b.bucket("foo"));
        s3.putObject(b -> b.bucket("foo").key("bar"), RequestBody.fromBytes("baz".getBytes()));
    }
}
