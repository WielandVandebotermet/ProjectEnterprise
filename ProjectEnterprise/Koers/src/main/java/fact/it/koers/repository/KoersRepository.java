package fact.it.koers.repository;

import fact.it.koers.model.Koers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface KoersRepository extends JpaRepository<Koers, Long> {
    List<Koers> FindByNameIn(List<String> Name);
}
