import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Калькулятор для задания каты!");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите операцию:");

        try{
            System.out.println(calc(in.nextLine()));
        }catch(NumberFormatException e) {
            System.out.println("Bad request");
        }catch (NullPointerException e){
            System.out.println("Bad request");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Bad request");
        }
    }

    public static String calc(String input) {
        boolean rim = false;
        int sum;

        String[] str = input.split(" ");
        String str1 = str[0];
        String str2 = str[1];
        String str3 = str[2];
        if(str.length>3){
            throw new NumberFormatException();
        }


       if(isNumeric(str1) != isNumeric(str3)) {
           throw new NumberFormatException();
        }
        if(!isNumeric(str1)) {
            rim = true;
        }

        str1 = format.rim(str1);
        str3 = format.rim(str3);

        int a = Integer.parseInt(String.valueOf(str1));
        int b = Integer.parseInt(String.valueOf(str3));

        if (a>10 || b>10){
            throw new NumberFormatException();
        }


        if(Objects.equals(str2, "+")){
            sum = a+b;
            if(rim){
                return(format.RomanNumber.toRoman(sum));
            }else {
                return(String.valueOf(sum));
            }

        }else if (Objects.equals(str2, "-")) {
            sum = a-b;
            if(rim){
                return(format.RomanNumber.toRoman(sum));
            }else {
                return(String.valueOf(sum));
            }

        }else if (Objects.equals(str2, "*")) {
            sum = a*b;
            if(rim){
                return(format.RomanNumber.toRoman(sum));
            }else {
                return(String.valueOf(sum));
            }

        }else if (Objects.equals(str2, "/")) {
            sum = a/b;
            if(rim){
                return(format.RomanNumber.toRoman(sum));
            }else {
                return(String.valueOf(sum));
            }

        } else{
            return null;
        }
    }

    public static boolean isNumeric(String str) {
        int intValue;

        try {
            intValue = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
}