package fact.it.group;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import fact.it.group.dto.GroupRequest;
import fact.it.group.dto.GroupResponse;
import fact.it.group.model.Group;
import fact.it.group.repository.GroupRepository;
import fact.it.group.service.GroupService;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GroupApplicationTests {

	@Mock
	private GroupRepository groupRepository;

	@InjectMocks
	private GroupService groupService;

	@Test
	void testCreateGroup() {
		// Setup
		GroupRequest groupRequest = new GroupRequest();
		groupRequest.setGroupCode("EQS");
		groupRequest.setName("Etixx-Quick Step");

		// Test
		groupService.createGroup(groupRequest);

		// Verification
		verify(groupRepository, times(1)).save(any(Group.class));
	}

	@Test
	void testGetAllGroups() {
		// Setup
		Group group1 = new Group();
		group1.setId("1");
		group1.setName("Test Group 1");
		group1.setGroupCode("ABC");

		Group group2 = new Group();
		group2.setId("2");
		group2.setName("Test Group 2");
		group2.setGroupCode("DEF");

		List<Group> groupList = new ArrayList<>();
		groupList.add(group1);
		groupList.add(group2);

		when(groupRepository.findAll()).thenReturn(groupList);

		// Test
		List<GroupResponse> groupResponses = groupService.getAllGroups();

		// Verification
		verify(groupRepository, times(1)).findAll();
		assertEquals(2, groupResponses.size());
		assertEquals("Test Group 1", groupResponses.get(0).getName());
		assertEquals("Test Group 2", groupResponses.get(1).getName());
		// Add more assertions for other fields if needed
	}

	@Test
	void testEditGroup() {
		// Create a KoersRequest
		GroupRequest groupRequest = new GroupRequest();
		groupRequest.setName("Wieland");
		groupRequest.setGroupCode("LCU");

		// Mock the Koers object to return from findById
		Group mockGroup = new Group();
		mockGroup.setId("1");

		when(groupRepository.findById("1")).thenReturn(Optional.of(mockGroup));

		// Call the editKoers method
		groupService.editGroup("1", groupRequest);

		// Verify that save method was called with the updated Koers object
		verify(groupRepository, times(1)).save(mockGroup);
		assertEquals("Wieland", mockGroup.getName());
		assertEquals("LCU", mockGroup.getGroupCode());
	}

	@Test
	void testDeleteGroup() {
		// Setup
		Group mockGroup = new Group();
		mockGroup.setId("1");

		// Test
		groupService.deleteGroup("1");

		// Verification
		verify(groupRepository, times(1)).deleteById("1");
	}
}
