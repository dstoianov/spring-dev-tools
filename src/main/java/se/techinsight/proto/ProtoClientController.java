package se.techinsight.proto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import se.techinsight.proto.messaging.Country;

import java.net.URI;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProtoClientController {
    private final RestTemplate restTemplate;

    @GetMapping(value = "/api/client")
    public String country() {
        Country country = restTemplate.getForObject("http://localhost:8080/api/country", Country.class);

        log.info("Country: {}", country);
        return "country received..";
    }

    @GetMapping(value = "/api/client/bytes")
    public byte[] countryBytes() {
        RequestEntity<byte[]> requestEntity = new RequestEntity<>(null, HttpMethod.GET,
                URI.create("http://localhost:8080/api/country"),
                byte[].class);

        RestTemplate restTemplateThatDoesntKnowAboutProtobuf = new RestTemplate();
        ResponseEntity<byte[]> exchange = restTemplateThatDoesntKnowAboutProtobuf.exchange(requestEntity, byte[].class);
        log.info("Country: Number of bytes '{}'", exchange.getBody().length);
//        log.info("Bytes " + String.join(" - ", (byte[]) exchange.getBody());

        System.out.println("Begin");

        for (byte b : exchange.getBody()) {
            System.out.print(b + " ");
//            log.info("Wow a byte: " + b);
        }
        System.out.println();
        System.out.println("End");

        return exchange.getBody();
    }
}
