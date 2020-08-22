package Api.Api.Dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
@JsonIgnoreProperties(value = {"floor"})
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain=true)
@Entity
@Table(name = "Place")
public class Place {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private Integer nrPlace;
    private Boolean free;
    private Boolean confirmed;
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "floor_id",referencedColumnName = "id")
    private Floor floor;

    public Place(Integer nrPlace, Boolean free, Boolean confirmed, Floor floor) {
        this.nrPlace = nrPlace;
        this.free = free;
        this.confirmed = confirmed;
        this.floor = floor;
    }
}
