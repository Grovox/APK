package GandA.corporation.APK.repo;

import GandA.corporation.APK.model.Company;
import GandA.corporation.APK.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT u FROM Employee u where "
            + " u.companyToEmployee.company_name like %:companyName% "
            + " and u.surname like %:surname% "
            + " and u.speciality like %:speciality% "
            + " and u.email like %:email% ")
    List<Employee> searchByEmployeeToViewer(String companyName, String surname, String speciality, String email);

}