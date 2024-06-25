package dio.me.desafio_santander_api_deploy_2024.service;

import dio.me.desafio_santander_api_deploy_2024.model.User;
import dio.me.desafio_santander_api_deploy_2024.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(null);
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
