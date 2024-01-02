package fact.it.wielrennen.repository;

import fact.it.wielrennen.model.Wielrenner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface WielrennerRepository extends JpaRepository<Wielrenner, Long> {
    //List<Wielrenner> FindByGroupCodeIn(List<String> GroupCode);
}
