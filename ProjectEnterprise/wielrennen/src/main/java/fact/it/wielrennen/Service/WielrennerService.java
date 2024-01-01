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
        if(wielrennerRepository.count() > 0) {
            Wielrenner wielrenner = new Wielrenner();
            wielrenner.setFirstname("Wieland");
            wielrenner.setLastname("Vandebotermet");
            wielrenner.setGroupCode("1");

            Wielrenner wielrenner1 = new Wielrenner();
            wielrenner1.setFirstname("Lander");
            wielrenner1.setLastname("Hens");
            wielrenner1.setGroupCode("1");

            Wielrenner wielrenner2 = new Wielrenner();
            wielrenner2.setFirstname("Maarten");
            wielrenner2.setLastname("Jacobs");
            wielrenner2.setGroupCode("1");

            Wielrenner wielrenner3 = new Wielrenner();
            wielrenner3.setFirstname("Natan");
            wielrenner3.setLastname("Brackel");
            wielrenner3.setGroupCode("2");

            Wielrenner wielrenner4 = new Wielrenner();
            wielrenner4.setFirstname("Tibbo");
            wielrenner4.setLastname("LeemPut");
            wielrenner4.setGroupCode("2");

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
    public void editWielrenners(int id,String Firstname,String Lastname, String GroupCode){
        Wielrenner wielrenner = wielrennerRepository.findById((long) id).orElse(null);

        if(Firstname != wielrenner.getFirstname() && wielrenner != null) {
            wielrenner.setFirstname(Firstname);
        }
        if(Lastname != wielrenner.getLastname() && wielrenner != null) {
            wielrenner.setLastname(Lastname);
        }
        if(GroupCode != wielrenner.getGroupCode() && wielrenner != null) {
            wielrenner.setGroupCode(GroupCode);
        }
        wielrennerRepository.save(wielrenner);
    }

    public List<WielrennerResponse> getAllwielrenners() {
        List<Wielrenner> wielrenner = wielrennerRepository.findAll();

        return wielrenner.stream().map(this::mapToProductResponse).toList();
    }

    public List<WielrennerResponse> getAllWielrennersByGroupcode(List<String> GroupCode) {
        List<Wielrenner> wielrenner = wielrennerRepository.FindByGroupCodeIn(GroupCode);

        return wielrenner.stream().map(this::mapToProductResponse).toList();
    }

    private WielrennerResponse mapToProductResponse(Wielrenner wielrenner) {
        return WielrennerResponse.builder()
                .id(wielrenner.getId())
                .Firstname(wielrenner.getFirstname())
                .Lastname(wielrenner.getLastname())
                .GroupCode(wielrenner.getGroupCode())
                .build();
    }

}
