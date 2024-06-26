package dio.me.desafio_santander_api_deploy_2024.controller;

import dio.me.desafio_santander_api_deploy_2024.controller.dto.UserDto;
import dio.me.desafio_santander_api_deploy_2024.model.User;
import dio.me.desafio_santander_api_deploy_2024.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "Users")
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "All users", description = "List of all users")
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> allUsers = userService.findAll();
        List<UserDto> allUserDto = allUsers.stream().map(UserDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(allUserDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "User by id", description = "Search user by id")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(new UserDto(user));
    }

    @PostMapping
    @Operation(summary = "Register user", description = "Register a user")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        User userToCreate = userDto.toModel();
        userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id")
                .buildAndExpand(userToCreate.getId())
                .toUri();
        return ResponseEntity.created(location).body(new UserDto(userToCreate));
    }

    @PutMapping("/id")
    @Operation(summary = "Update user", description = "Update a user by id")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
        User userToUpdate = userDto.toModel();
        userService.update(id, userToUpdate);
        return ResponseEntity.ok(new UserDto(userToUpdate));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user", description = "Delete a user by id")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
