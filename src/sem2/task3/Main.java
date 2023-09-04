package sem2.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CheckNumber();
    }

    public static void CheckNumber() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Введите первое число: ");
            double num1 = sc.nextDouble();
            System.out.print("Введите второе число: ");
            double num2 = sc.nextDouble();
            System.out.print("Введите третье число: ");
            double num3 = sc.nextDouble();

            if(num1 > 100){
                throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
            }
            if(num2 < 0){
                throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
            }
            if(num1 + num2 < 10){
                throw new NumberSumException("Сумма первого и второго чисел слишком мала");
            }
            if(num3 == 0){
                throw new DivisionByZeroException("Деление на ноль недопустимо");
            }

            System.out.println("Проверка пройдена успешно");
        }catch (NumberOutOfRangeException | NumberSumException | DivisionByZeroException e){
            System.out.println("Message: " + e.getMessage());
        }

    }
}

class NumberOutOfRangeException extends Exception{
    NumberOutOfRangeException(String message){
        super(message);
    }
}
class NumberSumException extends Exception{
    NumberSumException(String message){
        super(message);
    }
}
class DivisionByZeroException extends Exception{
    DivisionByZeroException(String message){
        super(message);
    }
}

/*Задача3: - по желанию
        Напишите программу, которая запрашивает у пользователя три числа и выполняет следующие проверки:

        Если первое число больше 100,
        выбросить исключение NumberOutOfRangeException с сообщением "Первое число вне допустимого диапазона".

        Если второе число меньше 0,
        выбросить исключение NumberOutOfRangeException с сообщением "Второе число вне допустимого диапазона".

        Если сумма первого и второго чисел меньше 10,
        выбросить исключение NumberSumException с сообщением "Сумма первого и второго чисел слишком мала".

        Если третье число равно 0,
        выбросить исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо".

        В противном случае, программа должна выводить сообщение "Проверка пройдена успешно".

        - необходимо создать 3 класса собственных исключений*/
