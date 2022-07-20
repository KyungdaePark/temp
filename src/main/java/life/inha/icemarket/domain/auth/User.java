package life.inha.icemarket.domain.auth;

import lombok.*;
import net.bytebuddy.asm.Advice;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    @Email
    private String email;

    @NonNull
    @Column(name = "password_hashed")
    private String passwordHashed;

    private String nickname;

    @CreatedDate
    @NonNull
    private LocalDateTime createdAt;

//    @LastModifiedDate
//    @NonNull
//    private LocalDateTime updatedAt;
//
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Builder
    public User(Integer id, String name, String email, String nickname, String passwordHashed){
        this.id = id;
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.passwordHashed = passwordHashed;
        this.createdAt = LocalDateTime.now();
    }
}
