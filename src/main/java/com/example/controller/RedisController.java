package com.example.controller;

import com.example.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private MyService myService;

    @PostMapping("/save")
    public void save(@RequestParam String key, @RequestBody Object value) {
        myService.saveToRedis(key, value);
    }

    @GetMapping("/get")
    public Object get(@RequestParam String key) {
        return myService.getFromRedis(key);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String key) {
        myService.deleteFromRedis(key);
    }
}
