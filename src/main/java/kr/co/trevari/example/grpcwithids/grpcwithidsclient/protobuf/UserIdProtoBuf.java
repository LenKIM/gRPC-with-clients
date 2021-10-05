package kr.co.trevari.example.grpcwithids.grpcwithidsclient.protobuf;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor
@Table(value = "user_protobuf_id")
public class UserIdProtoBuf implements Persistable<Long> {

    @Id
    private Long id;
    private String name;

    @Transient
    private boolean isNew = false;

    @PersistenceConstructor
    public UserIdProtoBuf(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserIdProtoBuf of(Long id, String name) {
        UserIdProtoBuf protoBuf = new UserIdProtoBuf(id, name);
        protoBuf.isNew = true;
        return protoBuf;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
