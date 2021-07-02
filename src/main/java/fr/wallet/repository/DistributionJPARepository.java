package fr.wallet.repository;

import fr.wallet.domain.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributionJPARepository extends JpaRepository<Distribution, Integer> {
}
