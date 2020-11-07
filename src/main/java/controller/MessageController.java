package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(Model model) {
        model.addAttribute(new User());
        model.addAttribute("message", "This is my first MVC page");
        return "home";
    }

    @RequestMapping(value = "/showUser", method = RequestMethod.POST)
    public String showUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        return "user";
    }

    @RequestMapping(value = "/sayhello")
    public String hello1(@RequestParam("fn") String name, @RequestParam("ln") String surname) {

        return "hello1";

    }

    @RequestMapping(value = "/sayhello/{name}/{surname}")
    public String hello2(@PathVariable String name, @PathVariable String surname) {

        return "hello2";
    }
}