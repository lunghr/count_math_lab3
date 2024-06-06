package com.lunghr.count_math_lab3;

import java.util.*;

public class Console {

    public static List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
    public static final String SEPARATOR = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" +
            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    private Scanner scanner = new Scanner(System.in);

    public boolean isNextStr() {
        return true;
    }

    public String getNextStr() {
        try {
            return scanner.nextLine().strip();
        } catch (NoSuchElementException e) {
            System.out.println("You interrupted the input stream");
            System.exit(0);
        }
        return null;
    }

    public void writeStr(String text) {
        System.out.println(text);
    }

    //заглушка*

    public String getText() {
        return "";
    }

    public void printFunctions() {
        writeStr(SEPARATOR);
        writeStr("Выберите функцию:");
        writeStr("");
        writeStr("1. f(x) = 2x^3 - 2x^2 +7x - 14");
        writeStr("2. f(x) = x^3 + 2x^2 - 3x - 12");
        writeStr("3. f(x) = 4x^3 - 5x^2 + 6x - 7");
        writeStr("4. f(x) = 2x^3 - 9x^2 - 7x + 11");
        writeStr("5. f(x) = x^3 - 2x^2 - 5x + 24");
        writeStr(SEPARATOR);
    }

    public boolean isValidInterval(String[] diaposon) {
        try {
            if (diaposon.length != 2){
                writeStr("Диапозон был введен неккоректно, попробуйте ещё");
                return false;
            }
            double a = Double.parseDouble(diaposon[0]);
            double b = Double.parseDouble(diaposon[1]);
            if ((a < b)) {
                return true;
            } else {
                writeStr("Диапозон был введен неккоректно, попробуйте ещё");
                return false;
            }
        } catch (NumberFormatException e) {
            writeStr("Диапозон был введен неккоректно, попробуйте ещё");
            return false;
        }
    }
    public boolean isValidAccuracy(String accuracy) {
        try {
            double a = Double.parseDouble(accuracy);
            if ((a < 1) && a> 0) {
                return true;
            } else {
                writeStr("Точность была введена неккоректно, попробуйте ещё");
                return false;
            }
        } catch (NumberFormatException e) {
            writeStr("Точность была введена неккоректно, попробуйте ещё");
            return false;
        }
    }

    public boolean isValidN(String n) {
        try {
            double N =Integer.parseInt(n);
            if (N > 0) {
                return true;
            } else {
                writeStr("Число интервалов было введено неккоректно, попробуйте ещё");
                return false;
            }
        } catch (NumberFormatException e) {
            writeStr("Число интервалов было введено неккоректно, попробуйте ещё");
            return false;
        }
    }

    public void printMethods() {
        writeStr(SEPARATOR);
        writeStr("Выберите метод решения интеграла:");
        writeStr("");
        writeStr("1.  Метод прямгоульников (Левые)");
        writeStr("2.  Метод прямгоульников (Средние)");
        writeStr("3.  Метод прямгоульников (Правые)");
        writeStr("4.  Метод трапеций");
        writeStr("5.  Метод Симпсона");
        writeStr(SEPARATOR);
    }

    public List<String> getArgs() {
        List<String> data = new ArrayList<>();
        String tmp;
        while (true) {
            printFunctions();
            tmp = getNextStr();
            if (isValid(tmp)) {
                data.add(tmp);
                break;
            }
        }
        while (true) {
            printMethods();
            tmp = getNextStr();
            if (isValid(tmp)) {
                data.add(tmp);
                break;
            }
        }

        while (true) {
            writeStr(SEPARATOR);
            writeStr("Введите диапозон интегрирования (через пробел)");
            tmp = getNextStr();
            String[] diaposon = tmp.split(" ");
            if (isValidInterval(diaposon)) {
                data.add(diaposon[0]);
                data.add(diaposon[1]);
                break;
            }
        }

        while (true) {
            writeStr(SEPARATOR);
            writeStr("Введите точность вычислений: ");
            tmp = getNextStr();
            if (isValidAccuracy(tmp)){
                data.add(tmp);
                break;
            }
        }

        while (true) {
            writeStr(SEPARATOR);
            writeStr("Введите количество интервалов разбиения: ");
            tmp = getNextStr();
            if (isValidN(tmp)){
                data.add(tmp);
                break;
            }
        }

        return data;
    }


    private boolean isValid(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return (list.contains(num));
    }
}
