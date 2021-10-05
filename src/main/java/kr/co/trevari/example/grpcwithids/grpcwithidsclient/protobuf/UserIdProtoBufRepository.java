package kr.co.trevari.example.grpcwithids.grpcwithidsclient.protobuf;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIdProtoBufRepository extends CrudRepository<UserIdProtoBuf, Long> {

}
