package fact.it.wielrennen.controller;

import fact.it.wielrennen.Service.WielrennerService;
import fact.it.wielrennen.dto.WielrennerResponse;
import fact.it.wielrennen.dto.WielrennerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wielrenner")
@RequiredArgsConstructor
public class Wielrennercontroller {

    private final WielrennerService wielrennerService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void CreateWielrennen(@RequestBody WielrennerRequest wielrennerRequest) {
        wielrennerService.createWielrennen(wielrennerRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WielrennerResponse> getAllWielrenners() {
        return wielrennerService.getAllwielrenners();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WielrennerResponse> getAllWielrennersByGroupCode
            (@RequestParam List<String> GroupCode) {
        return wielrennerService.getAllWielrennersByGroupcode(GroupCode);
    }

    @GetMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void DeleteWielrenners
            (@RequestParam int id) {
        wielrennerService.deleteWielrenners(id);
    }

    @GetMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public void EditWielrenners
            (@RequestParam int id, String Firstname, String Lastname, String GroupCode) {
        wielrennerService.editWielrenners(id,Firstname,Lastname,GroupCode);

    }

}
