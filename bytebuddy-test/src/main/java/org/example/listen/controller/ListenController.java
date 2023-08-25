package org.example.listen.controller;

import org.example.listen.service.ListenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listen")
public class ListenController {
    @Autowired
    private ListenService listenService;

    @GetMapping("/fibo")
    public Integer fibo(@RequestParam int n) {
        return listenService.fibo(n);
    }

    @GetMapping("/jiayou")
    public String jiayou() {
        return "ch jiayou";
    }
}
