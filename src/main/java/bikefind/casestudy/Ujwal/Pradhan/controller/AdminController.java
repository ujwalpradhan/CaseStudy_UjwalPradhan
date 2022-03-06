package bikefind.casestudy.Ujwal.Pradhan.controller;

import bikefind.casestudy.Ujwal.Pradhan.database.dao.UserDAO;
import bikefind.casestudy.Ujwal.Pradhan.database.dao.UserRoleDAO;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.Product;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
// this restricts the controller to admin only, this can be done at the class level or at the method level
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();


        List<User> user = userDAO.findAll();
        response.setViewName("admin/admin");
        response.addObject("users", user);

        log.debug("debug message");
        return response;
    }
}
