package Api.Api;


import Api.Api.Dto.Floor;
import Api.Api.Dto.Parking;
import Api.Api.Repositories.FloorRepository;
import Api.Api.Repositories.ParkingRepository;
import Api.Api.Service.FloorService;
import Api.Api.Service.ParkingService;
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
public class FloorTest {

    @TestConfiguration
    static class FloorServiceTestsContextConfiguration {

        @Bean
        public ParkingService parkingService() {
            return new ParkingService();
        }
        @Bean
        public FloorService floorService () {
            return new FloorService();
        }
    }


    @Autowired
    private ParkingService parkingService;

    @Autowired
    private FloorService floorService;


    @MockBean
    public ParkingRepository parkingRepository;

    @MockBean
    public FloorRepository floorRepository;



    @Before
    public void setUp() {
        Parking parking = new Parking("Test","Test",123,333,null);
        parking.setId(new UUID(1,2));
        List<Parking> parkings = new ArrayList<>();
        parkings.add(parking);

        Mockito.when(parkingRepository.findAll())
                .thenReturn(parkings);

    }


    @Test
    public void Add(){
        Parking parking = parkingRepository.findAll().get(0);

        Floor floor = new Floor(1,null,null);
        floorService.addFloor(floor,parking.getId().toString());
        Mockito.verify(floorRepository,Mockito.times(1)).save(floor);
    }



}
