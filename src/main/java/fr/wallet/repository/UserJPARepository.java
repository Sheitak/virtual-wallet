package fr.wallet.repository;

import fr.wallet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Integer> {
}
