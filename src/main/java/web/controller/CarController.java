package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    String getCars(Model model) {
        model.addAttribute("cars", Arrays.asList(
                new Car("Lada", "2107", 1998),
                new Car("Chevrolet", "Camaro", 2010),
                new Car("BWM", "X5", 2020),
                new Car("Volvo", "S90", 2023),
                new Car("Hyundai", "Palisade I", 2021)
        ));
        return "cars";
    }
}
