package homework6;

import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;

public class Homework6 {

    public static PrintStream ps;

    public static void main(String[] args) throws Exception {
        ps = new PrintStream("hmwk6outpt.txt");

        Scanner scan = new Scanner(System.in);

        final int MAX = 1000;

        String[] element = new String[MAX];
        double[] weight = new double[MAX];

        int count = readPeriodicTable(element, weight);
        BubbleSort(element, weight, count);
        PrintTable(element, weight, count);

        PromptUser();
        String molecularFormula = scan.next();

        while (!molecularFormula.equals("0")) {

            double total = numberOfGramsPerMole(element, weight, count, 
                    molecularFormula);

            System.out.println("The weight in grams of 1 mole of " + 
                    molecularFormula + " is: " + total);
            ps.println("\nThe weight in grams of 1 mole of " + 
                    molecularFormula + " is: " + total);

            PromptUser();
            molecularFormula = scan.next();
        }

    }//end main method

//this method fills the two arrays that were created in the main method one with
//the element symbols, and one with the atomic weights found in the .txt file 
//this method is passed two empty arrays - one for strings, and one for doubles
//this method returns the 'count' which is the amount of elements/atomic numbers
    public static int readPeriodicTable(String[] e, double[] w) throws Exception{
        Scanner sc = new Scanner(new File("AtomicWeights2.txt"));

        int count = 0;
        while (sc.hasNext()) {
            e[count] = sc.next();
            w[count] = sc.nextDouble();
            count++;
        }
        return count;
    }//end readPeriodicTable

//the method sorts the arrays of elements and weights in alphabetica order 
//simultaneoulsy so that the proper weight corresponds to the proper element symbol
//the method is passed the unsorted arrays of elements and atomic weights, and 
//the number of elements that was returned from the previous method
//this method returns void as it is meant to sort the arrays- not do any calculations
    public static void BubbleSort(String[] element, double[] weight, int count) {
        int j, pass;
        double temporary;
        String hold;
        boolean switched = true;

        for (pass = 0; pass < count - 1; pass++) {

            for (j = 0; j < count - pass - 1; j++) {
                if (element[j].compareTo(element[j + 1]) > 0) {
                    switched = false;
                    hold = element[j];
                    element[j] = element[j + 1];
                    element[j + 1] = hold;
                    temporary = weight[j];
                    weight[j] = weight[j + 1];
                    weight[j + 1] = temporary;
                }
            }
        }
    }//end BubbleSort

//this method prints the table of the sorted list of elements and corresponding weights 
//this method is passed the array of element symbols, array of the atomic weights,
//and the amount of elements in these lists 
//this method is declared as void as it just prints the sorted list 
    public static void PrintTable(String[] element, double[] weight, int count) {
        System.out.println("Element\tAtomic Weight");
        ps.println("Element\tAtomic Weight");
        
        for (int i = 0; i < count; i++) {
            System.out.printf("%s\t%.5f\n", element[i], weight[i]);
            ps.printf("%s\t%.5f\n", element[i], weight[i]);
        }
    }//end PrintTable
    
//this method prints the prompt for the user
//this method is not passed anything as it is just printing a message
//this method is void as it is printing a message    
    public static void PromptUser() {
        System.out.println("\nplease enter a molecular formula");
        System.out.println("enter 0 to stop");
    }//end PromptUser

//this method calculates the number of grams per mole of the atomic formula inputed
//we pass the array of elements and atomic weights, the amount of elements in 
//these arrays and the string that the use inputted into the scanner
//the method returns the total grams accumulated through the various if- else loops 
    public static double numberOfGramsPerMole(String[] element, double[] weight, int count, String a) {
        String atom = "";
        int coefficient = 1;
        double total = 0;

        for (int i = 0; i < a.length(); i++) {
            int j = i;
            char c = a.charAt(j);

            if (Character.isUpperCase(c)) {

                if (j < a.length() - 1) {// each of these if statements checks 
                                  //if there is another character in the string 
                    char c1 = a.charAt(j += 1);

                    if (Character.isLowerCase(c1)) {
                        atom = "" + c + c1;

                        if (j < a.length() - 1) {
                            char c2 = a.charAt(j += 1);

                            if (Character.isDigit(c2)) {

                                if (j < a.length() - 1) {
                                    char c3 = a.charAt(j += 1);

                                    if (Character.isDigit(c3)) {
                                        coefficient = Integer.parseInt(""+c2+c3);
                                        
                                    } else {
                                        coefficient = Integer.parseInt(""+c2);
                                    }
                                }
                            }
                        } else {
                            coefficient = 1;
                        }

                    } else if (Character.isDigit(c1)) {
                        atom = "" + c;
                        coefficient = Integer.parseInt(""+c1);

                        if (j < a.length() - 1) {

                            char c4 = a.charAt(j += 1);

                            if (Character.isDigit(c4)) {
                                coefficient = Integer.parseInt(""+c1+c4);
                            }
                        }
                    }   
                } else {
                    atom = "" + c;
                    coefficient = 1;
                }
                double atomicMass = findMassNumber(element, weight, count, atom);
                total = total + (atomicMass * coefficient);
            }
        }
        return total;
    }//end numberOfGramsPerMole
    
//this method performs a binary search to search for the weight of the element 
//symbol passed in
//this method is passed the array of elements, the array of weights, the count 
//and the element name found in numberOfGramsPerMole
//this method returns the weight of the element that matches the value of the 
//corresponding element name
    public static double findMassNumber(String[] element, double[] weight, int 
            count, String c) {

        int low = 0;
        int high = count - 1;
        String s = c;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (s.compareTo(element[middle]) > 0) {
                low = middle + 1;
            } else if (s.compareTo(element[middle]) < 0) {
                high = middle - 1;
            } else {
                return weight[middle];
            }
        }
        return 0;
    }//end findMassNumber

}//end Homework6
