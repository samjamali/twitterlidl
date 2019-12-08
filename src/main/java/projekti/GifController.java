/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;
 
import java.io.IOException;
import java.util.ListIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.net.www.content.image.gif;
 
/**
 *
 * @author Borna
 */
@Controller
public class GifController {
 
    @Autowired
    private GifRepository gifRepository;
 
    @GetMapping("/gifs")
    public String view() {
        return "redirect:/gifs/1";
    }
 
    @GetMapping(value = "/gifs/{id}")
    public String viewOne(Model model, @PathVariable Long id) {
        Long imageCount = gifRepository.count();
        model.addAttribute("count", imageCount);
 
        if (id >= 1L && id <= imageCount) {
            model.addAttribute("current", id);
        }
 
        if (id < imageCount && id > 0L) {
            model.addAttribute("next", id + 1);
        }
 
        if (id > 1L) {
            model.addAttribute("previous", id - 1);
        }
 
        return "gifs";
    }
 
    @PostMapping("/gifs")
    public String add(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.getContentType().equals("image/gif")) {
            return "redirect:/gifs";
        }
 
        Gif gifObject = new Gif();
        gifObject.setContent(file.getBytes());
        gifRepository.save(gifObject);
 
        return "redirect:/gifs";
    }
 
    @GetMapping(path = "/gifs/{id}/content", produces = "image/gif")
    @ResponseBody
    public byte[] getContent(@PathVariable Long id) {
        return gifRepository.getOne(id).getContent();
    }
}