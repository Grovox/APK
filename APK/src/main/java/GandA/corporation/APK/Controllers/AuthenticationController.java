package GandA.corporation.APK.Controllers;

import GandA.corporation.APK.model.User;
import GandA.corporation.APK.service.UserService;
import GandA.corporation.APK.vilidator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "index/index";
    }

    @GetMapping("/index")
    public String viewHomePageLogin(Model model) {
        return "index/index_login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "index/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        user.setEmail(user.getEmail().toLowerCase());

        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "User/error_password";
        }

        userService.save(user);
        return "/registration";
    }

    @GetMapping("/login")
    public String get(Model model) {
        return "index/login";
    }
}
