/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
 
 
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Borna
 */
@Controller
public class ViestiController {

    @Autowired
    private ViestitRepository ViestiRepo;


    @GetMapping("/seina")
    public String list(Model model){
        Sort sort = Sort.by("messageDate");
        Pageable pageable = PageRequest.of(0,5,Sort.by("messageDate").descending());
         model.addAttribute("messages", ViestiRepo.findAll(pageable));
        return "seina";
    }

    @PostMapping("/seina")
    public String create(@RequestParam String message){
        Viestit viesti = new Viestit();
        viesti.setMessage(message);
        ViestiRepo.save(viesti);

        return "redirect:/seina";
    }
}