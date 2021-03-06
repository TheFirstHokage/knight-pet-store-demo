package knight.springframework.petstoredemo.controllers;

import knight.springframework.petstoredemo.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {


    private final VetService vetService;


    public VetController(VetService vetService) {
        this.vetService =vetService;
    }


    @RequestMapping({"", "/index", "/index.html"})
    public String vetsList(Model model) {
        model.addAttribute("vets",vetService.findAll());

        return "/vets/index";
    }

}
