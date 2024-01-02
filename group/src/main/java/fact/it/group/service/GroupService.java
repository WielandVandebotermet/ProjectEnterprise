package fact.it.group.service;

import fact.it.group.dto.GroupRequest;
import fact.it.group.dto.GroupResponse;
import fact.it.group.model.Group;
import fact.it.group.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public void createGroup(GroupRequest groupRequest){
        Group group = Group.builder()
                .GroupCode(groupRequest.getGroupCode())
                .name(groupRequest.getName())
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

    private GroupResponse mapToProductResponse(Group group) {
        return GroupResponse.builder()
                .id(group.getId())
                .GroupCode(group.getGroupCode())
                .name(group.getName())
                .build();
    }
}
