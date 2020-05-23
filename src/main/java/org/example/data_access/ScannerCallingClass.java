package org.example.data_access;
import java.util.Scanner;

public class ScannerCallingClass {

    public static float  scannerInteger(float n1)
    {
        boolean invalidentry = true;
        float no = 0;
        Scanner sc = new Scanner(System.in);
        while(invalidentry){
            try{
                String enterstring = sc.nextLine();
                no = Float.valueOf(enterstring);

                invalidentry = false;
                if (no<0)
                {
                    System.out.println("The entered number is a negative integer. Please enter positive number");
                    invalidentry=true;
                }
            }catch (NumberFormatException ex){
                System.out.println(ex + "The value you have just entered is not valid. Please enter some valid number");
            }
        }
        return no;
    }
    public static char scannerCharacter(char c1)
    {
        Scanner sc = new Scanner(System.in);

        boolean validvalue=true;
        while(validvalue)
        {
            char c2 = sc.next().charAt(0);

            if (c2 == 'y' || c2 == 'N' || c2 == 'N' || c2 == 'n' || c2 == '*' || c2 == '/' || c2 == '-' || c2 == '+')
            {
                validvalue=false;
                return c2;
            }
            else
            {
                if (c2=='Y')
                    System.out.println("You have entered Y. Please enter small caps value of y");
                else if (c2 != '*' || c2 != '/' || c2 != '-' || c2 != '+')
                    System.out.println("Enter the arithmetic operator         +        *           /       -");
                else if (c2 != 'y' || c2 != 'N' || c2 != 'N' || c2 != 'n')
                    System.out.println("The value you entered is not valid. Please enter (y/n");
                else
                    System.out.println("Try again please");
            }
        }
        return 0;
    }
}



