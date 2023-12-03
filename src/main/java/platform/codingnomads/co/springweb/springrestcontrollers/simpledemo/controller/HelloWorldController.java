package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Task;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/tasks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> taskList(){
        Task task1= Task.builder().completed(false).name("Programming").description("Learn To Program In Kotlin").build();
        Task task2= Task.builder().completed(false).name("Gaming").description("Play Fifa with friend").build();
        Task task3= Task.builder().completed(false).name("Cooking").description("Cook ribs").build();
        return List.of(task1,task2, task3);
    }

    @RequestMapping(path = "/tasks/single", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Task task(){
        return Task.builder().completed(false).name("Programming").description("Learn To Program In Kotlin").build();
    }
}




