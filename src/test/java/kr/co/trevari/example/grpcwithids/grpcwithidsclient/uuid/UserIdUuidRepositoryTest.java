package kr.co.trevari.example.grpcwithids.grpcwithidsclient.uuid;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class UserIdUuidRepositoryTest {

    @Autowired
    UserIdUuidRepository repository;

    @Test
    void name() {
        UserIdUuid of = UserIdUuid.of(UUID.randomUUID().toString(), "123");
        repository.save(of);
    }
}
