package com.lunghr.count_math_lab3;

import java.util.List;

public class SimpsonMethod extends Method {
    public void getAnswer(List<String> args) {
        System.out.println("lala4");
        setArgs(args);

        Double epsilon = 20.0;
        Double previousAnswer = 0.0;
        while (this.function.getAccuracy() <= epsilon) {

            countH();
            Double summary = calculateFunction(this.function.getRightBorder()) + calculateFunction(this.function.getLeftBorder());
            for (int i = 1; i < this.function.getIntervalCount(); i++) {
                if (i % 2 == 0) {
                    summary += 2 * calculateFunction(this.function.getLeftBorder() + h * i);
                } else {
                    summary += 4 * calculateFunction(this.function.getLeftBorder() + h * i);
                }
            }

            if (epsilon == 20) {
                previousAnswer = h+  h / 3 * summary;
            }
            epsilon = calculateEpsilon(previousAnswer, h / 3 * summary, 4);
            previousAnswer = h/3 * summary;
            if (epsilon <= this.function.getAccuracy()) {
                System.out.println("Ответ: " + h / 3 * summary);
                System.out.println("Количество диапозонов разбиения:" + this.function.getIntervalCount());
            } else {
                this.function.setIntervalCount(this.function.getIntervalCount() * 2);
            }
        }
    }
}
