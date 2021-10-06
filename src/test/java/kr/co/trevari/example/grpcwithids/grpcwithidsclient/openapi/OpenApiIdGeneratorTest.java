package kr.co.trevari.example.grpcwithids.grpcwithidsclient.openapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenApiIdGeneratorTest {

    @Autowired
    OpenApiIdGenerator openApiIdGenerator;

    @Test
    void name() {
        Long id = openApiIdGenerator.getId();
        System.out.println(id);
    }
}
