package rs2i.starter.elasticsearch.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs2i.starter.elasticsearch.common.exceptions.EntityNotFoundException;
import rs2i.starter.elasticsearch.user.domain.User;
import rs2i.starter.elasticsearch.user.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUserName(String userName) throws EntityNotFoundException {

        LOGGER.debug("findByEmail({})", userName);

        Optional<User> user = Optional.ofNullable(userRepository.findByUserName(userName));
        if(!user.isPresent()){
            throw new EntityNotFoundException(String.format("User with userName %s does not exist", userName));
        }
        return user.get();
    }
}
