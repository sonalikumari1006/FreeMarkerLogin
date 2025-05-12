package com.baeldung.freemarker.controller;


import jakarta.servlet.http.HttpSession;
import java.util.*;

//import com.baeldung.freemarker.method.LastCharMethod;
// import freemarker.template.DefaultObjectWrapperBuilder;
// import freemarker.template.Version;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// ======= This added by me =========
// import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;




import com.baeldung.freemarker.model.Car;

@Controller
public class SpringController {

    private static List<Car> carList = new ArrayList<Car>();


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "redirect:/LoginPage";
    }

   // static {
     //   carList.add(new Car("Honda", "Civic"));
       // carList.add(new Car("Toyota", "Camry"));
       // carList.add(new Car("Nissan", "Altima"));
   // }

    @RequestMapping(value = "/LoginPage", method = RequestMethod.GET)
    public String init(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("carList", carList);
        return "index";
    }

    // @RequestMapping(value = "/add", method = RequestMethod.POST)
    // public String addCar(@ModelAttribute("car") Car car) {
    //     if (null != car && null != car.getMake() && null != car.getModel() && !car.getMake().isEmpty() && !car.getModel().isEmpty()) {
    //         carList.add(car);
    //     }
    //     return "redirect:/LoginPage";
    // }

   



    // Show the commons page and display last added car and login info
    @RequestMapping(value = "/LoginPage/UserInfo", method = RequestMethod.GET)
    public String showCommonsPage(HttpSession session, Model model) {
        // Retrieve login info from session
        Object username = session.getAttribute("make");
        Object password = session.getAttribute("model");

        // Add the login info to the model if available
        if (username != null && password != null) {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
        }
        
        System.out.println("Showing Car list:" + carList);
        // Retrieve the last added car (if available)
        if (!carList.isEmpty()) {
            Car lastCar = carList.get(carList.size() - 1);  // Get the last car added
            System.out.println("last Element In Carlist: " + lastCar);
            model.addAttribute("lastCar", lastCar);  // Add the last car to the model
        }

        return "commons";  // Return the commons view
    }



    // Save username and password to session and redirect to the commons page
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String showCommonsInfo(@ModelAttribute("car") Car car, HttpSession session) {
        String username = car.getMake(); // Assuming car make is the username
        String password = car.getModel(); // Assuming car model is the password
        
        if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            carList.add(car);
            // Save login info to session
            session.setAttribute("username", username);
            session.setAttribute("password", password);
        }

        return "redirect:/LoginPage/UserInfo";  // Redirect to GET method to display login info and last car
    }

    
}
