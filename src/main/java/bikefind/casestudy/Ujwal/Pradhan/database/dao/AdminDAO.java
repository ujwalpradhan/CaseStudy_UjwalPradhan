package bikefind.casestudy.Ujwal.Pradhan.database.dao;

import bikefind.casestudy.Ujwal.Pradhan.database.entity.Product;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminDAO extends JpaRepository<User, Long> {

    public List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    Product findById(Integer userId);
}
