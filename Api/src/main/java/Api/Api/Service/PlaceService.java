package Api.Api.Service;

import Api.Api.Dto.Floor;
import Api.Api.Dto.Parking;
import Api.Api.Dto.Place;
import Api.Api.Repositories.FloorRepository;
import Api.Api.Repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    private final FloorRepository floorRepository;
    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(FloorRepository floorRepository, PlaceRepository placeRepository) {
        this.floorRepository = floorRepository;
        this.placeRepository = placeRepository;
    }

    public String addPlace(Place place, String floorID){
        Floor floor = floorRepository.findAll().parallelStream().filter(e->e.getId().toString().equals(floorID)).findFirst().orElse(null);
        place.setFloor(floor);
        place.setFree(true);
        place.setConfirmed(false);
        placeRepository.save(place);
        return "Done";
    }
    public String editPlaceFree(String placeID){
        Place place = placeRepository.findAll().parallelStream().filter(e->e.getId().toString().equals(placeID)).findFirst().orElse(null);
        place.setFree(true);
        place.setConfirmed(false);
        placeRepository.save(place);
        return "Done";
    }
    public String editPlaceConfirmed(String placeID){
        Place place = placeRepository.findAll().parallelStream().filter(e->e.getId().toString().equals(placeID)).findFirst().orElse(null);
        place.setFree(false);
        place.setConfirmed(true);
        placeRepository.save(place);
        return "Done";
    }
    public String editPlaceNoFree(String placeID){
        Place place = placeRepository.findAll().parallelStream().filter(e->e.getId().toString().equals(placeID)).findFirst().orElse(null);
        place.setFree(false);
        place.setConfirmed(false);
        placeRepository.save(place);
        return "Done";
    }
}
