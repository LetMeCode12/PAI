package Api.Api.Controller;

import Api.Api.Dto.User;
import Api.Api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    private void registerUser (@RequestBody User user){
        userService.addNewUser(user);
    }

    @GetMapping("/getAll")
    private List<User> getAllUsers (){
        return userService.getUsers();
    }
}
