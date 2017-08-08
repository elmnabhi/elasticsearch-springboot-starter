package rs2i.starter.elasticsearch.user.service;

import rs2i.starter.elasticsearch.common.exceptions.EntityNotFoundException;
import rs2i.starter.elasticsearch.user.domain.User;

public interface UserService {

    User findByUserName(String userName) throws EntityNotFoundException;
}
