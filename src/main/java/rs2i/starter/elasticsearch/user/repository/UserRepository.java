package rs2i.starter.elasticsearch.user.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import rs2i.starter.elasticsearch.user.domain.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

    User findByUserName(String userName);
}
