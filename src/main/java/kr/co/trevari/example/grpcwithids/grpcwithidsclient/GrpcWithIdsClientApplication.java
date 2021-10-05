package kr.co.trevari.example.grpcwithids.grpcwithidsclient;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@SpringBootApplication
public class GrpcWithIdsClientApplication {

    private final GrpcClient grpcClient;

    public static void main(String[] args) {
        SpringApplication.run(GrpcWithIdsClientApplication.class, args);
    }

    @GetMapping("/")
    public String test(){
        String s = grpcClient.sampleCall();
        return s;
    }

}
