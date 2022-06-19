package GandA.corporation.APK.Controllers;

        import GandA.corporation.APK.model.Company;
        import GandA.corporation.APK.model.Role;
        import GandA.corporation.APK.model.User;
        import GandA.corporation.APK.service.RoleService;
        import GandA.corporation.APK.service.UserService;
        import GandA.corporation.APK.vilidator.UserValidator;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.servlet.ModelAndView;

        import java.util.List;
        import java.util.Set;

@Controller
public class AdminController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping("/admin")
    public String viewHomePage(Model model) {
        List<User> listUser = userService.listAll();
        model.addAttribute("listUser", listUser);
        return "Admin/admin";
    }

    @RequestMapping("/editUserPassword/{id}")
    public String showEditUserPassword(@PathVariable(name = "id") Long id, Model model) {
        User user = new User();
        user.setId(id);
        model.addAttribute("user",user);

        return "User/edit_UserPassword";
    }

    @RequestMapping(value = "/editUserPasswordSave{Userid}", method = RequestMethod.POST)
    public String editUserPasswordSave(@ModelAttribute("user") User user, @PathVariable(name = "Userid") Long Userid, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "User/error_password";
        }

        User userSave = userService.get(Userid);
        userSave.setPassword(user.getPassword());
        userService.save(userSave);

        return "redirect:/admin";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {

        userService.delete(id);

        return "redirect:/admin";
    }

    @RequestMapping("/searchUser")
    public String searchUser(Model model, @Param("keyword") String keyword) {
        List<User> listUser = userService.searchByUser(keyword);
        model.addAttribute("listUser", listUser);
        model.addAttribute("keyword", keyword);

        return "Admin/admin";
    }

}
