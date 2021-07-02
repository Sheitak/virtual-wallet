package fr.wallet.repository;

import fr.wallet.domain.Wrapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WrapperJPARepository extends JpaRepository<Wrapper, Integer> {

}
