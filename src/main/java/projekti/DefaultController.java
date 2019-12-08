package projekti;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String helloWorld() {
        return "seina";
    }

    @GetMapping("/index")
    public String read() {
        return "index";
    }

    @GetMapping("/profiili")
    public String list() {
        return "profiili";
    }

    @GetMapping("/etusivu")
    public String form() {
        return "seina.html";
    }
}
