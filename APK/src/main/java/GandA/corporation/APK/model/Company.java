package GandA.corporation.APK.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String company_name;

    private boolean active;

    private String phone;

    private String email;

    private String industry;

    private String main_product;

    private int amount_workers;

    private String Code_KLADR;

    private String Code_OKATO;

    private String Code_OKTMO;

    private String Code_OKOGY;

    private String OKPO;

    private String OGRN;

    private String INN;

    @OneToMany(mappedBy = "companyToUser")
    private List<User> companyUser;

    @OneToMany(mappedBy = "companyToLand")
    private List<Land> companyLand;

    @OneToMany(mappedBy = "companyToEmployee")
    private List<Employee> companyEmployee;

    @OneToMany(mappedBy = "companyToPlannedProduction")
    private List<PlannedProduction> companyPlannedProduction;

    @OneToMany(mappedBy = "companyToProductionCosts")
    private List<ProductionCosts> companyProductionCosts;

    @OneToMany(mappedBy = "companyToExpenses")
    private List<Expenses> companyExpenses;

    @OneToMany(mappedBy = "companyToProcurement")
    private List<Procurement> companyProcurement;

    @OneToMany(mappedBy = "companyToProduct")
    private List<Product> companyProduct;

    @OneToMany(mappedBy = "companyToSale")
    private List<Sale> companySale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getMain_product() {
        return main_product;
    }

    public void setMain_product(String main_product) {
        this.main_product = main_product;
    }

    public int getAmount_workers() {
        return amount_workers;
    }

    public void setAmount_workers(int amount_workers) {
        this.amount_workers = amount_workers;
    }

    public String getCode_KLADR() {
        return Code_KLADR;
    }

    public void setCode_KLADR(String code_KLADR) {
        Code_KLADR = code_KLADR;
    }

    public String getCode_OKATO() {
        return Code_OKATO;
    }

    public void setCode_OKATO(String code_OKATO) {
        Code_OKATO = code_OKATO;
    }

    public String getCode_OKTMO() {
        return Code_OKTMO;
    }

    public void setCode_OKTMO(String code_OKTMO) {
        Code_OKTMO = code_OKTMO;
    }

    public String getCode_OKOGY() {
        return Code_OKOGY;
    }

    public void setCode_OKOGY(String code_OKOGY) {
        Code_OKOGY = code_OKOGY;
    }

    public String getOKPO() {
        return OKPO;
    }

    public void setOKPO(String OKPO) {
        this.OKPO = OKPO;
    }

    public String getOGRN() {
        return OGRN;
    }

    public void setOGRN(String OGRN) {
        this.OGRN = OGRN;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public List<User> getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(List<User> companyUser) {
        this.companyUser = companyUser;
    }

    public List<Land> getCompanyLand() {
        return companyLand;
    }

    public void setCompanyLand(List<Land> companyLand) {
        this.companyLand = companyLand;
    }

    public List<Employee> getCompanyEmployee() {
        return companyEmployee;
    }

    public void setCompanyEmployee(List<Employee> companyEmployee) {
        this.companyEmployee = companyEmployee;
    }

    public List<PlannedProduction> getCompanyPlannedProduction() {
        return companyPlannedProduction;
    }

    public void setCompanyPlannedProduction(List<PlannedProduction> companyPlannedProduction) {
        this.companyPlannedProduction = companyPlannedProduction;
    }

    public List<ProductionCosts> getCompanyProductionCosts() {
        return companyProductionCosts;
    }

    public void setCompanyProductionCosts(List<ProductionCosts> companyProductionCosts) {
        this.companyProductionCosts = companyProductionCosts;
    }

    public List<Expenses> getCompanyExpenses() {
        return companyExpenses;
    }

    public void setCompanyExpenses(List<Expenses> companyExpenses) {
        this.companyExpenses = companyExpenses;
    }

    public List<Procurement> getCompanyProcurement() {
        return companyProcurement;
    }

    public void setCompanyProcurement(List<Procurement> companyProcurement) {
        this.companyProcurement = companyProcurement;
    }

    public List<Product> getCompanyProduct() {
        return companyProduct;
    }

    public void setCompanyProduct(List<Product> companyProduct) {
        this.companyProduct = companyProduct;
    }

    public List<Sale> getCompanySale() {
        return companySale;
    }

    public void setCompanySale(List<Sale> companySale) {
        this.companySale = companySale;
    }
}
