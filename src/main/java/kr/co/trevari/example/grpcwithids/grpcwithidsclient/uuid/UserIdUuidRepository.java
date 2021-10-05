package kr.co.trevari.example.grpcwithids.grpcwithidsclient.uuid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIdUuidRepository extends CrudRepository<UserIdUuid, String> {

}
