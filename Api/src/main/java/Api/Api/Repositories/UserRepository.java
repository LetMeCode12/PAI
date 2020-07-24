package Api.Api.Repositories;

import Api.Api.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByemail(String email);
}
