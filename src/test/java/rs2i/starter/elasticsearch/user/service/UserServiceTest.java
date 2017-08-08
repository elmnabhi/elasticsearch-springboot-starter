package rs2i.starter.elasticsearch.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import rs2i.starter.elasticsearch.common.exceptions.EntityNotFoundException;
import rs2i.starter.elasticsearch.user.domain.User;
import rs2i.starter.elasticsearch.user.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Mock
    private UserRepository userRepository;

    @Test(expected = EntityNotFoundException.class)
    public void findByUserNameThrowEntityNotFoundExceptionWhenUserIsNotFound() throws EntityNotFoundException {

        //GIVEN
        String userName = "userName";
        Mockito.when(userRepository.findByUserName(userName)).thenReturn(null);

        //WHEN
        userService.findByUserName(userName);

        //THEN
        Assert.fail();
    }

    @Test
    public void findByUserNameReturnsTheRightUser() throws EntityNotFoundException {

        //GIVEN
        String userName = "Merouane";
        User expectedUser = User.builder().password("TYU7865H").id("User::2").userName("Merouane").build();
        Mockito.when(userRepository.findByUserName(userName)).thenReturn(expectedUser);

        //WHEN
        User user = userService.findByUserName(userName);

        //THEN
        assertThat(user).isEqualTo(expectedUser);
    }
}