package fr.wallet.repository;

import fr.wallet.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyJPARepository extends JpaRepository<Company, Integer> {
}
