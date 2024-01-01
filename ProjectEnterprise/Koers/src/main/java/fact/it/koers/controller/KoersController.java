package fact.it.koers.controller;

import fact.it.koers.service.KoersService;
import fact.it.koers.dto.KoersRequest;
import fact.it.koers.dto.KoersResponse;
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

    @GetMapping("/Delete")
    @ResponseStatus(HttpStatus.OK)
    public void DeleteKoers
            (@RequestParam int id) {
        koersService.deleteKoers(id);
    }

    @GetMapping("/Edit")
    @ResponseStatus(HttpStatus.OK)
    public void EditKoers
            (@RequestParam int id, int points, String name) {
         koersService.editKoers(id, points, name);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<KoersResponse> getAllProductsByName
            (@RequestParam List<String> Name) {
        return koersService.getKoersByName(Name);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<KoersResponse> getAllKoerses() {
        return koersService.getAllKoerses();
    }

}
