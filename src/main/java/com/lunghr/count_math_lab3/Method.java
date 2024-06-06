package com.lunghr.count_math_lab3;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class Method {

    public Function function;
    public Double h;




    public void setArgs(List<String> args) {
        switch (args.get(0)) {
            case "1":
                this.function = new Function(2, -2, 7, -14, Double.parseDouble(args.get(4)), Double.parseDouble(args.get(2)), Double.parseDouble(args.get(3)), Integer.parseInt(args.get(5)));
                break;
            case "2":
                this.function = new Function(1, 2, -3, -12, Double.parseDouble(args.get(4)), Double.parseDouble(args.get(2)), Double.parseDouble(args.get(3)), Integer.parseInt(args.get(5)));
                break;
            case "3":
                this.function = new Function(4, -5, 6, -7, Double.parseDouble(args.get(4)), Double.parseDouble(args.get(2)), Double.parseDouble(args.get(3)), Integer.parseInt(args.get(5)));
                break;
            case "4":
                this.function = new Function(2, -9, -7, 11, Double.parseDouble(args.get(4)), Double.parseDouble(args.get(2)), Double.parseDouble(args.get(3)), Integer.parseInt(args.get(5)));
                break;
            case "5":
                this.function = new Function(1, -2, -5, 24, Double.parseDouble(args.get(4)), Double.parseDouble(args.get(2)), Double.parseDouble(args.get(3)), Integer.parseInt(args.get(5)));
                break;
            default:
                System.out.println("Такую функцию выбрать невозможно");
        }
    }

    public void countH() {
        this.h = (this.function.getRightBorder() - this.function.getLeftBorder()) / this.function.getIntervalCount();
    }

    public Double calculateFunction(Double x) {
        return function.getA() * Math.pow(x, 3) + function.getB() * Math.pow(x, 2) + function.getC() * x + function.getD();
    }

    public Double calculateEpsilon(Double I1, Double I2, Integer k) {
        return (Math.abs((I1 - I2) / (Math.pow(2, k) - 1)));
    }
}
