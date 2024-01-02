package fact.it.group.controller;

import fact.it.group.dto.GroupResponse;
import fact.it.group.dto.GroupRequest;
import fact.it.group.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createGroup
            (@RequestBody GroupRequest groupRequest) {
        groupService.createGroup(groupRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GroupResponse> getAllProductsByGroupCode
            (@RequestParam List<String> id) {
        return groupService.getAllGroupsByGroupCode(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupResponse> getAllProducts() {
        return groupService.getAllGroups();
    }
}

