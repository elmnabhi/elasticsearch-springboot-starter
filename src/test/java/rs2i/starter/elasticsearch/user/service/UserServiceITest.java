package rs2i.starter.elasticsearch.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rs2i.starter.elasticsearch.common.exceptions.EntityNotFoundException;
import rs2i.starter.elasticsearch.user.domain.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceITest {

    @Autowired
    private UserService userService;

    @Test
    public void findByUserNameReturnsTheRightUser() throws EntityNotFoundException {

        //GIVEN
        String userName = "Merouane";
        User expectedUser = User.builder().password("TYU7865H").id("User::2").userName("Merouane").build();

        //WHEN
        User user = userService.findByUserName(userName);

        //THEN
        assertThat(user).isEqualTo(expectedUser);
    }

    @Test(expected = EntityNotFoundException.class)
    public void findByUserNameThrowEntityNotFoundExceptionWhenUserIsNotFound() throws EntityNotFoundException {

        //GIVEN
        String userName = "unknown";

        //WHEN
        userService.findByUserName(userName);

        //THEN
        Assert.fail();
    }

}