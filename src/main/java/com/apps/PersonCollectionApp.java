package main.java.com.apps;

import main.java.com.modules.PersonCollection;

public class PersonCollectionApp {

    public static void main(String[] args) {


        String[] personProfiles = new String[] {
                "Lsea,Klip,31,analyst,morrisville",
                "Lott,Fero,,analyst,morrisville",
                ",Reddy,40,analyst,morrisville ",
                "Norm,Chit,,analyst, ",
                "Lott,Fero,40,analyst,durham"
        };

        //TC1: Validate profiles from a list of valid personal details  (Validation: FN, LN cannot be null)
        PersonCollection aPersonStats = new PersonCollection();
        aPersonStats.popualteProfile(personProfiles);
        String[] resultPrint = aPersonStats.printPersonProfile();
        if(resultPrint[0].equals("First Name is LSEA; Last Name is KLIP; Age is 31; Role is ANALYST; City is MORRISVILLE") &&
                resultPrint[1].equals("First Name is LOTT; Last Name is FERO; Age is ; Role is ANALYST; City is MORRISVILLE") &&
                resultPrint[2].equals("First Name is NORM; Last Name is CHIT; Age is ; Role is ANALYST; City is EMPTY") &&
                resultPrint[3].equals("First Name is LOTT; Last Name is FERO; Age is 40; Role is ANALYST; City is DURHAM")) {

            System.out.println("TC1: Test Case to verify the list of valid personal details PASSED");

            System.out.println("Input list is: " + "Lsea,Klip,31,analyst,morrisville" + "; " +
                    "Lott,Fero,,analyst,morrisville" + "; " +
                    ",Reddy,40,analyst,morrisville " + "; " + "Norm,Chit,,analyst, " + "; " +
                    "Lott,Fero,40,analyst,durham");
            System.out.println("Result is: " +
                    resultPrint[0] + ", " + resultPrint[1] + ", " + resultPrint[2] + ", " + resultPrint[3]);
        }else {
            System.out.println("TC1: Test Case to verify the list of valid personal details FAILED");
            System.out.println("Input list is: " + "Lsea,Klip,31,analyst,morrisville" + "; " +
                    "Lott,Fero,,analyst,morrisville" + "; " +
                    ",Reddy,40,analyst,morrisville " + "; " + "Norm,Chit,,analyst, " + "; " +
                    "Lott,Fero,40,analyst,durham");
            System.out.println("Result is: " +
                    resultPrint[0] + ", " + resultPrint[1] + ", " + resultPrint[2] + ", " + resultPrint[3]);
        }

        //TC2: Validate person count in each city for valid input profiles (Validation: FN, LN cannot be null)
        String[] result = aPersonStats.personCount();
        if(result[0].equals("City: MORRISVILLE >> Person Count: 2, ") &&
                result[1].equals("City: EMPTY >> Person Count: 1, ") &&
                result[2].equals("City: DURHAM >> Person Count: 1, ")) {
            System.out.println(" ");
            System.out.println("TC2: Test Case to validate person count in each city is PASSED");
            System.out.println("Result is:  " + result[0] + result[1] + result[2]);
        }
        else {
            System.out.println("TC2: Test Case to validate person count in each city is FAILED");
            System.out.println("Result is:  " + result[0] + result[1] + result[2]);
        }
    }
}
