package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

   //create handler that handles request of the form /hello?name=LaunchCode

    @RequestMapping(value= "hello", method= {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    //handles requests of the form /hello/LaunchCode

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
     return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");

        model.addAttribute("names", names);
        return "hello-list";
    }

        // /hello/form
//        @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
//        @ResponseBody
//        public String helloPost (@RequestParam String name, @RequestParam String language){
//            if (name == null) {
//                name = "World";
//            }
//            return createMessage(name, language);
//        }
//        public static String createMessage (String name, String language) {
//            String greeting = "";
//                if (name == "" && language.equals("english")) {
//                    greeting = "Hello World";
//                } else if (language.equals("english")) {
//                    greeting = "Hello";
//                } else if (language.equals("french")) {
//                    greeting = "Bonjour";
//                } else if (language.equals("spanish")) {
//                    greeting = "Hola";
//                } else if (language.equals("italian")) {
//                    greeting = "Bonjourno";
//                } else if (language.equals("piglatin")) {
//                    greeting = "ellohay";
//                }
//                    return greeting + ", " + name;
//                }
            }
