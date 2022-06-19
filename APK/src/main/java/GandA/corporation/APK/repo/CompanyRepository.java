package GandA.corporation.APK.repo;

import GandA.corporation.APK.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT u FROM Company u where u.company_name = :company_name")
    Company findByCompany_name(String company_name);

    @Query("SELECT u FROM Company u where u.company_name like %:company_name%")
    List<Company> findByCompany_nameContaining(String company_name);

    //List<User> findByEmailContainingOrCompanyContaining(String email, String company);

}