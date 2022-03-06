package bikefind.casestudy.Ujwal.Pradhan.database.dao;


import bikefind.casestudy.Ujwal.Pradhan.database.entity.Order;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.OrderProducts;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderProductsDAO extends JpaRepository<OrderProducts, Long> {

    public List<OrderProducts> findByOrder(Order order);
}
