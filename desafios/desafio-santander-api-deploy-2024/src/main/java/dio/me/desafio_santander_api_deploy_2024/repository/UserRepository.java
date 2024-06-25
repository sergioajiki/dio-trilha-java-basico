package dio.me.desafio_santander_api_deploy_2024.repository;

import dio.me.desafio_santander_api_deploy_2024.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String number);
    boolean existsByCardNumber(String number);
}
