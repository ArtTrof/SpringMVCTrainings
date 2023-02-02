package org.example.controllers;


import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        //Here we ll get all people from DAO and will implement this people to view
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model) {
        //here we ll get one man from its id from DAO and will implement this man to views
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }


    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person",new Person());
        return "people/new";
    }

    //with @modelAttribute
//    @GetMapping("/new")
//    public String newPerson(@ModelAttribute("person") Person person){
//        return "people/new";
//    }
    @PostMapping
    public String create(@ModelAttribute("person")Person person){
        personDAO.save(person);
        return "redirect:/people";
    }

}

