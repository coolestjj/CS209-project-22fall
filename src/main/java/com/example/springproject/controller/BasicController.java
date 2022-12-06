package com.example.springproject.controller;

import com.example.springproject.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    private BasicService basicService;

    @RequestMapping("/truncate")
    public String truncateTable(@RequestParam String tableName) {
        basicService.truncateTable(tableName);
        return "Table " + tableName + " truncated";
    }

}
