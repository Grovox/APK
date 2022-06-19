package GandA.corporation.APK.model;

import GandA.corporation.APK.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String username;

    private String surname;

    private String patronymic;

    private String phone;

    private String passport;

    private String SNILS;

    private String INN;

    private String code_KLADR;

    private String DOB;

    private String education;

    private String profession;

    private String experience_general;

    private String experience_organization;

    private String company;

    private boolean enabled;

    @Transient
    transient private String confirmPassword;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleUser;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyToUser;

    public Role getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(Role roleUser) {
        this.roleUser = roleUser;
    }

    public Company getCompanyToUser() {
        return companyToUser;
    }

    public void setCompanyToUser(Company companyToUser) {
        this.companyToUser = companyToUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getSNILS() {
        return SNILS;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getCode_KLADR() {
        return code_KLADR;
    }

    public void setCode_KLADR(String code_KLADR) {
        this.code_KLADR = code_KLADR;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getExperience_general() {
        return experience_general;
    }

    public void setExperience_general(String experience_general) {
        this.experience_general = experience_general;
    }

    public String getExperience_organization() {
        return experience_organization;
    }

    public void setExperience_organization(String experience_organization) {
        this.experience_organization = experience_organization;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}