package GandA.corporation.APK.repo;

import GandA.corporation.APK.model.Employee;
import GandA.corporation.APK.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT u FROM Product u where "
            + " u.companyToProduct.company_name like %:companyName% "
            + " and u.product_type like %:productName% ")
    List<Product> searchByProductToViewer(String companyName, String productName);
}