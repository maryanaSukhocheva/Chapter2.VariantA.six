/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package varianta.six.action;

import java.util.Scanner;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Action {
    
    String pattern = "(\\s)+|($)";

    /**
     *
     * @return
     */
    public String[] Numbers() {
        boolean result;
        float number;
        String[] masNum = null;
        try (Scanner scan = new Scanner(System.in)) {
            result = false;
            String str = scan.nextLine();
            for (String retval : str.split(pattern)) {
                try {
                    if (!retval.isEmpty()) {
                        number = Float.valueOf(retval);
                        result = true;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Неверный формат чисел!");
                    result = false;
                    break;
                }
            }
            scan.close();
            if (result) {
                masNum = str.split(pattern);
            }
        }
        return masNum;
    }
    
    /**
     *
     * @param masDec
     */
    public void DecNumbers(String[] mas) {
        int currentNum;
        boolean result=false;
        String outNumber="";
        for (String str:mas) {
            /*Предполагаем, что первый элемент (в каждом
             подмножестве элементов) является минимальным */
            char[] simbol=str.toCharArray();
            currentNum=Character.getNumericValue(simbol[0]);
            for (int i=1;i<simbol.length;i++)
                if (currentNum<=simbol[i]) {
                    result=true;
                    currentNum=simbol[i];
                }  else {
                    result=false;
                    break;
                }
            if(result) {
                outNumber=str;
                break;
            }
            }
        if (!outNumber.isEmpty()) {   
            System.out.println("Число, цифры в котором идут в строгом порядке возрастания - " + outNumber);
        } else {
            System.out.println("Среди представленных чисел нет числа, цифры в котором идут в строгом порядке возрастания");
        }
    }


}
