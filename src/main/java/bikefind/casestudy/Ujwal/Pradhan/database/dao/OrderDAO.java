package bikefind.casestudy.Ujwal.Pradhan.database.dao;

import bikefind.casestudy.Ujwal.Pradhan.database.entity.Order;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Long> {
    List<Order> findAllByUserId(Integer userId);

    Order findByUserAndStatus(@Param("User") User user, @Param("status") String status);
}
