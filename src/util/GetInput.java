package util;

import java.util.*;

/**
 *
 * @author Windows 18
 */
public final class GetInput {
    public static Scanner sc = new Scanner(System.in);
    public static final int DEC = 10;
    public static final int HEX = 16;
    public static final int BIN = 2;

    public static int getInteger(String inputStr,String errStr,int low,int high){
        // doi cho khi low > high
        if(low>high){
            int temp;
            temp = low;
            low = high;
            high = temp;
        }
        int value;
        while(true){
            try{
                System.out.println(inputStr);
                value = Integer.parseInt(sc.nextLine());
                if(value<low || value > high)
                    throw new Exception();
                return value;
            }catch(Exception e){
                System.out.println(errStr);
            }
        }
    }
    public static int getPositiveInteger(String inputStr,String errStr){
        int value;
        while(true){
            try{
                System.out.println(inputStr);
                value = Integer.parseInt(sc.nextLine());
                return value;
            }catch(Exception e){
                System.out.println(errStr);
            }
        }
    }
    public static double getPositiveDouble(String inputStr,String
            errStr){
        double value;
        while(true){
            try{
                System.out.println(inputStr);
                value = Double.parseDouble(sc.nextLine());
                if(value<0)
                    throw  new Exception();
                return value;
            }catch(Exception e){
                System.out.println(errStr);
            }
        }
    }
    public static String getString(String inputStr,String errStr){
        String str;
        while(true){
            System.out.println(inputStr);
            str = sc.nextLine();
            if(str.trim().length()==0)
            {
                System.out.println(errStr);
                continue;
            }
            return str;
        }


    }
    public static String getSpecificString(String reg,String inputStr,String errStr){
        String str;
        while(true){
            System.out.println(inputStr);
            str = sc.nextLine();
            boolean check = str.matches(reg);
            if(str.trim().length()==0 || check == false)
            {
                System.out.println(errStr);
                continue;
            }
            return str;
        }
    }
    public static String getInputByBase(int base){

        String input = null;
        boolean check = true;
        do{
            System.out.println("Enter a number in " + base + " base");
            switch (base){
                case DEC :
                    input = sc.nextLine();
                    check = input.matches("[0-9]+");
                    break;
                case HEX :
                    input = sc.nextLine();
                    check = input.matches("[0-9A-Fa-f]+");
                    break;
                case BIN :
                    input = sc.nextLine();
                    check = input.matches("[01]+");
                    break;
            }
            if(!check)
                System.out.println("You enter wrong number. Please enter again!");
        }while(!check);

        return input;
    }
}