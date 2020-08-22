package Api.Api.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain=true)
@Entity
@Table(name = "Parking")
public class Parking {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private float open;
    @Column(nullable = false)
    private float closed;
    @JsonProperty(value = "floors")
    @OneToMany(mappedBy = "parking", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Floor> floor;

    public Parking(String street, String city, float open, float closed, List<Floor> floor) {
        this.street = street;
        this.city = city;
        this.open = open;
        this.closed = closed;
        this.floor = floor;
    }
}
