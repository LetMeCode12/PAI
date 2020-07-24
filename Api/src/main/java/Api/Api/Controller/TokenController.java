package Api.Api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @GetMapping("/isToken")
    private String isToken() {
      return "ok";
    }
}
