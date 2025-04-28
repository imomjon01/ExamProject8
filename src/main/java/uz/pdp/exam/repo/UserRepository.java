package uz.pdp.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.exam.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
