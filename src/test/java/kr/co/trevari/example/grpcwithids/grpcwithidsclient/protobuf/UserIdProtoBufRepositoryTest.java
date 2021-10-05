package kr.co.trevari.example.grpcwithids.grpcwithidsclient.protobuf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserIdProtoBufRepositoryTest {

    @Autowired
    private IdClient idClient;

    @Autowired
    private UserIdProtoBufRepository repository;

    @Test
    void name() {
        Long aLong = idClient.nextIdClientWithBlockingStub();
        UserIdProtoBuf protoBuf = UserIdProtoBuf.of(aLong, "123");
        repository.save(protoBuf);
    }
}
