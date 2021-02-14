package Api.Api.Controller;

import Api.Api.Dto.Parking;
import Api.Api.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/getAll")
    public List<Parking> getAll(){
        return parkingService.getParkings();
    }

    @PostMapping("/add")
    public UUID addParking(@RequestBody Parking parking){
        return parkingService.addParking(parking);
    }

}
