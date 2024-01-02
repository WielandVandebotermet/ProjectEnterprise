package fact.it.koers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class KoersRequest {
    private String id;
    private String Name;
    private String WielrennerId;
    private int Points;
}
