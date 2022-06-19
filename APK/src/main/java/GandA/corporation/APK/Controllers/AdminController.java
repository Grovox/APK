package GandA.corporation.APK.Controllers;

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

        import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/admin")
    public String viewHomePage(Model model) {
        List<User> listUser = userService.listAll();
        model.addAttribute("listUser", listUser);
        return "Admin/admin";
    }

    @RequestMapping("/editUserActive/{id}")
    public String editUserActive(@PathVariable(name = "id") Long id) {

        User user = userService.get(id);
        user.setEnabled(!user.isEnabled());

        userService.save(user);

        return "redirect:/admin";
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
            return "redirect:/editUserPassword/" + Userid +"?error=true";
        }

        User userSave = userService.get(Userid);
        userSave.setPassword(user.getPassword());
        userService.save(userSave);

        return "redirect:/admin";
    }

    @RequestMapping("/editUserRole/{id}")
    public String editUserRole(@PathVariable(name = "id") Long id, Model model) {

        List<Role> roleList = roleService.listAll();

        model.addAttribute("roleList",roleList);
        model.addAttribute("id",id);

        return "User/edit_user_role";
    }

    @RequestMapping(value = "/editUserRoleSave/{Userid}", method = RequestMethod.POST)
    public String editUserRole(@PathVariable(name = "Userid") Long Userid,@Param("Roleid") Long Roleid) {
        User user = userService.get(Userid);
        if(Roleid != null) {
            user.setRoleUser(roleService.get(Roleid));
        }else {
            user.setRoleUser(null);
        }
        userService.save(user);

        return "redirect:/admin";
    }


    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {

        userService.delete(id);

        return "redirect:/admin";
    }

    @RequestMapping("/searchUserAdmin")
    public String searchUser(Model model, @Param("keyword") String keyword) {
        List<User> listUser = userService.searchByUser(keyword);
        model.addAttribute("listUser", listUser);
        model.addAttribute("keyword", keyword);

        return "Admin/admin";
    }

}
