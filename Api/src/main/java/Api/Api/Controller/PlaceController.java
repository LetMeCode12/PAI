package Api.Api.Controller;

import Api.Api.Dto.Place;
import Api.Api.Service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping("/add/{floor_ID}")
    private UUID addPlace(@RequestBody Place place, @PathVariable String floor_ID){
        return placeService.addPlace(place,floor_ID);
    }
    @PutMapping("/edit/{place_ID}/noFree")
    private UUID editPlaceNoFree(@PathVariable String place_ID){
        return placeService.editPlaceNoFree(place_ID);
    }
    @PutMapping("/edit/{place_ID}/Free")
    private UUID editPlaceFree(@PathVariable String place_ID){
        return placeService.editPlaceFree(place_ID);
    }
    @PutMapping("/edit/{place_ID}/noFreeConfirmed")
    private UUID editPlaceConfirmed(@PathVariable String place_ID){
        return placeService.editPlaceConfirmed(place_ID);
    }

}
