package org.example.listen.service;

import org.springframework.stereotype.Service;

@Service
public class ListenService {
    public int fibo(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fibo(n-1)+fibo(n-2);
    }
}
