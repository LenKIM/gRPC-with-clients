package kr.co.trevari.example.grpcwithids.grpcwithidsclient.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

@Getter
@NoArgsConstructor
public class UserIdAuto {

    @Id
    private Long id;
    private String name;

    @PersistenceConstructor
    public UserIdAuto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserIdAuto of(String name) {
        return new UserIdAuto(null, name);
    }
}
