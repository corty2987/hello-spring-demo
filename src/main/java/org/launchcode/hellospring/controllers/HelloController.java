package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping(value="hello")
public class HelloController {

    // handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring";
//        }
    @GetMapping("goodbye") //lives /hello/goodbye
    public String goodbye() {
        return "Goodbye, Spring";
    }
//
//    //create handler that handles request of the form /hello?name=LaunchCode
//
//    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//
//        return "Hello, " + name + "!";
//    }
//
//    //handles requests of the form /hello/LaunchCode
//
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action ='/hello' method ='post'>" +
                "<input type = 'text' name = 'name' >" +
                "<select name='language' id='language-select'>" +
                "<option value=''>--Choose a language--</option>" +
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='piglatin'>Piglatin</option>" +
                "</select>" + // submit a request to /hello
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

        // /hello/form
        @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
        @ResponseBody
        public String helloPost (@RequestParam String name, @RequestParam String language){
            if (name == null) {
                name = "World";
            }
            return createMessage(name, language);
        }
        public static String createMessage (String n, String l) {
            String greeting = "";
                if (n == "" && l.equals("english")) {
                    greeting = "Hello World";
                } else if (l.equals("english")) {
                    greeting = "Hello";
                } else if (l.equals("french")) {
                    greeting = "Bonjour";
                } else if (l.equals("spanish")) {
                    greeting = "Hola";
                } else if (l.equals("italian")) {
                    greeting = "Bonjourno";
                } else if (l.equals("piglatin")) {
                    greeting = "ellohay";
                }
                    return greeting + " " + n;
                }
            }
