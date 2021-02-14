package Api.Api;


import Api.Api.Dto.Floor;
import Api.Api.Dto.Parking;
import Api.Api.Repositories.ParkingRepository;
import Api.Api.Service.ParkingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class ParkingTest {

    @TestConfiguration
    static class ParkingServiceTestsContextConfiguration {

        @Bean
        public ParkingService parkingService() {
            return new ParkingService();
        }
    }


    @Autowired
    private ParkingService parkingService;

    @MockBean
    public ParkingRepository parkingRepository;



    @Before
    public void setUp() {
        Parking parking = new Parking("Test","Test",123,333,null);
        List<Parking> parkings = new ArrayList<>();
        parkings.add(parking);

        Mockito.when(parkingRepository.findAll())
                .thenReturn(parkings);

    }

    @Test
    public void Get(){
        Assert.assertNotNull(parkingService.getParkings());
    }

    @Test
    public void Add(){
        Parking parking2 = new Parking("Test","Test",123,333,null);
        parkingService.addParking(parking2);
        Mockito.verify(parkingRepository,Mockito.times(1)).save(parking2);
    }



}
