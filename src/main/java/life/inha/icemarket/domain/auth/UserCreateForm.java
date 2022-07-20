package life.inha.icemarket.domain.auth;



import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Getter
@Setter
public class UserCreateForm {
    // todo: 이메일을 자동으로 학번 이메일에서 가져올것인가. 아니면 회원가입 시 이메일을 받아 인증코드까지 인증 후 작동되게 할것인가.
    @Email
    @NotEmpty(message="이메일은 필수항목 입니다.") // 오류 발생 시 response할 메세지 입력
    private String email;


}
