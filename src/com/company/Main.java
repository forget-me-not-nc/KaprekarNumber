package com.company;

import java.util.Map;
import java.util.Scanner;

public class Main
{
    private static int iterCount = 0;

    private static String getLowestHighestNumber(String numberAsString, boolean isHighest)
    {
        char firstCharToSwap;
        char secondCharToSwap;

        int firstNumber;
        int secondNumber;

        StringBuffer numberAsStringBuffer = new StringBuffer(numberAsString);

        for (int i = 0; i < numberAsStringBuffer.length() - 1; i++)
        {
            for (int j = 0; j < numberAsStringBuffer.length() - 1 - i; j++)
            {
                firstCharToSwap = numberAsStringBuffer.charAt(j);
                secondCharToSwap = numberAsStringBuffer.charAt(j + 1);

                firstNumber = Integer.parseInt(Character.toString(firstCharToSwap));
                secondNumber = Integer.parseInt(Character.toString(secondCharToSwap));

                if(firstNumber > secondNumber)
                {
                    numberAsStringBuffer.setCharAt(j, secondCharToSwap);
                    numberAsStringBuffer.setCharAt(j + 1, firstCharToSwap);
                }
            }
        }

        if(!isHighest) return numberAsStringBuffer.toString();
        else return numberAsStringBuffer.reverse().toString();
    }

    private static void Kaprekar(int number)
    {
        iterCount++;

        if(number == 6174)
        {
            iterCount--;

            return;
        }

        String tempString = Integer.toString(number);
        int digitsAmount = tempString.length();

        if (digitsAmount < 4) tempString += "0";

        int tempLowest = Integer.parseInt(getLowestHighestNumber(tempString, false));
        int tempHighest = Integer.parseInt(getLowestHighestNumber(tempString, true));

        System.out.println(tempHighest + " - " + tempLowest);

        Kaprekar(tempHighest - tempLowest);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int inputNumber = scanner.nextInt();

        Kaprekar(inputNumber);

        System.out.println(String.format("Iterations: %d", iterCount));
    }

}
