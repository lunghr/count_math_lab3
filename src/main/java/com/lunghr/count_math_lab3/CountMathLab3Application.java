package com.lunghr.count_math_lab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountMathLab3Application {

    public static void main(String[] args) {
        Console console = new Console();
        AppManager app = new AppManager(console);
        app.run();
    }

}
