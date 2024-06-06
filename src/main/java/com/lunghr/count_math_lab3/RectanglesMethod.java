package com.lunghr.count_math_lab3;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RectanglesMethod extends Method {

    public void getAnswer(List<String> args) {
        setArgs(args);

        Double epsilon = 20.0;
        Double previousAnswer = 0.0;
        switch (args.get(1)) {
            case "1":
                while (this.function.getAccuracy() <= epsilon) {
                    countH();
                    Double summary = 0.0;
                    for (int i = 0; i < this.function.getIntervalCount(); i++) {
                        summary += calculateFunction(this.function.getLeftBorder() + h * i);
                    }

                    if (epsilon == 20) {
                        previousAnswer = h + h * summary;
                    }
                    epsilon = calculateEpsilon(previousAnswer, h * summary, 2);
                    previousAnswer = h * summary;
                    if (epsilon <= this.function.getAccuracy()) {
                        System.out.println("Ответ: " + h * summary);
                        System.out.println("Количество диапозонов разбиения:" + this.function.getIntervalCount());
                    } else {
                        this.function.setIntervalCount(this.function.getIntervalCount() * 2);
                    }
                }

            case "2":
                while (this.function.getAccuracy() <= epsilon) {
                    countH();
                    System.out.println(function.getIntervalCount() + ": " + h);
                    Double summary = 0.0;

                    for (int i = 0; i < this.function.getIntervalCount(); i++) {
                        summary += calculateFunction(this.function.getLeftBorder() + h * i + (h / 2));
                    }
                    if (epsilon == 20) {
                        previousAnswer = h + h * summary;
                    }
                    epsilon = calculateEpsilon(previousAnswer, h * summary, 2);
                    previousAnswer = h * summary;

                    if (epsilon <= this.function.getAccuracy()) {
                        System.out.println("Ответ: " + h * summary);
                        System.out.println("Количество диапозонов разбиения:" + this.function.getIntervalCount());
                        break;
                    } else {
                        this.function.setIntervalCount(this.function.getIntervalCount() * 2);
                    }
                }
            case "3":
                while (this.function.getAccuracy() <= epsilon) {
                    countH();

                    Double summary = 0.0;
                    for (int i = 1; i <= this.function.getIntervalCount(); i++) {
                        summary += calculateFunction(this.function.getLeftBorder() + h * i);
                    }
                    if (epsilon == 20) {
                        previousAnswer = h + h * summary;
                    }

                    epsilon = calculateEpsilon(previousAnswer, h * summary, 2);
                    previousAnswer = h * summary;
                    if (epsilon <= this.function.getAccuracy()) {
                        System.out.println("Ответ: " + h * summary + " " + this.function.getIntervalCount());
                        System.out.println("Количество диапозонов разбиения:" + this.function.getIntervalCount());
                    } else {
                        this.function.setIntervalCount(this.function.getIntervalCount() * 2);
                    }
                }

        }
    }
}
