package rs2i.starter.elasticsearch.web.resources;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs2i.starter.elasticsearch.common.exceptions.EntityNotFoundException;
import rs2i.starter.elasticsearch.user.domain.User;
import rs2i.starter.elasticsearch.user.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserResource {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET,
            path = "/{userName}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> getUserByEmail(@PathVariable String userName) {

        LOGGER.debug("getUserByEmail({})", userName);

        try {
            return ResponseEntity.ok().body(userService.findByUserName(userName));
        } catch (EntityNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
