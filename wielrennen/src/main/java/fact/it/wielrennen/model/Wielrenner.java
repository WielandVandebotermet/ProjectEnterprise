package fact.it.wielrennen.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Wielrenner")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wielrenner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Firstname;
    private String Lastname;
    private String GroupCode;
}
