package Api.Api;


import Api.Api.Dto.Floor;
import Api.Api.Dto.Parking;
import Api.Api.Dto.Place;
import Api.Api.Repositories.FloorRepository;
import Api.Api.Repositories.ParkingRepository;
import Api.Api.Repositories.PlaceRepository;
import Api.Api.Service.FloorService;
import Api.Api.Service.ParkingService;
import Api.Api.Service.PlaceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
public class PlaceTest {

    @TestConfiguration
    static class PlaceServiceTestsContextConfiguration {

        @Bean
        public FloorService floorService() {
            return new FloorService();
        }

        @Bean
        public PlaceService placeService() {
            return new PlaceService();
        }
    }

    @Autowired
    private FloorService floorService;

    @Autowired
    private PlaceService placeService;


    @MockBean
    public PlaceRepository placeRepository;

    @MockBean
    public FloorRepository floorRepository;

    @MockBean
    public ParkingRepository parkingRepository;


    @Before
    public void setUp() {

        Floor floor = new Floor(1,null,null);
        floor.setId(new UUID(1,2));
        List<Floor> floors = new ArrayList<>();
        floors.add(floor);

        Mockito.when(floorRepository.findAll())
                .thenReturn(floors);

    }

    @Test
    public void Add(){
        Floor floor = floorRepository.findAll().get(0);
        Place place = new Place(1,true,false,null);
        placeService.addPlace(place,floor.getId().toString());
        Mockito.verify(placeRepository,Mockito.times(1)).save(place);
    }
    @Test
    public void editPlaceFree(){
        Floor floor = floorRepository.findAll().get(0);
        Place place = new Place(1,true,false,floor);
        place.setId(new UUID(1,2));
        List<Place> places = new ArrayList<>();
        places.add(place);
        Mockito.when(placeRepository.findAll())
                .thenReturn(places);
        placeService.editPlaceFree(place.getId().toString());
        Mockito.verify(placeRepository,Mockito.times(1)).save(place);
    }
    @Test
    public void editPlaceConfirmed(){
        Floor floor = floorRepository.findAll().get(0);
        Place place = new Place(1,true,false,floor);
        place.setId(new UUID(1,2));
        List<Place> places = new ArrayList<>();
        places.add(place);
        Mockito.when(placeRepository.findAll())
                .thenReturn(places);
        placeService.editPlaceConfirmed(place.getId().toString());
        Mockito.verify(placeRepository,Mockito.times(1)).save(place);
    }
    @Test
    public void editPlaceNoFree(){
        Floor floor = floorRepository.findAll().get(0);
        Place place = new Place(1,true,false,floor);
        place.setId(new UUID(1,2));
        List<Place> places = new ArrayList<>();
        places.add(place);
        Mockito.when(placeRepository.findAll())
                .thenReturn(places);
        placeService.editPlaceNoFree(place.getId().toString());
        Mockito.verify(placeRepository,Mockito.times(1)).save(place);
    }



}
