import java.util.Scanner;
public class PrintString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first input as a string: ");
        String str1 = scanner.nextLine();

        System.out.println("Enter Second input as a string: ");
        String str2 = scanner.nextLine();

        System.out.println(printStringOutput(str1, str2));
    }

    private static String printStringOutput(String str1, String str2){

        String strTemp1 = str1;

        int strLen1 = str1.length();
        int strLen2 = str2.length();

        for(int i=0; i<strLen1; i++){

            for(int j=0; j<strLen2; j++){

                if(str1.charAt(i) == (str2.charAt(j))){
                    str1 = str1.replace(str1.charAt(i), '\u0000');
                }
            }
        }

        for(int i=0; i<strLen2; i++){

            for(int j=0; j<strLen1; j++){

                if(str2.charAt(i) == (strTemp1.charAt(j))){
                    str2 = str2.replace(str2.charAt(i), '\u0000');
                }
            }
        }

        return "Output1: " + str1 + "\nOutput2: " + str2;
    }
}