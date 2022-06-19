package GandA.corporation.APK.repo;

import GandA.corporation.APK.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User getUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User getUserById(Long id);

    @Query("SELECT u FROM User u WHERE u.roleUser.id = 1 or u.roleUser.id = 2")
    List<User> getUserToManager();

    @Query("SELECT u FROM User u WHERE u.company is null and u.roleUser.id = 2")
    List<User> getUserToAddInCompany();

    List<User> findByEmailContainingOrCompanyContaining(String email,String company);

}
