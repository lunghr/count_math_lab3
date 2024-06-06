package com.lunghr.count_math_lab3;

import java.util.List;

public class TrapezoidMethod extends Method {
    public void getAnswer(List<String> args) {
        setArgs(args);

        Double epsilon = 20.0;
        Double previousAnswer = 0.0;
        while (this.function.getAccuracy() <= epsilon) {
            countH();
            Double summary = 0.0;
            for (int i = 1; i < this.function.getIntervalCount(); i++) {
                summary += calculateFunction(this.function.getLeftBorder() + h * i);
            }
            summary += (calculateFunction((this.function.getLeftBorder())) + calculateFunction(this.function.getRightBorder())) / 2;
            if (epsilon == 20) {
                previousAnswer = h+ h * summary;
            }
            epsilon = calculateEpsilon(previousAnswer, h * summary, 2);
            previousAnswer =  h * summary;
            if (epsilon <= this.function.getAccuracy()) {
                System.out.println("Ответ: " + h * summary);
                System.out.println("Количество диапозонов разбиения:" + this.function.getIntervalCount());
            } else {
                this.function.setIntervalCount(this.function.getIntervalCount() * 2);
            }
        }
    }
}
g