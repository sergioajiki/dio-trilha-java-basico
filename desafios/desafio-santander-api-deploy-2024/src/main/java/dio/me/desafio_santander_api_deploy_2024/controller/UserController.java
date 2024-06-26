package dio.me.desafio_santander_api_deploy_2024.controller;

import dio.me.desafio_santander_api_deploy_2024.controller.dto.UserDto;
import dio.me.desafio_santander_api_deploy_2024.model.User;
import dio.me.desafio_santander_api_deploy_2024.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> allUsers = userService.findAll();
        List<UserDto> allUserDto = allUsers.stream().map(UserDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(allUserDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok(new UserDto(user));
    }


}
