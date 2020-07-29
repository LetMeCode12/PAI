package Api.Api.Controller;

import Api.Api.Dto.Floor;
import Api.Api.Service.FloorService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/floor")
public class FloorController {
    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @PostMapping("/add/{Parking_ID}")
    private String addFloor(@RequestBody Floor floor, @PathVariable("Parking_ID") String parkingID){
        return floorService.addFloor(floor,parkingID);
    }
}
