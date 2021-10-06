package kr.co.trevari.example.grpcwithids.grpcwithidsclient.openapi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor
@Table(value = "user_openapi_id")
public class UserIdOpenApiId implements Persistable<Long> {

    @Id
    private Long id;
    private String name;

    @Transient
    private boolean isNew = false;

    @PersistenceConstructor
    public UserIdOpenApiId(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserIdOpenApiId of(Long id, String name) {
        UserIdOpenApiId protoBuf = new UserIdOpenApiId(id, name);
        protoBuf.isNew = true;
        return protoBuf;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
