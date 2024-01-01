package fact.it.wielrennen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WielrennerRequest {
        private String Firstname;
        private String Lastname;
        private String GroupCode;
}
