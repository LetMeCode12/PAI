package Api.Api.Service;

import Api.Api.Dto.Floor;
import Api.Api.Dto.Parking;
import Api.Api.Dto.Place;
import Api.Api.Repositories.FloorRepository;
import Api.Api.Repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlaceService {

    @Autowired
    private  FloorRepository floorRepository;
    @Autowired
    private  PlaceRepository placeRepository;

    public UUID addPlace(Place place, String floorID){
        Floor floor = floorRepository.findAll().parallelStream().filter(e->e.getId().toString().equals(floorID)).findFirst().orElse(null);
        place.setFloor(floor);
        place.setFree(true);
        place.setConfirmed(false);
        placeRepository.save(place);
        return place.getId();
    }
    public UUID editPlaceFree(String placeID){
        Place place = placeRepository.findAll().parallelStream().filter(e->e.getId().toString().equals(placeID)).findFirst().orElse(null);
        place.setFree(true);
        place.setConfirmed(false);
        placeRepository.save(place);
        return place.getId();
    }
    public UUID editPlaceConfirmed(String placeID){
        Place place = placeRepository.findAll().parallelStream().filter(e->e.getId().toString().equals(placeID)).findFirst().orElse(null);
        place.setFree(false);
        place.setConfirmed(true);
        placeRepository.save(place);
        return place.getId();
    }
    public UUID editPlaceNoFree(String placeID){
        Place place = placeRepository.findAll().parallelStream().filter(e->e.getId().toString().equals(placeID)).findFirst().orElse(null);
        place.setFree(false);
        place.setConfirmed(false);
        placeRepository.save(place);
        return place.getId();
    }
}
