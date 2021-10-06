package kr.co.trevari.example.grpcwithids.grpcwithidsclient.openapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OpenApiIdGenerator {

    private static final String LOCAL_URL = "http://localhost:8089/getId?nodeId=1";
    private final RestTemplate restTemplate;

    public Long getId() {
        ResponseEntity<Map> exchange = restTemplate.exchange(LOCAL_URL, HttpMethod.GET, HttpEntity.EMPTY, Map.class);
        long value = (long) exchange.getBody().get("value");
        return value;
    }
}
