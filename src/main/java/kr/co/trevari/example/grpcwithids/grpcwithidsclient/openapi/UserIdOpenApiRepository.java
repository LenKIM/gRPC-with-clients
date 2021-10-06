package kr.co.trevari.example.grpcwithids.grpcwithidsclient.openapi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIdOpenApiRepository extends CrudRepository<UserIdOpenApiId, Long> {

}
