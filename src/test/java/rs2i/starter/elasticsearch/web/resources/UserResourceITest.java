package rs2i.starter.elasticsearch.web.resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import rs2i.starter.elasticsearch.user.domain.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserResourceITest {

    @Value("${local.server.port}")
    private int port;

    private RestTemplate restTemplate = new RestTemplate();

    private String userResourceUrl;

    @Before
    public void setup() {
       userResourceUrl = "http://localhost:" + port + "/user";
    }

    @Test
    public void getUserByEmailReturnsNotFoundWhenUserIsNotFoundInDB() {

        //GIVEN
        String userName = "unknown";
        String url = new StringBuilder(userResourceUrl).append("/").append(userName).toString();

        //WHEN
        try {
            restTemplate.exchange(url, HttpMethod.GET, null, User.class);
        } catch(HttpClientErrorException e) {
            //THEN
            assertThat(e.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void getUserByEmailReturnsOkWhenUserIsFoundInDB() {

        //GIVEN
        String userName = "Merouane";
        String url = new StringBuilder(userResourceUrl).append("/").append(userName).toString();

        //WHEN
        ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, User.class);

        //THEN
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}