package kr.co.trevari.example.grpcwithids.grpcwithidsclient;

import kr.co.trevari.example.grpcwithids.grpcwithidsclient.domain.UserIdAuto;
import kr.co.trevari.example.grpcwithids.grpcwithidsclient.domain.UserIdRepository;
import kr.co.trevari.example.grpcwithids.grpcwithidsclient.openapi.OpenApiIdGenerator;
import kr.co.trevari.example.grpcwithids.grpcwithidsclient.openapi.UserIdOpenApiId;
import kr.co.trevari.example.grpcwithids.grpcwithidsclient.openapi.UserIdOpenApiRepository;
import kr.co.trevari.example.grpcwithids.grpcwithidsclient.protobuf.IdClient;
import kr.co.trevari.example.grpcwithids.grpcwithidsclient.protobuf.UserIdProtoBuf;
import kr.co.trevari.example.grpcwithids.grpcwithidsclient.protobuf.UserIdProtoBufRepository;
import kr.co.trevari.example.grpcwithids.grpcwithidsclient.uuid.UserIdUuid;
import kr.co.trevari.example.grpcwithids.grpcwithidsclient.uuid.UserIdUuidRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
public class IdGeneratorPerformanceTest {

    @Autowired
    private IdClient idClient;

    @Autowired
    private UserIdProtoBufRepository protoBufRepository;

    @Test
    void SnowFlakeWithProtobufThreadsTest() throws InterruptedException {

        System.out.println("Snowflake + protobuf IdGenerator");
        int iterations = 1000000;
        int numThreads = 1000;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        CountDownLatch latch = new CountDownLatch(numThreads);

        long begin = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            executorService.submit(() -> {
                Long aLong = idClient.nextIdClientWithBlockingStub();
                UserIdProtoBuf protoBuf = UserIdProtoBuf.of(aLong, "123");
                protoBufRepository.save(protoBuf);
                latch.countDown();
            });
        }
        latch.await();

        long end = System.currentTimeMillis();
        long cost = end - begin;
        long costMs = iterations / cost;
        System.out.println(numThreads + " Threads:: IDs per ms: " + costMs);
    }

    @Autowired
    private UserIdRepository autoRepository;

    @Test
    void AutoIncrementThreadsTest() throws InterruptedException {

        System.out.println("DB AutoIncrement IdGenerator");
        int iterations = 1000000;
        int numThreads = 1000;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        CountDownLatch latch = new CountDownLatch(numThreads);

        long begin = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            executorService.submit(() -> {
                UserIdAuto entity = UserIdAuto.of("name");
                autoRepository.save(entity);
                latch.countDown();
            });
        }
        latch.await();

        long end = System.currentTimeMillis();
        long cost = end - begin;
        long costMs = iterations / cost;
        System.out.println(numThreads + " Threads:: IDs per ms: " + costMs);
    }

//    @Autowired
//    UserIdUuidRepository repository;
//
//    @Test
//    void UUID_Generator() throws InterruptedException {
//
//        System.out.println("UUID_Generator");
//        int iterations = 1000000;
//        int numThreads = 1000;
//
//        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
//        CountDownLatch latch = new CountDownLatch(numThreads);
//
//        long begin = System.currentTimeMillis();
//        for (int i = 0; i < iterations; i++) {
//            executorService.submit(() -> {
//                UserIdUuid of = UserIdUuid.of(UUID.randomUUID().toString(), "123");
//                repository.save(of);
//                latch.countDown();
//            });
//        }
//        latch.await();
//
//        long end = System.currentTimeMillis();
//        long cost = end - begin;
//        long costMs = iterations / cost;
//        System.out.println(numThreads + " Threads:: IDs per ms: " + costMs);
//    }

    @Autowired
    OpenApiIdGenerator generator;

    @Autowired
    UserIdOpenApiRepository openApiRepository;

    @Test
    void openAPI_Generator() throws InterruptedException {

        System.out.println("Snowflake + open api IdGenerator");
        int iterations = 1000000;
        int numThreads = 1000;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        CountDownLatch latch = new CountDownLatch(numThreads);

        long begin = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            executorService.submit(() -> {
                UserIdOpenApiId of = UserIdOpenApiId.of(generator.getId(), "123");
                openApiRepository.save(of);
                latch.countDown();
            });
        }
        latch.await();

        long end = System.currentTimeMillis();
        long cost = end - begin;
        long costMs = iterations / cost;
        System.out.println(numThreads + " Threads:: IDs per ms: " + costMs);
    }
}
