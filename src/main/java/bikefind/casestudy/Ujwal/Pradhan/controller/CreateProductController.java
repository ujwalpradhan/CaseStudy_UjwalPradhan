package bikefind.casestudy.Ujwal.Pradhan.controller;

import bikefind.casestudy.Ujwal.Pradhan.database.dao.ProductDAO;
import bikefind.casestudy.Ujwal.Pradhan.database.entity.Product;
import bikefind.casestudy.Ujwal.Pradhan.form.CreateProductFormBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CreateProductController {

    @Autowired
    private ProductDAO productDAO;



    // make sure are import the slf4j object imports for this line of code
    public static final Logger LOG = LoggerFactory.getLogger(CreateProductController.class);


    // this method is responsible for populating the jsp page with the correct data so the page can render
    // if this method is called without the id parameter it will be a create and no database will be loaded
    // if it is called with an id it will be an edit and we need to load the user from the databse and
    // populate the form bean.
    @RequestMapping(value = "/createProduct", method = RequestMethod.GET)
//    public ModelAndView createProduct() throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("products/createProduct");
//
//        return response;
//    }


    public ModelAndView createProductEditPage(@RequestParam(required = false) Integer id ) {
        ModelAndView response = new ModelAndView();
        response.setViewName("products/createProduct");

        if ( id != null ) {
            // id has been passed to this form so it is an edit
            Product product = productDAO.findById(id);

            // populate the form bean with the data loaded from the database
            CreateProductFormBean form = new CreateProductFormBean();
            form.setCategory(product.getCategory());
            form.setImageUrl(product.getImageUrl());
            form.setProductName(product.getProductName());
            form.setPrice(product.getPrice());

            // since we loaded this from the database we know the id field
            form.setId(product.getId());

            response.addObject("formBeanKey", form);
        } else {
            // an id has not been passed so it is a create
            // there is no data from the database so give an empty form bean
            CreateProductFormBean form = new CreateProductFormBean();
            response.addObject("formBeanKey", form);
        }

        return response;
    }


    // this method describes what happens when a user submits the form to the back end
    // it handles both the create and update logic for saving the user input to the database
    @RequestMapping(value = "/createSubmit", method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView createSubmit(@Valid CreateProductFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();

        System.out.println(form);

        if (errors.hasErrors()) {
            for ( FieldError error : errors.getFieldErrors() ) {
                // add the error message to the errorMessages list in the form bean
                form.getErrorMessages().add(error.getDefaultMessage());
                LOG.debug("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }

            response.addObject("formBeanKey", form);
            response.setViewName("products/createProduct");

        } else {
            // there are no errors on the form submission so this is either a create or an update.

            // no matter what we need to create a new user object
            Product product;

            if ( form.getId() == null ) {
                // the id is not present in the form bean so we know this is a create
                product  = new Product();
            } else {
                // this is an update so we need to load the user from the database first
                product = productDAO.findById(form.getId());
            }

            product.setCategory(form.getCategory());
            product.setImageUrl(form.getImageUrl());
            product.setProductName(form.getProductName());
            product.setPrice(form.getPrice());

//            String encryptedPassword = passwordEncoder.encode(form.getPassword());
//            user.setPassword(encryptedPassword);

            // if you are saving a new user without an id.  The return value of save will
            // create a new autoincremented ID record and return the user object with the new id populated
             productDAO.save(product);

//            if ( form.getId() == null ) {
//                // this is a create because the incoming id variable on the form is null
//                // so ... lets create a user role record for this user also
//                UserRole ur = new UserRole();
//
//                ur.setUser(user);
//                ur.setUserRole("USER");
//
//                userRoleDao.save(ur);
            }

            // response.setViewName("redirect:/login");
            response.setViewName("products/createProduct");

        return response;
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam Integer id ) throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("redirect:/productList");

        Product delete = productDAO.findById(id);
        if ( delete != null ) {
            productDAO.delete(delete);
        }

        return response;
    }
}
