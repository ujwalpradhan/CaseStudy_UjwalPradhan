package bikefind.casestudy.Ujwal.Pradhan.controller;

import bikefind.casestudy.Ujwal.Pradhan.database.dao.OrderDAO;
import bikefind.casestudy.Ujwal.Pradhan.database.dao.OrderProductsDAO;
import bikefind.casestudy.Ujwal.Pradhan.database.dao.ProductDAO;
import bikefind.casestudy.Ujwal.Pradhan.database.dao.UserDAO;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.Order;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.OrderProducts;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.Product;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderProductsController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OrderProductsDAO orderProductsDAO;

    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(value = "/mycart", method = RequestMethod.GET)
    public ModelAndView products() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("orderProducts/orderProducts");

        return response;
    }

    @RequestMapping(value = "/cart/buy/{productId}", method = RequestMethod.GET)
    public ModelAndView buy(@PathVariable("productId") Integer productId) throws Exception {
        ModelAndView response = new ModelAndView();

        Product product = productDAO.findById(productId);


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
//        Product product = productDAO.findById(productId);

        User user = userDAO.findByEmail(currentPrincipalName);

        Order order = orderDAO.findByUserAndStatus(user, "cart");

        if(order==null) {
            order =  new Order();
            order.setStatus("cart");

            order.setUser(user);
            order = orderDAO.save(order);
            Integer orderId = order.getId();
        }

        OrderProducts orderProducts = new OrderProducts();
        orderProducts.setProduct(product);
        orderProducts.setOrder(order);
        orderProducts  =orderProductsDAO.save(orderProducts);

        List<OrderProducts> orderProductsList = orderProductsDAO.findByOrder(order);
        response.addObject("listProducts",orderProductsList);

        response.setViewName("/orderProducts/orderProducts");

        return response;

    }
}

