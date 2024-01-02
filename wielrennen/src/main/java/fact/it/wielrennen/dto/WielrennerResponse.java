package fact.it.wielrennen.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WielrennerResponse {
    private long id;
    private String Firstname;
    private String Lastname;
    private String GroupCode;
}
