package com.appress.ravi.userRegistrationSystem.client;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculator {
    public long addOperation(int x, int y) {
        return x + y;
    }
}
