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

    private final FloorRepository floorRepository;
    private final ParkingRepository parkingRepository;

    @Autowired
    public FloorService(FloorRepository floorRepository, ParkingRepository parkingRepository) {
        this.floorRepository = floorRepository;
        this.parkingRepository = parkingRepository;
    }

    public UUID addFloor(Floor floor, String parkingId){

      Parking parking = parkingRepository.findAll().parallelStream().filter(e->e.getId().toString().equals(parkingId)).findFirst().orElse(null);
      floor.setParking(parking);
      floorRepository.save(floor);
      return floor.getId();
    }
}
