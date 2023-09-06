package sem3.task1;

public class Main {
    public static void main(String[] args) throws Exception {
        PasswordVerifier passwordVerifier = new PasswordVerifier();
        passwordVerifier.verify("axcsчсамрпчп1Й");
    }
}

class PasswordVerifier{
    public void verify(String password) throws Exception {
        if(password.length()<8){
            throw new Exception("Пароль должен быть не менее 8 символов");
        }else if(!hasDigits(password)){
            throw new Exception("Пароль должен содержать хотя бы одну цифру");
        }else if(!hasUpperCase(password)){
            throw new Exception("Пароль должен содержать хотя бы одну заглавную букву");
        }

        System.out.println("Проверка пароля прошла успешно!");
    }

    private boolean hasDigits(String string){
        boolean digits = false;
        for(int i = 0; i < string.length() && !digits; i++) {
            if(Character.isDigit(string.charAt(i))) {
                digits = true;
            }
        }
        return digits;
    }

    private boolean hasUpperCase(String string){
        boolean hasUpper = false;
        char[] array=string.toCharArray();
        for(char x:array) {
            if (Character.isUpperCase(x)) {
                hasUpper = true;
                break;
            }
        }
        return hasUpper;
    }
}

/*Создайте класс PasswordVerifier. Этот класс должен содержать метод,
                                   который принимает строку пароля и проверяет его на соответствие следующим правилам:

   Пароль должен быть не менее 8 символов.
   Пароль должен содержать хотя бы одну цифру.
   Пароль должен содержать хотя бы одну заглавную букву.
   Метод должен выбрасывать исключение, если пароль не соответствует какому-либо из этих правил.*/
