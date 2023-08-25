package org.example.ignore.service;

import org.springframework.stereotype.Service;

@Service
public class IgnoreService {
    public int fibo(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fibo(n-1)+fibo(n-2);
    }
}
