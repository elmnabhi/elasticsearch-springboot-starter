package rs2i.starter.elasticsearch.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs2i.starter.elasticsearch.user.domain.User;
import rs2i.starter.elasticsearch.user.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class Init {

    private final static Logger LOGGER = LoggerFactory.getLogger(Init.class);

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init() {

        LOGGER.debug("init()");

        User user = User.builder().password("TYU7865H").id("User::2").userName("Merouane").build();
        User user2 = User.builder().password("HJ765FGG").id("User::3").userName("Ilyass").build();
        userRepository.save(Arrays.asList(user, user2));
    }
}
