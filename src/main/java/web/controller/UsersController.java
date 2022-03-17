package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/user")
    public String getIndex(Model model){
        model.addAttribute("people",userService.index());
        return "index";
    }

    @GetMapping(value = "/user/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        model.addAttribute("user",userService.show(id));
        return "user";
    }

    @GetMapping(value = "user/new")
    public String newPerson (Model model) {
        model.addAttribute("person", new User());
        System.out.println();
        return "new";
    }
    @PostMapping("user")
    public String create (@ModelAttribute ("person") @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/new";
        }
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping(value = "user/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("person", userService.show(id));
        return "edit";

    }

    @PatchMapping("user/{id}")
    public String update (@ModelAttribute ("person") @Valid User user, BindingResult bindingResult , @PathVariable("id") Long id) {
        if(bindingResult.hasErrors()){
            return "/edit";
        }
        userService.update(id,user);
        return "redirect:/user";
    }

    @DeleteMapping("user/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/user";

    }

}
