package GandA.corporation.APK.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String surname;

    private String patronymic;

    private String gender;

    private int age;

    private String speciality;

    private String total_work_experience;

    private String company_work_experience;

    private String job_title;

    private String phone;

    private String email;

    private String salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyToEmployee;

    public Company getCompanyToEmployee() {
        return companyToEmployee;
    }

    public void setCompanyToEmployee(Company companyToEmployee) {
        this.companyToEmployee = companyToEmployee;
    }

    public String getTotal_work_experience() {
        return total_work_experience;
    }

    public void setTotal_work_experience(String total_work_experience) {
        this.total_work_experience = total_work_experience;
    }

    public String getCompany_work_experience() {
        return company_work_experience;
    }

    public void setCompany_work_experience(String company_work_experience) {
        this.company_work_experience = company_work_experience;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
