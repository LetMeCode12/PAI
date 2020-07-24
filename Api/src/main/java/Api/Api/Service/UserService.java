package Api.Api.Service;


import Api.Api.Dto.User;
import Api.Api.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole("ROLE_"+user.getRole());
        userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
