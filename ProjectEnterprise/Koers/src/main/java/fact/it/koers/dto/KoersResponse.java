package fact.it.koers.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class KoersResponse {
    private String id;
    private String Name;
    private String WielrennerId;
    private int Points;
}
