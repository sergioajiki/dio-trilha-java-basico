package dio.me.desafio_santander_api_deploy_2024.service;

import dio.me.desafio_santander_api_deploy_2024.exception.BusinessException;
import dio.me.desafio_santander_api_deploy_2024.exception.NotFoundException;
import dio.me.desafio_santander_api_deploy_2024.model.User;
import dio.me.desafio_santander_api_deploy_2024.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

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
        if (userOptional.isEmpty()) {
            throw new NotFoundException("User with id " + id + " not found");
        }
        return userOptional.get();
    }

    @Override
    @Transactional
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new BusinessException("This Account number already exists.");
        }
        if (userRepository.existsByAccountNumber(userToCreate.getCard().getNumber())) {
            throw new BusinessException("This Card number already exists.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    @Transactional
    public User update(Long id, User userToUpdate) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new NotFoundException("User with id " + id + " not found");
        }
        User userFound = userOptional.get();

        userFound.setName(userToUpdate.getName());
        userFound.setAccount(userToUpdate.getAccount());
        userFound.setCard(userToUpdate.getCard());
        userFound.setFeatureList(userToUpdate.getFeatureList());
        userFound.setNewsList(userToUpdate.getNewsList());

        return this.userRepository.save(userFound);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new NotFoundException("User with id " + id + " not found");
        }
        this.userRepository.delete(userOptional.get());
    }
}
