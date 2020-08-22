package Api.Api.Dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(value = {"parking"})
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain=true)
@Entity
@Table(name = "Floor")
public class Floor {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private Integer nrFloor;
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Place> places;
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "parking_id",referencedColumnName = "id")
    private Parking parking;

    public Floor(Integer nrFloor, List<Place> places, Parking parking) {
        this.nrFloor = nrFloor;
        this.places = places;
        this.parking = parking;
    }
}
