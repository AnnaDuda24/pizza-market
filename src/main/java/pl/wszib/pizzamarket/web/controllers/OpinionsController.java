package pl.wszib.pizzamarket.web.controllers;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PostMapping;
        import pl.wszib.pizzamarket.services.OpinionsService;
        import pl.wszib.pizzamarket.web.mappers.OpinionsMapper;
        import pl.wszib.pizzamarket.web.models.OpinionsModel;

@Controller
public class OpinionsController {

    private final OpinionsService opinionsService;
    private final OpinionsMapper opinionsMapper;


    public OpinionsController(OpinionsService opinionsService, OpinionsMapper opinionsMapper) {
        this.opinionsService = opinionsService;
        this.opinionsMapper = opinionsMapper;
    }

    @GetMapping("/opinions")
    public String showOpinions(Model model){
        model.addAttribute("opinions", opinionsService.findAll());
        model.addAttribute("newOpinion", new OpinionsModel());
        return "opinionsPage";
    }


    @PostMapping("/opinions")
    public  String addOpinion(@ModelAttribute("newOpinion") OpinionsModel opinionsModel, Model model){
        opinionsService.addOpinion(opinionsModel);
        model.addAttribute("opinions", opinionsService.findAll());
        model.addAttribute("newOpinion", new OpinionsModel());

        return "opinionsPage";

    }
}