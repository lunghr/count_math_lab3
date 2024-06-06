package com.lunghr.count_math_lab3;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class Function {
    private Integer A;
    private  Integer B;
    private  Integer C;
    private  Integer D;
    private Double accuracy;
    private Double leftBorder;
    private Double rightBorder;
    private Integer intervalCount;

    public Function (Double accuracy, Double leftBorder, Double rightBorder, Integer intervalCount){
        this.accuracy = accuracy;
        this.rightBorder = rightBorder;
        this.leftBorder = leftBorder;
        this.intervalCount = intervalCount;
    }

}
