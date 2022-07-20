package life.inha.icemarket.service.auth;

import life.inha.icemarket.domain.auth.User;
import life.inha.icemarket.domain.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Integer create(UserCreateRequestDto userCreateRequestDto){
        return userRepository.save(userCreateRequestDto.toEntity()).getId();
    }

//    public User create(Integer id, String name, String email, String passwordHashed, String nickname){
//        User user = new User();
//        user.setId(id);
//        user.setName(name);
//        user.setEmail(email);
//        user.setNickname(nickname);
//        user.setPasswordHashed(passwordEncoder.encode(passwordHashed));
//        //TODO : passwordHashed가 여기 userService에서 처리하는건지, 아니면 암호화된 비밀번호를 가져와야 하는건지..
//        this.userRepository.save(user);
//        return user;
//    }

}
