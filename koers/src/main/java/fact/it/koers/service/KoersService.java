package fact.it.koers.service;

import fact.it.koers.model.Koers;
import fact.it.koers.repository.KoersRepository;
import fact.it.koers.dto.KoersRequest;
import fact.it.koers.dto.KoersResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KoersService {
    private final KoersRepository koersRepository;

    @PostConstruct
    public void LoadData() {
        if (koersRepository.count() <= 0) {
            Koers koers = new Koers();
            koers.setName("Exact Cross Loenhout");
            koers.setWielrennerId("1");
            koers.setPoints(6);

            Koers koers1 = new Koers();
            koers1.setName("Telenet Superprestige Diegem");
            koers1.setWielrennerId("1");
            koers1.setPoints(9);

            Koers koers2 = new Koers();
            koers2.setName("Exact Cross Loenhout");
            koers2.setWielrennerId("2");
            koers2.setPoints(6);

            Koers koers3 = new Koers();
            koers3.setName("Exact Cross Loenhout");
            koers3.setWielrennerId("3");
            koers3.setPoints(6);

            Koers koers4 = new Koers();
            koers4.setName("Exact Cross Loenhout");
            koers4.setWielrennerId("4");
            koers4.setPoints(6);

            koersRepository.save(koers);
            koersRepository.save(koers1);
            koersRepository.save(koers2);
            koersRepository.save(koers3);
            koersRepository.save(koers4);
        }
    }

        public void createKoers(KoersRequest koersRequest){
            Koers koers = Koers.builder()
                    .Name(koersRequest.getName())
                    .Points(koersRequest.getPoints())
                    .build();

            koersRepository.save(koers);
        }

    public void editKoers(int id, int points, String name){
        Koers koers = koersRepository.findById((long) id).orElse(null);

        if(points != koers.getPoints() && koers != null) {
            koers.setPoints(points);
        }
        if(name != koers.getName() && koers != null) {
            koers.setName(name);
        }
        koersRepository.save(koers);

    }
    public void deleteKoers(int id){
        koersRepository.deleteById((long) id);
    }

        public List<KoersResponse> getAllKoerses() {
            List<Koers> koers = koersRepository.findAll();

            return koers.stream().map(this::mapToProductResponse).toList();
        }

        private KoersResponse mapToProductResponse(Koers koers) {
            return KoersResponse.builder()
                    .id(koers.getId())
                    .Name(koers.getName())
                    .Points(koers.getPoints())
                    .build();
        }

}
