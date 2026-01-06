package luizbrand.com.user_service.infrastructure.controller;

import jakarta.validation.Valid;
import luizbrand.com.user_service.core.domain.User;
import luizbrand.com.user_service.core.usecases.CreateUserCase;
import luizbrand.com.user_service.core.usecases.ListUsersCase;
import luizbrand.com.user_service.infrastructure.docs.UserControllerDocs;
import luizbrand.com.user_service.infrastructure.dto.UserDTO;
import luizbrand.com.user_service.infrastructure.mapper.UserDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/user-ms/")
public class UserController implements UserControllerDocs {

    private final CreateUserCase createUserCase;
    private final ListUsersCase listUsersCase;
    private final UserDtoMapper userDtoMapper;

    public UserController(CreateUserCase createUserCase, ListUsersCase listUsersCase, UserDtoMapper userDtoMapper) {
        this.createUserCase = createUserCase;
        this.listUsersCase = listUsersCase;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> creatUser(@RequestBody @Valid UserDTO userDto) {

        User user = createUserCase.execute(userDtoMapper.toDomain(userDto));
        UserDTO userResponse = userDtoMapper.toUserDto(user);
        Map<String, Object> response = new HashMap<>();

        response.put("Message: ", "User created successfully");
        response.put("User data: ", userResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("list")
    public ResponseEntity<List<UserDTO>> listUsers() {
        List<User> users = listUsersCase.execute();
        List<UserDTO> userDTOs = users.stream()
                .map(userDtoMapper::toUserDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }

}
