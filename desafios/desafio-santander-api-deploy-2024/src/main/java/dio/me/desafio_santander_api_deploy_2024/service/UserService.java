package dio.me.desafio_santander_api_deploy_2024.service;

import dio.me.desafio_santander_api_deploy_2024.model.User;
import dio.me.desafio_santander_api_deploy_2024.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long aLong) {
        return null;
    }

    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public User update(Long aLong, User entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
