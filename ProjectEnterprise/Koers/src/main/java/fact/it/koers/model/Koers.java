package fact.it.koers.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Koers")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Koers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String Name;
    private String WielrennerId;
    private int Points;
}
