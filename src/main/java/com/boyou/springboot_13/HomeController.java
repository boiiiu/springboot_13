package com.boyou.springboot_13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ActorRepository actorRepository;

    @RequestMapping("/")
    public String loadData(Model model){

        Actor a = new Actor();
        a.setName("Sandra Bullock");
        a.setRealname("Sandra Mae Bullowski");
       // actorRepository.save(a);


        Movie movie = new Movie();
        movie.setTitle("Emoji movie");
        movie.setYear(2017);
        movie.setDescription("emojis");

        a.addMovie(movie);
        actorRepository.save(a);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
