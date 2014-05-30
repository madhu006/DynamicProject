package com.breakneck.controller;

/**
 *  @author Madhulika Prasad
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
public class HelloController{
 
   @RequestMapping(value = "/hello", method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");

      return "hello";
   }
   
   @RequestMapping(value = "/footer", method = RequestMethod.GET)
   public String printFooter(ModelMap model) {
      model.addAttribute("message", "Footer Spring MVC Framework!");

      return "footer";
   }
   
   /*
   @RequestMapping(value = "/template", method = RequestMethod.GET)
   public String printTemplate(ModelMap model) {
      model.addAttribute("message", "Body Template Spring MVC Framework!");

      return "template";
   }
*/
}