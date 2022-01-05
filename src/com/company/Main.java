package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException

    {
        question1();
        //question2();
    }

    public static void question1() throws IOException
    {
        File mnths = new File("Mnths.txt");
        Scanner mnthsScanner = new Scanner(mnths);
        int valuesAray[] = {50,45,68,25,25,65,21,-8,26,8,3,28};
        String stars = "", currentMnth;
        int sumOfRainfall = 0;
        int wettestMnthInt = 0, driestMnthInt = valuesAray[0];
        String wettestMnthString = "",driestMnthString = "";

        /*if(!figuers.exists())
        {
            String filePath;
            for(int i = 2;i<=3 && !figuers.exists();i++)
            {
                System.out.println("File Does not exist");
                figuers = new File(filePath());


            }

            if(!figuers.exists())
            {

            }

        }*/

            System.out.println("---------------------------------------------------------------------------\n" +
                    "Rainfall Analysis Report\n" +
                    "---------------------------------------------------------------------------\n" +
                    "----------------------------------------------------------------------------\n" +
                    "Input File Name \t: "+ mnths.getName()+" \n" +
                    "----------------------------------------------------------------------------\n" +
                    "Month\t\t\tRainFall(mm)\n");

            for (int stats : valuesAray)
            {
                currentMnth = mnthsScanner.nextLine();

                if(stats > -1)
                {
                    System.out.printf(currentMnth +" %27d \n",stats);
                    sumOfRainfall += stats;

                    if(stats < driestMnthInt)
                    {
                        driestMnthInt = stats;
                        driestMnthString = currentMnth+"("+driestMnthInt+" mm)";
                    }
                    else if(stats > wettestMnthInt)
                    {
                        wettestMnthInt = stats;
                        wettestMnthString = currentMnth+"("+wettestMnthInt+" mm)";
                    }
                }
                else
                {
                    System.out.print(currentMnth +"\t\t\t\t\t  No Data\n");
                }
            }

            System.out.print("--------------------------------------------------------------------\n" +
                    "Bar Chart\n" +
                    "--------------------------------------------------------------------\n");

            for(int stats : valuesAray)
            {
                for(int i = 0;i < (stats/10) ;i++)
                {
                    stars += "*";
                }
                System.out.print(mnthsScanner.nextLine()+" \t"+stars+"\n");
                stars = "";
            }

            System.out.println("---------------------------------------------------------------------\n" +
                    "Note: Each * represents 10mm of Rainfall\n" +
                    "---------------------------------------------------------------------\n" +
                    "---------------------------------------------------------------------\n" +
                    "Summary\n" +
                    "--------------------------------------------------------------------\n");

            System.out.printf(mnthsScanner.nextLine()+" %20d \n",(sumOfRainfall/12));
            System.out.printf(mnthsScanner.nextLine()+" %27s \n",wettestMnthString);
            System.out.printf(mnthsScanner.nextLine()+" %27s \n",driestMnthString);

            System.out.print("--------------------------------------------------------------------");
            System.out.println("");

        //System.out.print("File Does not exist");

        mnthsScanner.close();
    }

    public static void question2()
    {
        Random randomNum = new Random();
        Scanner input = new Scanner(System.in);

        int guesses = 0;
        int guessedNum = 0;
        int generatedNum = (1 + randomNum.nextInt(10));;
        boolean gotCorrect = false;

        System.out.println("Guessing game!!!");
        for(int i = 1; i<=5 && !gotCorrect; i++)
        {
            System.out.print("Enter guess number from 1 to 10: ");
            guessedNum = input.nextInt();

            guesses++;
            if(guessedNum<1 || guessedNum > 10)
            {
                System.out.println("Enter number out of bounds\n");
                i--;
                guesses--;
            }
            else if(guessedNum > generatedNum)
            {
                System.out.println("Too High, Try Again\n");
            }
            else if(guessedNum < generatedNum)
            {
                System.out.println("Too low, Try Again\n");
            }
            else
            {
                System.out.println("\nCorrect number: "+generatedNum+"\nNumber of guesses: "+ guesses);
                gotCorrect = true;
            }
        }
        if(!gotCorrect)
        {
            System.out.println("\nMaximum attempts Exceeded. The correct number was "+generatedNum);
        }
        input.close();
    }

    public static String filePath()
    {
        Scanner kb =new Scanner(System.in);
        System.out.print("Enter file name: ");
        String path = kb.nextLine();
        kb.close();
        return path;
    }
}
