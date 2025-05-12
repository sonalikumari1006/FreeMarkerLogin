package com.baeldung.freemarker.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baeldung.freemarker.model.Car;

import jakarta.servlet.http.HttpSession;


// =================== This controller code for enter username and password in input field and when click on submit button on post it will redirect to /UserInfo ==========

// @Controller
// public class SpringController {

//     private static List<Car> carList = new ArrayList<Car>();
    

//     @RequestMapping(value = "/", method = RequestMethod.GET)
//     public String home(Locale locale, Model model) {
//         return "redirect:/LoginPage";
//     }

   // static {
     //   carList.add(new Car("Honda", "Civic"));
       // carList.add(new Car("Toyota", "Camry"));
       // carList.add(new Car("Nissan", "Altima"));
   // }

//     // @RequestMapping(value = "/LoginPage", method = RequestMethod.GET)
//     // public String init(@ModelAttribute("model") ModelMap model) {
//     //     model.addAttribute("carList", carList);
//     //     return "index";
//     // }
// // ===============================================================================================
//     // @ModelAttribute("model") ModelMap model: 
//         // "ModelMap model data bhejne ke liye hota hai controller se view tak.
//         // @ModelAttribute("model") us model object ko 'model' naam se identify karta hai — lekin yahaan yeh optional hai, hata bhi sakte ho."

//     @RequestMapping(value = "/LoginPage", method = RequestMethod.GET)
//     public String init(ModelMap model) {
//         model.addAttribute("carList", carList);
//         return "index";
//     }
// // =================================================================================================



//     // @RequestMapping(value = "/add", method = RequestMethod.POST)
//     // public String addCar(@ModelAttribute("car") Car car) {
//     //     if (null != car && null != car.getMake() && null != car.getModel() && !car.getMake().isEmpty() && !car.getModel().isEmpty()) {
//     //         carList.add(car);
//     //     }
//     //     return "redirect:/LoginPage";
//     // }

   


    
//     // Show the UserInfo page and display last added car and login info
//     @RequestMapping(value = "/LoginPage/UserInfo", method = RequestMethod.GET)
//     public String showCommonsPage(Model model) {
//         // Retrieve login info from session
//         Object username = model.getAttribute("make");
//         Object password = model.getAttribute("model");

//         // Add the login info to the model if available
//         if (username != null && password != null) {
//             model.addAttribute("username", username);
//             model.addAttribute("password", password);
//         }
        
//         System.out.println("Showing Car list:" + carList);
//         // Retrieve the last added car (if available)
//         if (!carList.isEmpty()) {
//             Car lastCar = carList.get(carList.size() - 1);  // Get the last car added
//             System.out.println("last Element In Carlist: " + lastCar);
//             model.addAttribute("lastCar", lastCar);  // Add the last car to the model
//         }

//         return "commons";  // Return the commons view
//     }


//     // HttpSession session

//     //Save username and password to session and redirect to the commons page
//     @RequestMapping(value = "/add", method = RequestMethod.POST)
//     public String showCommonsInfo(@ModelAttribute("car") Car car) {
//         String username = car.getMake(); // Assuming car make is the username
//         String password = car.getModel(); // Assuming car model is the password
        
//         if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
//             carList.add(car);            
//         }

//         return "redirect:/LoginPage/UserInfo";  // Redirect to GET method to display login info and last car
//     }
   
// }


// ============================== This controller code for varification of username and password =======================


@Controller
public class SpringController {

    private static List<Car> carList = new ArrayList<Car>();
    


    static {
       carList.add(new Car("user1", "user1"));
       carList.add(new Car("user2", "user2"));
       carList.add(new Car("user3", "user3"));
   }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "redirect:/LoginPage";
    }

    


    // @RequestMapping(value = "/LoginPage", method = RequestMethod.GET)
    // public String init(@ModelAttribute("model") ModelMap model) {
    //     model.addAttribute("carList", carList);
    //     return "index";
    // }
// ===============================================================================================
    // @ModelAttribute("model") ModelMap model: 
        // "ModelMap model data bhejne ke liye hota hai controller se view tak.
        // @ModelAttribute("model") us model object ko 'model' naam se identify karta hai — lekin yahaan yeh optional hai, hata bhi sakte ho."

    @RequestMapping(value = "/LoginPage", method = RequestMethod.GET)
    public String init(ModelMap model) {
        model.addAttribute("carList", carList);
        return "index";
    }
// =================================================================================================



    // @RequestMapping(value = "/add", method = RequestMethod.POST)
    // public String addCar(@ModelAttribute("car") Car car) {
    //     if (null != car && null != car.getMake() && null != car.getModel() && !car.getMake().isEmpty() && !car.getModel().isEmpty()) {
    //         carList.add(car);
    //     }
    //     return "redirect:/LoginPage";
    // }




    
    // Show the UserInfo page and display last added car and login info
    @RequestMapping(value = "/LoginPage/UserInfo", method = RequestMethod.GET)
    public String showCommonsPage(Model model) {
        // // Retrieve login info 
        // Object username = model.getAttribute("make");
        // Object password = model.getAttribute("model");

        // // Add the login info to the model if available
        // if (username != null && password != null) {
        //     model.addAttribute("make", username);
        //     model.addAttribute("model", password);
        // }
        
        // // System.out.println("Showing Car list:" + carList);
        // // // Retrieve the last added car (if available)
        // // if (!carList.isEmpty()) {
        // //     Car lastCar = carList.get(carList.size() - 1);  // Get the last car added
        // //     System.out.println("last Element In Carlist: " + lastCar);
        // //     model.addAttribute("lastCar", lastCar);  // Add the last car to the model
        // // }

        // Retrieve the last added user (username & password)
        if (!carList.isEmpty()) {
            Car lastCar = carList.get(carList.size() - 1);  // Get the last car added
            model.addAttribute("lastCar", lastCar);  // Add the last car to the model
        }

        return "commons";  // Return the commons view

        
    }


    // HttpSession session

    //Save username and password to session and redirect to the commons page
    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String showCommonsInfo(@ModelAttribute("car") Car car,HttpSession session, Model model) {
    //     String username = car.getMake(); // Assuming car make is the username
    //     String password = car.getModel(); // Assuming car model is the password
        
    //      boolean isValidUser = carList.stream()
    //     .anyMatch(c -> c.getMake().equals(username) && c.getModel().equals(password));

    //     if (isValidUser) {
    //         // session.setAttribute("make", username);
    //         // session.setAttribute("model", password);

    //         return "redirect:/LoginPage/UserInfo";
    //     } else {
    //         model.addAttribute("errorMessage", "Invalid User Information");
    //         return "index"; // Redirect back to login page with error
    //     }
    // }

        String username = car.getMake(); // Assuming car make is the username
        String password = car.getModel(); // Assuming car model is the password

        // Check if user is valid and add to the list if valid
        boolean isValidUser = carList.stream()
                .anyMatch(c -> c.getMake().equals(username) && c.getModel().equals(password));

        if (isValidUser) {
            // Add the new user to the carList
            carList.add(new Car(username, password));

            // Redirect to UserInfo page with the last added user info
            return "redirect:/LoginPage/UserInfo";
        } else {
            model.addAttribute("errorMessage", "Invalid User Information");
            return "index"; // Redirect back to login page with error
        }

    }
}

