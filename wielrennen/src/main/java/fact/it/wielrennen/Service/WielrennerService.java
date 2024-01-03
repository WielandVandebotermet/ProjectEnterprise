package fact.it.wielrennen.Service;

import fact.it.wielrennen.dto.WielrennerRequest;
import fact.it.wielrennen.dto.WielrennerResponse;
import fact.it.wielrennen.model.Wielrenner;
import fact.it.wielrennen.repository.WielrennerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WielrennerService {

    private final WielrennerRepository wielrennerRepository;
    private final WebClient webClient;

    @PostConstruct
    public void LoadData() {
        if(wielrennerRepository.count() <= 0) {
            Wielrenner wielrenner = new Wielrenner();
            wielrenner.setFirstname("Wieland");
            wielrenner.setLastname("Vandebotermet");
            wielrenner.setGroupCode("EQS");

            Wielrenner wielrenner1 = new Wielrenner();
            wielrenner1.setFirstname("Lander");
            wielrenner1.setLastname("Hens");
            wielrenner1.setGroupCode("EQS");

            Wielrenner wielrenner2 = new Wielrenner();
            wielrenner2.setFirstname("Maarten");
            wielrenner2.setLastname("Jacobs");
            wielrenner2.setGroupCode("EQS");

            Wielrenner wielrenner3 = new Wielrenner();
            wielrenner3.setFirstname("Natan");
            wielrenner3.setLastname("Brackel");
            wielrenner3.setGroupCode("LTS");

            Wielrenner wielrenner4 = new Wielrenner();
            wielrenner4.setFirstname("Tibbo");
            wielrenner4.setLastname("LeemPut");
            wielrenner4.setGroupCode("LTS");

            wielrennerRepository.save(wielrenner);
            wielrennerRepository.save(wielrenner1);
            wielrennerRepository.save(wielrenner2);
            wielrennerRepository.save(wielrenner3);
            wielrennerRepository.save(wielrenner4);
        }

    }

    public void createWielrennen(WielrennerRequest wielrennerRequest){
        Wielrenner wielrenner = Wielrenner.builder()
                .Firstname(wielrennerRequest.getFirstname())
                .Lastname(wielrennerRequest.getLastname())
                .GroupCode(wielrennerRequest.getGroupCode())
                .build();

         wielrennerRepository.save(wielrenner);

    }

    public void deleteWielrenners(int id){
        wielrennerRepository.deleteById((long) id);
    }
    public void editWielrenners(int id, WielrennerRequest wielrennerRequest){
        Wielrenner wielrenner = wielrennerRepository.findById((long) id).orElse(null);

        if(wielrenner != null)
        {
            wielrenner.setId(id);
            wielrenner.setFirstname(wielrennerRequest.getFirstname());
            wielrenner.setLastname(wielrennerRequest.getLastname());
            wielrenner.setGroupCode(wielrennerRequest.getGroupCode());

            wielrennerRepository.save(wielrenner);
        }
    }

    public List<WielrennerResponse> getAllwielrenners() {
        List<Wielrenner> wielrenner = wielrennerRepository.findAll();

        return wielrenner.stream().map(this::mapToWielrennerResponse).toList();
    }

    private WielrennerResponse mapToWielrennerResponse(Wielrenner wielrenner) {
        return WielrennerResponse.builder()
                .id(wielrenner.getId())
                .Firstname(wielrenner.getFirstname())
                .Lastname(wielrenner.getLastname())
                .GroupCode(wielrenner.getGroupCode())
                .build();
    }

}
