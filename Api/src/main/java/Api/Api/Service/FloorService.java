package Api.Api.Service;

import Api.Api.Dto.Floor;
import Api.Api.Dto.Parking;
import Api.Api.Repositories.FloorRepository;
import Api.Api.Repositories.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FloorService {

    @Autowired
    private   FloorRepository floorRepository;
    @Autowired
    private   ParkingRepository parkingRepository;


    public UUID addFloor(Floor floor, String parkingId){

      Parking parking = parkingRepository.findAll().parallelStream().filter(e->e.getId().toString().equals(parkingId)).findFirst().orElse(null);
      floor.setParking(parking);
      floorRepository.save(floor);
      return floor.getId();
    }
}
