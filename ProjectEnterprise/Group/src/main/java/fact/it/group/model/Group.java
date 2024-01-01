package fact.it.group.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="Group")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Group {
    private String id;
    private String name;
    private String GroupCode;
}
