package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.models.Feedback;
import ru.itis.services.ProductService;
import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/feeds", method = RequestMethod.GET)
    public String getFeedback(ModelMap modelMap) {
        List<Feedback> feeds = productService.showFeedback();
        modelMap.addAttribute("feeds", feeds);
        return "index";
    }


//    @Override
//    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        List<Feedback> feeds = productService.showFeedback();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("jsp/index");
//        modelAndView.addObject("feeds", feeds);
//        return modelAndView;
//    }

}
