package sem2.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CheckNumber();
    }

    public static void CheckNumber() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Введите число для проверки: ");
            int num = sc.nextInt();
            if(num <=0){
                throw new InvalidNumberException("Некорректное число");
            }
            System.out.println("Число корректно");
        }catch (InvalidNumberException e){
            System.out.println("Message: " + e.getMessage());
        }

    }
}

class InvalidNumberException extends Exception{
    InvalidNumberException(String message){
        super(message);
    }
}

/*Задача 1:
        Напишите программу, которая запрашивает у пользователя число и проверяет, является ли оно положительным.
        Если число отрицательное или равно нулю, программа должна выбрасывать исключение InvalidNumberException
        с сообщением "Некорректное число". В противном случае, программа должна выводить сообщение "Число корректно".*/
