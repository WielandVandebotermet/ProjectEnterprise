package fact.it.koers;

import fact.it.koers.dto.KoersRequest;
import fact.it.koers.dto.KoersResponse;
import fact.it.koers.model.Koers;
import fact.it.koers.repository.KoersRepository;
import fact.it.koers.service.KoersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class KoersApplicationTests {

    @InjectMocks
    private KoersService koersService;

    @Mock
    private KoersRepository koersRepository;

    @Test
    void testGetAllKoerses() {
        // Create sample data
        Koers koers1 = new Koers();
        koers1.setId(1L);
        koers1.setName("Test Koers 1");
        koers1.setPoints(10);

        Koers koers2 = new Koers();
        koers2.setId(2L);
        koers2.setName("Test Koers 2");
        koers2.setPoints(15);

        List<Koers> koersList = new ArrayList<>();
        koersList.add(koers1);
        koersList.add(koers2);

        when(koersRepository.findAll()).thenReturn(koersList);

        // Call the service method
        List<KoersResponse> koersResponses = koersService.getAllKoerses();

        // Verify the result
        assertEquals(2, koersResponses.size());
        assertEquals("Test Koers 1", koersResponses.get(0).getName());
        assertEquals(10, koersResponses.get(0).getPoints());
        assertEquals("Test Koers 2", koersResponses.get(1).getName());
        assertEquals(15, koersResponses.get(1).getPoints());
    }

    @Test
    void testCreateKoers() {
        // Create a KoersRequest
        KoersRequest koersRequest = new KoersRequest();
        koersRequest.setName("New Koers");
        koersRequest.setPoints(20);

        // Call the service method
        koersService.createKoers(koersRequest);

        // Verify that save method was called with the correct arguments
        verify(koersRepository, times(1)).save(any(Koers.class));
    }

    @Test
    void testEditKoers() {
        // Create a KoersRequest
        KoersRequest koersRequest = new KoersRequest();
        koersRequest.setWielrennerId("5");
        koersRequest.setName("Updated Koers");
        koersRequest.setPoints(30);

        // Mock the Koers object to return from findById
        Koers mockKoers = new Koers();
        mockKoers.setId(1L);

        when(koersRepository.findById(1L)).thenReturn(Optional.of(mockKoers));

        // Call the editKoers method
        koersService.editKoers(1, koersRequest);

        // Verify that save method was called with the updated Koers object
        verify(koersRepository, times(1)).save(mockKoers);
        assertEquals("5", mockKoers.getWielrennerId());
        assertEquals("Updated Koers", mockKoers.getName());
        assertEquals(30, mockKoers.getPoints());
    }

    @Test
    void testDeleteKoers() {
        // Setup
        Koers mockKoers = new Koers();
        mockKoers.setId(1L);

        // Test
        koersService.deleteKoers(1);

        // Verification
        verify(koersRepository, times(1)).deleteById(1L);
    }

}

