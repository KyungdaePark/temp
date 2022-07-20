package life.inha.icemarket.service.auth;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import life.inha.icemarket.domain.auth.User;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {

    private Integer id;
    private String name;
    private String email;
    private String nickname;
    private String passwordHashed;

    @Builder
    public UserCreateRequestDto(Integer id, String name, String email, String nickname, String passwordHashed){
        this.id = id;
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.passwordHashed = passwordHashed;
    }

    public User toEntity(){
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .nickname(nickname)
                .passwordHashed(passwordHashed)
                .build();
    }
}
