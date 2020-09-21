package se.techinsight.proto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.techinsight.proto.messaging.Country;

@Slf4j
@RestController
public class ProtoController {

    @GetMapping(value = "/api/country", produces = "application/x-protobuf")
    public Country country() {
        Country country = Country.newBuilder()
                .setCode("UA")
                .setName("Ukraine")
                .build();

        log.info("Request come... ByteArray:  {}", country.toByteArray());
        log.info("Request come... ByteString: {}", country.toByteString());
        return country;

    }
}
