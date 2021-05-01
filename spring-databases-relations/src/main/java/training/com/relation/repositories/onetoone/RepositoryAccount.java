package training.com.relation.repositories.onetone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import training.com.relation.models.onetone.Account;

@Repository
public interface RepositoryAccount extends JpaRepository<Account, Long> {

}
