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


    @DeleteMapping("/Delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void DeleteWielrenners
            (@PathVariable("id") String id) {
        wielrennerService.deleteWielrenners(Integer.parseInt(id));
    }

    @PutMapping("/Edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void EditWielrenners
            (@PathVariable("id") String id, @RequestBody WielrennerRequest wielrennerRequest) {
        wielrennerService.editWielrenners(Integer.parseInt(id),wielrennerRequest);

    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<WielrennerResponse> getAllWielrenners() {
        return wielrennerService.getAllwielrenners();
    }

}
