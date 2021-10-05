package kr.co.trevari.example.grpcwithids.grpcwithidsclient.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserIdAutoRepositoryTest {

    @Autowired
    private UserIdRepository repository;

    @Test
    void name() {
        UserIdAuto entity = UserIdAuto.of("name");
        repository.save(entity);
    }
}
