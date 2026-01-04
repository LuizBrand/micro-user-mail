package luizbrand.com.user_service.infrastructure.controller;

import jakarta.validation.Valid;
import luizbrand.com.user_service.core.domain.User;
import luizbrand.com.user_service.core.usecases.CreateUserCase;
import luizbrand.com.user_service.infrastructure.dto.UserDTO;
import luizbrand.com.user_service.infrastructure.mapper.UserDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/user-ms/")
public class UserController {

    private final CreateUserCase createUserCase;
    private final UserDtoMapper userDtoMapper;

    public UserController(CreateUserCase createUserCase, UserDtoMapper userDtoMapper) {
        this.createUserCase = createUserCase;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> creatUser(@RequestBody @Valid UserDTO userDto) {

        User user = createUserCase.execute(userDtoMapper.toDomain(userDto));
        UserDTO userResponse = userDtoMapper.toUserDto(user);
        Map<String, Object> response = new HashMap<>();

        response.put("Message: ", "User created successfully");
        response.put("User data: ", userResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
