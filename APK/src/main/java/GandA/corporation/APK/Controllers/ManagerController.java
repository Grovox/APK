package GandA.corporation.APK.Controllers;

import GandA.corporation.APK.model.Company;
import GandA.corporation.APK.model.Role;
import GandA.corporation.APK.model.User;
import GandA.corporation.APK.service.CompanyService;
import GandA.corporation.APK.service.RoleService;
import GandA.corporation.APK.service.UserService;
import GandA.corporation.APK.vilidator.CompanyValidator;
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

@Controller
public class ManagerController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyValidator companyValidator;

    @RequestMapping("/manager")
    public String viewHomeManagerPage(Model model) {

        return "Manager/manager";
    }

    @RequestMapping("/users")
    public String viewUsersPage(Model model) {
        List<User> listUser = userService.getUserToManager();
        model.addAttribute("listUser", listUser);
        return "User/users";
    }

    @RequestMapping("/company")
    public String viewCompanyPage(Model model) {
        List<Company> companyList = companyService.listAll();
        model.addAttribute("companyList", companyList);
        return "Company/company";
    }

    @RequestMapping("/moreUser/{id}")
    public String moreUser(@PathVariable(name = "id") Long id,Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "User/moreUser";
    }

    @RequestMapping("/searchUserManager")
    public String searchUser(Model model, @Param("keyword") String keyword) {
        List<User> listUser = userService.searchByUser(keyword);
        model.addAttribute("listUser", listUser);
        model.addAttribute("keyword", keyword);

        return "Admin/admin";
    }

    @RequestMapping("/editUser/{id}")
    public ModelAndView showEditUser(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("User/edit_user");

        User user = userService.get(id);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping(value = "/editUserSave{Userid}", method = RequestMethod.POST)
    public String editUserSave(@ModelAttribute("user") User user,@PathVariable(name = "Userid") Long Userid) {
        User userSave = userService.get(Userid);
        userSave.setEmail(user.getEmail());
        userSave.setUsername(user.getUsername());
        userSave.setSurname(user.getSurname());
        userSave.setPatronymic(user.getPatronymic());
        userSave.setPhone(user.getPhone());
        userSave.setPassport(user.getPassport());
        userSave.setSNILS(user.getSNILS());
        userSave.setINN(user.getINN());
        userSave.setCode_KLADR(user.getCode_KLADR());
        userSave.setDOB(user.getDOB());
        userSave.setEducation(userSave.getEducation());
        userSave.setProfession(user.getProfession());
        userSave.setExperience_general(user.getExperience_general());
        userSave.setExperience_organization(user.getExperience_organization());


        userService.saveNotPassword(userSave);

        return "redirect:/moreUser/"+Userid;
    }

    @RequestMapping("/moreCompany/{id}")
    public String viewCompanyPage(@PathVariable(name = "id") Long id,Model model) {
        Company company = companyService.get(id);
        model.addAttribute("company", company);
        return "Company/moreCompany";
    }

    @RequestMapping("/newCompany")
    public String showNewCompanyForm(Model model) {
        Company company = new Company();
        List<User> listUsers = userService.getUserToAddInCompany();

        model.addAttribute("listUsers", listUsers);
        model.addAttribute("company", company);

        return "Company/new_company";
    }

    @RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
    public String saveCompany(@ModelAttribute("company") Company company, @ModelAttribute("id") Long id, BindingResult bindingResult) {
        companyValidator.validate(company, bindingResult);

        if (bindingResult.hasErrors()) {
            return "redirect:/newCompany";
        }

        User userSave = userService.get(id);
        company.setId(null);
        companyService.save(company);
        userSave.setCompany(company.getCompany_name());
        userSave.setCompanyToUser(company);
        userService.saveNotPassword(userSave);

        return "redirect:/company";
    }

    @RequestMapping("/editCompany/{id}")
    public ModelAndView showEditCompanyForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("Company/edit_company");

        Company company = companyService.get(id);
        mav.addObject("company", company);
        return mav;
    }

    @RequestMapping(value = "/editCompanySave/{id}", method = RequestMethod.POST)
    public String editCompanySave(@ModelAttribute("company") Company company,@PathVariable(name = "id") Long id) {

        Company companySave = companyService.get(id);
        companySave.setCompany_name(company.getCompany_name());
        companySave.setActive(company.isActive());
        companySave.setPhone(company.getPhone());
        companySave.setEmail(company.getEmail());
        companySave.setIndustry(company.getIndustry());
        companySave.setMain_product(company.getMain_product());
        companySave.setAmount_workers(company.getAmount_workers());
        companySave.setCode_KLADR(company.getCode_KLADR());
        companySave.setCode_OKATO(company.getCode_OKATO());
        companySave.setCode_OKTMO(company.getCode_OKTMO());
        companySave.setCode_OKOGY(company.getCode_OKOGY());
        companySave.setINN(company.getINN());
        companySave.setOKPO(company.getOKPO());
        companySave.setOGRN(company.getOGRN());
        List<User> users = companySave.getCompanyUser();
        for (User user : users)
            user.setCompany(company.getCompany_name());

        companyService.save(companySave);

        return "redirect:/moreCompany/"+id;
    }

    @RequestMapping("/addUserToCompany/{id}")
    public ModelAndView showAddUserToCompany(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("Company/add_UserToCompany");
        List<User> listUsers = userService.getUserToAddInCompany();
        Company company = companyService.get(id);
        mav.addObject("listUsers", listUsers);
        mav.addObject("company", company);

        return mav;
    }

    @RequestMapping(value = "/addUserToCompanySave{idCompany}", method = RequestMethod.POST)
    public String addUserToCompanySave(@PathVariable(name = "idCompany") Long idCompany, @ModelAttribute("id") Long idUser) {
        Company company = companyService.get(idCompany);
        User user = userService.get(idUser);
        user.setCompany(company.getCompany_name());
        user.setCompanyToUser(company);
        userService.saveNotPassword(user);

        return "redirect:/moreCompany/"+idCompany;
    }

    @RequestMapping("/deleteUserToCompany/{id}")
    public ModelAndView showDeleteUserToCompany(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("Company/delete_UserToCompany");

        Company company = companyService.get(id);
        User user = new User();
        List<User> listUsers = company.getCompanyUser();
        mav.addObject("listUsers", listUsers);
        mav.addObject("company", company);

        return mav;
    }

    @RequestMapping(value = "/deleteSelectUserToCompany{Companyid}", method = RequestMethod.POST)
    public String deleteUserToCompany(@Param("UserId") Long UserId,@PathVariable("Companyid") Long Companyid) {
        if(UserId != 0){
            User user = userService.get(UserId);
            user.setCompany(null);
            user.setCompanyToUser(null);
            userService.saveNotPassword(user);
        }

        return "redirect:/moreCompany/"+Companyid;
    }

    @RequestMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable(name = "id") Long id) {
        Company company = companyService.get(id);
        List<User> users = company.getCompanyUser();
        for(User user : users){
            user.setCompany(null);
            user.setCompanyToUser(null);
            userService.saveNotPassword(user);
        }
        companyService.delete(id);

        return "redirect:/company";
    }

    @RequestMapping("/searchCompanyManager")
    public String searchCompany(Model model, @Param("keyword") String keyword) {
        List<Company> companyList = companyService.searchByCompany(keyword);
        model.addAttribute("companyList", companyList);
        model.addAttribute("keyword", keyword);

        return "Company/company";
    }

}
