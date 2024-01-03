package fact.it.group.service;

import fact.it.group.dto.GroupRequest;
import fact.it.group.dto.GroupResponse;
import fact.it.group.model.Group;
import fact.it.group.repository.GroupRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    @PostConstruct
    public void LoadData() {
        if (groupRepository.count() <= 0) {
            Group group =  Group.builder()
                .Name("Etixx-Quick Step")
                .GroupCode("EQS")
                .build();

            Group group1 = Group.builder()
                .Name("FDJ")
                .GroupCode("FDJ")
                .build();

            Group group2= Group.builder()
                .Name("Lotto Soudal")
                .GroupCode("LTS")
                .build();

            groupRepository.save(group);
            groupRepository.save(group1);
            groupRepository.save(group2);

        }
    }


    public void createGroup(GroupRequest groupRequest){
        Group group = Group.builder()
                .GroupCode(groupRequest.getGroupCode())
                .Name(groupRequest.getName())
                .build();

        groupRepository.save(group);
    }

    public List<GroupResponse> getAllGroups() {
        List<Group> groups = groupRepository.findAll();

        return groups.stream().map(this::mapToProductResponse).toList();
    }

    public List<GroupResponse> getAllGroupsByGroupCode(List<String> GroupCode) {
        List<Group> products = groupRepository.findByGroupCode(GroupCode);

        return products.stream().map(this::mapToProductResponse).toList();
    }

    public void editGroup(String id, GroupRequest groupRequest){
        Group group = groupRepository.findById(id).orElse(null);
        if(group != null)
        {
            group.setId(id);
            group.setGroupCode(groupRequest.getGroupCode());
            group.setName(groupRequest.getName());

            groupRepository.save(group);
        }

    }
    public void deleteGroup(String id){

        groupRepository.deleteById(id);
    }

    private GroupResponse mapToProductResponse(Group group) {
        return GroupResponse.builder()
                .id(group.getId())
                .GroupCode(group.getGroupCode())
                .name(group.getName())
                .build();
    }
}
