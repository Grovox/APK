package GandA.corporation.APK.Controllers;

import GandA.corporation.APK.model.*;
import GandA.corporation.APK.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ViewerController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ExpensesService expensesService;

    @Autowired
    private LandService landService;

    @Autowired
    private PlannedProductionService plannedProductionService;

    @Autowired
    private ProcurementService procurementService;

    @Autowired
    private ProductionCostsService productionCostsService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/showCompany")
    public String showCompanyViewer(Model model) {
        List<Company> companyList = companyService.listAll();
        model.addAttribute("companyList",companyList);

        return "Viewer/showCompany";
    }

    @RequestMapping("/showEmployee")
    public String showEmployeeViewer(Model model) {
        List<Employee> employeeList = employeeService.listAll();
        model.addAttribute("employeeList",employeeList);

        return "Employee/Employee";
    }

    @RequestMapping("/searchEmployeeViewer")
    public String searchEmployeeViewer(Model model, @Param("companyName") String companyName, @Param("surname") String surname, @Param("speciality") String speciality, @Param("email") String email) {
        List<Employee> employeeList = employeeService.searchByEmployeeToViewer(companyName, surname, speciality, email);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("companyName", companyName);
        model.addAttribute("surname", surname);
        model.addAttribute("speciality", speciality);
        model.addAttribute("email", email);

        return "Employee/Employee";
    }

    @RequestMapping("/showExpenses")
    public String showExpensesViewer(Model model) {
        List<Expenses> expensesList = expensesService.listAll();
        model.addAttribute("expensesList",expensesList);

        return "Viewer/showExpenses";
    }

    @RequestMapping("/showLand")
    public String showLandViewer(Model model) {
        List<Land> landList = landService.listAll();
        model.addAttribute("landList",landList);

        return "Viewer/showLand";
    }

    @RequestMapping("/showPlannedProduction")
    public String showPlannedProductionViewer(Model model) {
        List<PlannedProduction> plannedProductionList = plannedProductionService.listAll();
        model.addAttribute("plannedProductionList",plannedProductionList);

        return "Viewer/showPlannedProduction";
    }

    @RequestMapping("/showProcurement")
    public String showProcurementViewer(Model model) {
        List<Procurement> procurementList = procurementService.listAll();
        model.addAttribute("procurementList",procurementList);

        return "Viewer/showProcurement";
    }

    @RequestMapping("/showProductionCosts")
    public String showProductionCostsViewer(Model model) {
        List<ProductionCosts> productionCostsList = productionCostsService.listAll();
        model.addAttribute("productionCostsList",productionCostsList);

        return "Viewer/showProductionCosts";
    }

    @RequestMapping("/showProduct")
    public String showProductViewer(Model model) {
        List<Product> productList = productService.listAll();
        model.addAttribute("productList",productList);

        return "Viewer/showProduct";
    }

    @RequestMapping("/showSale")
    public String showSaleViewer(Model model) {
        List<Sale> saleList = saleService.listAll();
        model.addAttribute("saleList",saleList);

        return "Viewer/showSale";
    }

}
