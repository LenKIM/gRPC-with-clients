package kr.co.trevari.example.grpcwithids.grpcwithidsclient.protobuf;

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannelBuilder;
import kr.co.trevari.example.grpcwithids.IdGeneratorGrpc;
import kr.co.trevari.example.grpcwithids.IdResponse;
import kr.co.trevari.example.grpcwithids.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class IdClient {
    private static final int PORT = 3030;
    public static final String HOST = "localhost";

    private final IdGeneratorGrpc.IdGeneratorFutureStub futureStub = IdGeneratorGrpc.newFutureStub(
            ManagedChannelBuilder.forAddress(HOST, PORT)
                    .usePlaintext()
                    .build()
    );

    private final IdGeneratorGrpc.IdGeneratorBlockingStub blockingStub = IdGeneratorGrpc.newBlockingStub(
            ManagedChannelBuilder.forAddress(HOST, PORT)
                    .usePlaintext()
                    .build()
    );

    private final IdGeneratorGrpc.IdGeneratorStub asyncStub = IdGeneratorGrpc.newStub(
            ManagedChannelBuilder.forAddress(HOST, PORT)
                    .usePlaintext()
                    .build()
    );


    public Long nextIdClientWithFutureStub() {
        Long id = null;
        final Request request = Request.newBuilder().setNodeId(1).build();
        ListenableFuture<IdResponse> nextId = futureStub.nextId(request);
        try {
            id = nextId.get().getId();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return id;
    }

    public Long nextIdClientWithBlockingStub() {
        final Request request = Request.newBuilder().setNodeId(1).build();
        IdResponse idResponse = blockingStub.nextId(request);
        return idResponse.getId();
    }
}
