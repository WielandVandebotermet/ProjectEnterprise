package fact.it.group.repository;

import fact.it.group.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface GroupRepository extends MongoRepository<Group, String> {
    List<Group> findByGroupCode(List<String> GroupCode);
}
