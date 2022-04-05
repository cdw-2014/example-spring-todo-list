package me.cweaver.example.todolist.todolist.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ping")
public class PingController {

    @GetMapping()
    public String ping(@RequestParam Optional<String> name) {
        String outputName = "";
        if (name.isEmpty()) {
            outputName = "anon";
        } else {
            outputName = name.get();
        }
        return "Hello " + outputName;
    }

    @GetMapping("/many/{name1}")
    public String pingMany(@PathVariable String name1, @RequestParam Optional<String> name2) {
        String outputName = "";
        if (name2.isEmpty()) {
            outputName = "anon";
        } else {
            outputName = name2.get();
        }
        return "Hello " + name1 + " and " + outputName;
    }

}
