package com.lunghr.count_math_lab3;

import java.util.List;

public class AppManager {

    private Console console;
    private final RectanglesMethod rectanglesMethod = new RectanglesMethod();
    private final TrapezoidMethod trapezoidMethod = new TrapezoidMethod();
    private final SimpsonMethod simpsonMethod = new SimpsonMethod();

    public AppManager(Console console) {
        this.console = console;
    }

    public void run() {
        while (console.isNextStr()) {
            List<String> input = console.getArgs();
            String method = input.get(1);
            switch (Integer.parseInt(method)) {
                case 1:
                    rectanglesMethod.getAnswer(input);
                    break;
                case 2:
                    rectanglesMethod.getAnswer(input);
                    break;
                case 3:
                    rectanglesMethod.getAnswer(input);
                    break;
                case 4:
                    trapezoidMethod.getAnswer(input);
                    break;
                case 5:
                    simpsonMethod.getAnswer(input);
                    break;
            }

        }

    }
}

