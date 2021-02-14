package Api.Api.Controller;

import Api.Api.Dto.Floor;
import Api.Api.Service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/floor")
public class FloorController {
    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @PostMapping("/add/{Parking_ID}")
    private UUID addFloor(@RequestBody Floor floor, @PathVariable("Parking_ID") String parkingID){
        return floorService.addFloor(floor,parkingID);
    }
}
