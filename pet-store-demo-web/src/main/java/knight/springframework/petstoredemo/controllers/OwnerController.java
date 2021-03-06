package knight.springframework.petstoredemo.controllers;


import knight.springframework.petstoredemo.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping({"","/","/index","/index.html"})
    public String ownersList(Model model) {
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }
}
