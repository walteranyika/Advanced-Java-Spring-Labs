package platform.codingnomads.co.springweb.gettingdatafromclient.requestparam.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springweb.gettingdatafromclient.requestparam.models.Task;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTask(@RequestParam Long id) {
        return "ID: " + id;
    }

    @GetMapping(value = "/param-name-variable-name-different", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTaskWithDifferentParamAndVariableName(@RequestParam(name = "id") Long taskId) {
        return "ID: " + taskId;
    }

    @GetMapping(value = "/request-param-optional", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTaskWithOptionalRequestPram(@RequestParam(name = "id", required = false) Long taskId) {
        if (taskId != null) {
            return Task.builder().id(taskId).name("Task One").build();
        } else
            return Task.builder().name("Task One").build();
    }

    @GetMapping(value = "/default-request-param-value", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTaskWithDefaultRequestParam(@RequestParam(name = "name", required = false, defaultValue = "Task One") String taskName) {
        return Task.builder().name(taskName).build();
    }

    @GetMapping(value = "/request-parameter-with-multiple-values", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getTasksWithNamesRequestParam(@RequestParam(name = "names") List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(i -> Task.builder().id((long) i).name(names.get(i)).build())
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam(name = "keyword", defaultValue = "", required = false) String keyword) {
        return tasks().stream().filter(t -> t.getName().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    @GetMapping("/status")
    public  List<Task> tasksByStatus(@RequestParam boolean completed){
        return  tasks().stream().filter(t->t.getCompleted()==completed).collect(Collectors.toList());
    }
    private List<Task> tasks() {
        var task1 = Task.builder().id(1L).name("Read Magazine").completed(true).build();
        var task2 = Task.builder().id(2L).name("Exercise").completed(false).build();
        var task3 = Task.builder().id(3L).name("Cook Lunch").completed(false).build();
        var task4 = Task.builder().id(4L).name("Run Marathon").completed(true).build();
        var task5 = Task.builder().id(5L).name("Watch Football").completed(false).build();
        return List.of(task1, task2, task3, task4, task5);
    }
}
