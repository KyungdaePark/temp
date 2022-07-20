package life.inha.icemarket.controller.auth;

import life.inha.icemarket.domain.auth.UserCreateForm;
import life.inha.icemarket.service.auth.UserCreateRequestDto;
import life.inha.icemarket.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public Integer signup(@RequestBody UserCreateRequestDto userCreateRequestDto){
        return userService.create(userCreateRequestDto);
    }
}
