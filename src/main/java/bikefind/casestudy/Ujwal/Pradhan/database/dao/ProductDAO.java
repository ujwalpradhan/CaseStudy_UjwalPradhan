package bikefind.casestudy.Ujwal.Pradhan.database.dao;

import bikefind.casestudy.Ujwal.Pradhan.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {

    public List<Product> findByProductNameContainingIgnoreCase(@Param("productName") String productName);

    Product findById(Integer productId);
}
