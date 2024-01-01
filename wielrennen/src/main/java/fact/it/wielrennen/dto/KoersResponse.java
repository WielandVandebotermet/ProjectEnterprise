package fact.it.wielrennen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KoersResponse {
    private String id;
    private String Name;
    private String WielrennerId;
    private int Points;

}
