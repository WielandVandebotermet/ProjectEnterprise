package fact.it.wielrennen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import fact.it.wielrennen.dto.WielrennerRequest;
import fact.it.wielrennen.dto.WielrennerResponse;
import fact.it.wielrennen.model.Wielrenner;
import fact.it.wielrennen.repository.WielrennerRepository;
import java.util.List;
import java.util.Optional;

import fact.it.wielrennen.Service.WielrennerService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class WielrennenApplicationTests {

	@Mock
	private WielrennerRepository wielrennerRepository;

	@InjectMocks
	private WielrennerService wielrennerService;

	@Test
	void testCreateWielrennen() {
		// Setup
		WielrennerRequest wielrennerRequest = new WielrennerRequest();
		wielrennerRequest.setFirstname("John");
		wielrennerRequest.setLastname("Doe");
		wielrennerRequest.setGroupCode("XYZ");

		// Test
		wielrennerService.createWielrennen(wielrennerRequest);

		// Verification
		verify(wielrennerRepository, times(1)).save(any(Wielrenner.class));
	}

	@Test
	void testGetAllwielrenners() {
		// Setup
		Wielrenner wielrenner1 = new Wielrenner();
		wielrenner1.setId(1L);
		wielrenner1.setFirstname("Test1");
		wielrenner1.setLastname("Wielrenner");
		wielrenner1.setGroupCode("ABC");

		Wielrenner wielrenner2 = new Wielrenner();
		wielrenner2.setId(2L);
		wielrenner2.setFirstname("Test2");
		wielrenner2.setLastname("Wielrenner");
		wielrenner2.setGroupCode("DEF");

		List<Wielrenner> wielrennerList = new ArrayList<>();
		wielrennerList.add(wielrenner1);
		wielrennerList.add(wielrenner2);

		when(wielrennerRepository.findAll()).thenReturn(wielrennerList);

		// Test
		List<WielrennerResponse> wielrennerResponses = wielrennerService.getAllwielrenners();

		// Verification
		verify(wielrennerRepository, times(1)).findAll();
		assertEquals(2, wielrennerResponses.size());
		assertEquals("Test1", wielrennerResponses.get(0).getFirstname());
		assertEquals("Test2", wielrennerResponses.get(1).getFirstname());
		// Add more assertions for other fields if needed
	}

	@Test
	void testEditWielrenners() {
		// Create a KoersRequest
		WielrennerRequest wielrennerRequest = new WielrennerRequest();
		wielrennerRequest.setFirstname("Wieland");
		wielrennerRequest.setLastname("Steen");
		wielrennerRequest.setGroupCode("LCU");

		// Mock the Koers object to return from findById
		Wielrenner mockWielrenner = new Wielrenner();
		mockWielrenner.setId(1L);

		when(wielrennerRepository.findById(1L)).thenReturn(Optional.of(mockWielrenner));

		// Call the editKoers method
		wielrennerService.editWielrenners(1, wielrennerRequest);

		// Verify that save method was called with the updated Koers object
		verify(wielrennerRepository, times(1)).save(mockWielrenner);
		assertEquals("Wieland", mockWielrenner.getFirstname());
		assertEquals("Steen", mockWielrenner.getLastname());
		assertEquals("LCU", mockWielrenner.getGroupCode());
	}

	@Test
	void testDeleteWielrenners() {
		// Setup
		Wielrenner mockWielrenner = new Wielrenner();
		mockWielrenner.setId(1L);

		// Test
		wielrennerService.deleteWielrenners(1);

		// Verification
		verify(wielrennerRepository, times(1)).deleteById(1L);
	}

}
