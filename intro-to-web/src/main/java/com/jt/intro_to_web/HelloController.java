package com.jt.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @RequestMapping("/home")
    public void sayHello(PrintWriter writer){
        System.out.println("Hello Web");
        writer.println("<h1>Hello Spring Web</h1> <p>Welcome Home</p>");
    }

    @RequestMapping("/")
    public void landingPage(PrintWriter printWriter){
        System.out.println("Landing Page1");
        printWriter.println("Our First Landing Page");
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact-page";
    }

    // @RequestMapping("submit-details")
    // public String submitDetails(HttpServletRequest request, Model model){
    //     System.out.println("Submit details handled");
    //     String name = request.getParameter("name");
    //     String phone = request.getParameter("phone");

    //     // System.out.println("Name is: "+ name);
    //     // System.out.println("Phone is: "+phone);

    //     model.addAttribute("name", name);
    //     model.addAttribute("phone", phone);

    //     return "details-page";
    // }

    // @RequestMapping(value = "submit-details", method = RequestMethod.POST)
    // public String submitDetails(@RequestParam(value = "name1", required = false, defaultValue = "Spring boot") String name12, @RequestParam String phone, Model model){
    //     model.addAttribute("name", name12);
    //     model.addAttribute("phone", phone);

    //     return "details-page";
    // }

    @RequestMapping(value = "submit-details", method = RequestMethod.POST)
    public String submitDetails(@ModelAttribute Person person, Model model){
        model.addAttribute("name", person.getname1());
        model.addAttribute("phone", person.getPhone());

        return "details-page";
    }
}
