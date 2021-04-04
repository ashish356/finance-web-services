package com.org.ashish.financewebservices.helloWorld;


import com.org.ashish.financewebservices.helloWorld.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class HelloWorldController {


     @GetMapping(path="/hello-world")
     public String helloWorld()
     {
         return "Hello World";
     }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello  %S", name));
        //throw new RuntimeException("Something went wrong");
    }
}
