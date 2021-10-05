package kr.co.trevari.example.grpcwithids.grpcwithidsclient.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIdRepository extends CrudRepository<UserIdAuto, Long> {

}
