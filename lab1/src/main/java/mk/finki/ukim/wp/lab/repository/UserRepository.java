package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    User findUserByUsername(String username);





}
