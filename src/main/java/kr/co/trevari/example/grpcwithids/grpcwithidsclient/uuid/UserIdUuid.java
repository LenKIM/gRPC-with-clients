package kr.co.trevari.example.grpcwithids.grpcwithidsclient.uuid;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

@Getter
@NoArgsConstructor
public class UserIdUuid  implements Persistable<String> {

    @Id
    private String id;
    private String name;

    @Transient
    private boolean isNew = false;

    @PersistenceConstructor
    public UserIdUuid(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public static UserIdUuid of(String id, String name) {
        UserIdUuid protoBuf = new UserIdUuid(id, name);
        protoBuf.isNew = true;
        return protoBuf;
    }
}
