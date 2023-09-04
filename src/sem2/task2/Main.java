package sem2.task2;

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
            if(num2 == 0){
                throw new DivisionByZeroException("Деление на ноль недопустимо");
            }
            System.out.printf("%s: %,.2f", "Result", num1/num2);
        }catch (DivisionByZeroException e){
            System.out.println("Message: " + e.getMessage());
        }

    }
}

class DivisionByZeroException extends Exception{
    DivisionByZeroException(String message){
        super(message);
    }
}

/*Задача 2:
        Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление.
        Если второе число равно нулю, программа должна выбрасывать исключение DivisionByZeroException
        с сообщением "Деление на ноль недопустимо". В противном случае, программа должна выводить результат деления.*/
