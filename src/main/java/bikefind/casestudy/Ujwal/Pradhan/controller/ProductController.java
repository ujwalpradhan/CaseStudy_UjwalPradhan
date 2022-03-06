package bikefind.casestudy.Ujwal.Pradhan.controller;

import bikefind.casestudy.Ujwal.Pradhan.database.dao.ProductDAO;
import bikefind.casestudy.Ujwal.Pradhan.database.dao.UserDAO;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.Product;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductDAO productDao;

    @Autowired
    private UserDAO userDAO;


    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public ModelAndView products() throws Exception {
        ModelAndView response = new ModelAndView();

        List<Product> products = productDao.findAll();
        response.setViewName("products/products");
        response.addObject("products", products);

        return response;
    }

    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public ModelAndView userList(@RequestParam(required = false) String search) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("products/productList");

        if ( ! StringUtils.isEmpty(search)) {
            List<Product> products = productDao.findByProductNameContainingIgnoreCase(search);
            response.addObject("productListKey", products);
            response.addObject("searchInput", search);
        }
        return response;
    }

//    // this request mapping is going to be used to display the product.jsp
//    // localhost:8080/order/add-to-cart?productId=4
//    @RequestMapping(value = "/order/add-to-cart", method = RequestMethod.GET)
//    public ModelAndView product(Integer productId) throws Exception {
//        ModelAndView response = new ModelAndView();
////        response.setViewName("inventory/products");
//
//        // lookup the logged in user
//        // look to see if there is an existing order in the database with status pending
//        // if there is not an existing order then
//        // make a new order entity
//        // populate the order entity with whatever data you want to capture
//        // such order date
//        // make an order status column and set it equal to pending
//        // save your order entity
//        // look to see if the product is already part of the order and if so increment the quantity otherwise
//        // create an order_product entity to connect the product to the order
//
//        return response;
//    }

//    public User getLoggedInUser() {
//        // this is boiler plate code to get the authentication information from spring security
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        // gets the username that the user logged in with
//        String currentPrincipalName = authentication.getName();
//        // query the database to get the user object based on the logged in username
//        // in the case that you have used the email address to get the username
//        return userDao.findByEmail(currentPrincipalName);
//        // or you would use this line to get the user by username if you used username to login
//        // return userDao.findByUsername(currentPrincipalName);
//    }
}
