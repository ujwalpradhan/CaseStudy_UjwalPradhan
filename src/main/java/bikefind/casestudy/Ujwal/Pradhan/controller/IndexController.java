package bikefind.casestudy.Ujwal.Pradhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("homepage/home");

        return response;
    }
}
