package fi.product.ProductApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ProductApplicationController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}