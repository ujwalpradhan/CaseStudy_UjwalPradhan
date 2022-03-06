package bikefind.casestudy.Ujwal.Pradhan.database.dao;


import bikefind.casestudy.Ujwal.Pradhan.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    @Query("select ur from UserRole ur where ur.user.id = :userId")
    List<UserRole> getUserRoles(@Param("userId")  Integer userId);

}
