package com.tw.apistackbase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/employees")
public class HelloResource {
//    List<Employee> result=new ArrayList<>();
    private static Map<Integer,Employee> map=new HashMap();
    static {
        map.put(1,new Employee(1,"panda",22,"male"));
    }
    private final Logger log = Logger.getLogger(this.getClass().getName());

//    @GetMapping(path = "/{userName}", produces = {"application/json"})
//    public ResponseEntity<String> getAll(@PathVariable String userName) {
//
//        return ResponseEntity.ok("Hello:" + userName);
//    }

    @GetMapping()
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(map);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Employee employee) {
        map.put(employee.getId(),employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        map.remove(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Employee employee,@PathVariable Integer id) {
        map.put(id,employee);
        return ResponseEntity.ok().build();
    }
}
