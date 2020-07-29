package Api.Api.Service;

import Api.Api.Dto.Parking;
import Api.Api.Repositories.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> getParkings(){
        return parkingRepository.findAll();
    }

    public String addParking(Parking parking){
        parkingRepository.save(parking);
        return "Done";
    }

}