package org.example.ignore.controller;

import org.example.ignore.service.IgnoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ignore")
public class IgnoreController {
    @Autowired
    private IgnoreService ignoreService;

    @GetMapping("/fibo")
    public Integer fibo(@RequestParam int n) {
        return ignoreService.fibo(n);
    }
}
