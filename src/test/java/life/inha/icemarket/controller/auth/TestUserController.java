package life.inha.icemarket.controller.auth;

import life.inha.icemarket.domain.auth.User;
import life.inha.icemarket.domain.auth.UserRepository;
import life.inha.icemarket.service.auth.UserCreateRequestDto;
import life.inha.icemarket.service.auth.UserService;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserController {
    @LocalServerPort
    private int port;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @After
    public void tearDown() throws Exception{
        userRepository.deleteAll();
    }

    @Test
    public void SignupTest() throws Exception{
        //given
        Integer id = 12191759;
        String name = "pkd";
        String email = "pkd@gmail.com";
        String passwordHashed = "1234";
        String nickname = "pkd_nick";


        UserCreateRequestDto userCreateRequestDto = UserCreateRequestDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .passwordHashed(passwordHashed)
                .nickname(nickname)
                .build();

        String url = "http://localhost:" + port + "/signup";

        //when
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(url, userCreateRequestDto, Object.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        //assertThat(responseEntity.getBody()).isGreaterThan(1L);
        List<User> all = userRepository.findAll();
        assertThat(all.get(0).getId()).isEqualTo(id);
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getEmail()).isEqualTo(email);
        assertThat(all.get(0).getPasswordHashed()).isEqualTo(passwordHashed);
        assertThat(all.get(0).getNickname()).isEqualTo(nickname);
    }
}
