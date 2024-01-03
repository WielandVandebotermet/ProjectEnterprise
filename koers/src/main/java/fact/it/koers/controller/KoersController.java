package fact.it.koers.controller;

import fact.it.koers.service.KoersService;
import fact.it.koers.dto.KoersRequest;
import fact.it.koers.dto.KoersResponse;
import fact.it.koers.model.Koers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/koers")
@RequiredArgsConstructor
public class KoersController {

    private final KoersService koersService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createKoers
            (@RequestBody KoersRequest koersRequest) {
        koersService.createKoers(koersRequest);
    }

    @DeleteMapping("/Delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void DeleteKoers
            (@PathVariable("id") String id) {
        koersService.deleteKoers(Integer.parseInt(id));
    }

    @PutMapping("/Edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void EditKoers
            (@PathVariable("id") String id, @RequestBody KoersRequest koersRequest) {
         koersService.editKoers(Integer.parseInt(id), koersRequest);
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<KoersResponse> getAllKoerses() {
        return koersService.getAllKoerses();
    }

}
