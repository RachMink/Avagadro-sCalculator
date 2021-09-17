/*
@name: Rachel Minkowitz
@since: 12/01/2020
@version: 2.0
@description: This program allows a user to input a molecular formula and 
calculates the weight of one mole in grams. A mole of a substance is defined as 
containing exactly 6.02×10^23 particles of that substance (also known as 
Avagodro's Number). An element's atomic weight is equal to the grams in 1 mole 
of that substance. Therefore, if we use the atomic weights of specific elements 
multiplied by their coefficients we can determine the total mass which is 
equivelent to the grams per mole of that element. 
    This program calculates the number of grams in 1 mole of a substance given 
it's molecular formula. We are able to execute this process by parsing the 
user's input in order to determine each element and it's coefficient within the 
molecular formula. With the information of which element we are looking for and 
how many of that element is in the molecular formula we are able to find the 
molecular weight of that element and times it by the amount of that element. If 
we have more than one type of element we must add them all together.
    This program uses various methods, some methods are called within other 
methods, while some are only called in the main method. The program begins with 
calling the File class which with the help of the Scanner object enables 
the program to read from an already existing file as input. We also call the
PrintStream Class which allows us to print to a plain text file. I start the 
Homework6 class with setting up the public object PrintStream printer 'ps'so 
that all the methods are able to access it and print to the .txt file. The main 
method is started and since we're using the PrintStream method we throw any 
exceptions that may arise. I start with naming the PrintStream that we are 
printing to "hmwk6output.txt" then set up my scanner. As the data I use in this
program is inputed from a user I set my scanner to be the System.in- the keyboard. 
I create a set amount of integers called MAX that I set to 1000. I then create 
two arrays the size of MAX- one of strings and one of doubles. I now begin calling
different methods. I intialize an integer called count that's the returned value
from the method readPeriodicTable(). The method readPeriodicTable is passed the 
two empty arrays and throws exceptions as it uses an external file to fill up 
the arrays. Within this method I set up a new scanner that reads from a file 
called "AtomicWeights2.txt". While this scanner has another item to read in it 
reads the string item and the next double item into the next slots in the 
appropriate arrays. Since this file is made up of Element symbols and atomic 
weights- strings and doubles- each one right after the next the two arrays are 
filled simultaneoulsy- once a string is read into the string array the subsequent
atomic weight is read into the double array. This allows the element symbol and 
it's atomic weight to lie in the same numbered slot in the two different arrays.
This fact is important for sorting and searching. Within the loop that fills the
arrays there's a counter so that once a set of element symbol and it's weight 
are read in the counter adds one- this allows us to keep track of how many 
elements are in the array- this value is returned to the main and set as 'count'.
The next method we call is BubbleSort() method. This method is meant to sort 
both arrays simultaneously in so that the string array ends up in alphabetical 
order. The method is passed the two filled arrays and the count. It performs a 
bubble sort comparing the Character values of the Strings of the element symbols. 
The s.compareTo(s1) >0 method allows us to asses if one string is greater than 
the next - that means that the decimal value of one string is greater than the 
next aka this letter comes after the next symbol's letter in the alphabet.
If the string is is greater than the next the two are swapped and when moving the
location of one slot of the string array, the matching atomic wheight slot is 
also swapped. This process continues until all the strings are in their right 
places-listed from A-Z. This method doesnt return anything as it's just sorting 
the arrays. In the main, the next method that is called is the printTable()
method. This method is passed the sorted array of element symbols, the sorted 
array of atomic weights and the amount of slots each of these arrays have 
(which is the same amount). This method prints a header for the table 
then prints the sorted arrays simultaneously separated by a tab. The element 
symbol is printed then that symbol's atomic weight is printed until everything 
in the array is printed. The main now prompts the user by calling the method 
promptUser() which prints a message to enter a Molecular formula and enter 0 to
stop the loop. The user's input is set to the string 'molecularFormula'. I set 
up a while loop which stops if the insputed string is "0". So while the input is 
not "0" we set the total to be the value returned from the numberOfGramsPerMole 
method. Now for the actual calculation...The numberOfGramsPerMole method includes
various if-else statements to find the exact element symbol and coefficient pair. 
This method stores the element symbol, the coefficient amount, then sends the 
binary search method the element symbol and returns the weight of that element. 
This returned amount is then times that by the coefficient and is added to 
the running total. To start, numberOfGramsPerMole reads in the two arrays, the 
count, and the string that was inputed by the user. Now within this method we 
initialize a String 'atom' as a null pointer, intialize the integer 'coefficient' 
to 1, and the double 'total' to 0. we start a for loop that is initialized as 
i=0, i<= the length of the user's molecular formula -1 (because the length method
counts starting from 1) and when the loop goes through we add one to i- looking
at the character in the next position. The first step in the for loop 
is to initialize j=i so that we dont interfere with the count of i as we go 
through the if- else statements. Basically j right now is the location that i is 
at. I set the character at the location of j in the string that the user inputed
as c using the charAt(j) method. We go through the first if else statement that 
checks whether c is an uppercase/lowercase/digit character. If c is an uppercase 
letter then we know that we've started a new Element- if there is another 
character after this the method assigns this next character as char c1. c1 can 
be either a lower case letter, an upper case letter or a number. If c1 is a lower
case letter then we know that atom is equal to the upper case letter and the 
lower case letter (c+c1). Now, if there is another character after this in the 
string, the program initializes the next character j+=1 to c2. If c2 is a digit 
we know that this symbol has a coefficient. This coefficient can be two digits 
like 22  therefore we say if this string has yet another character this character
is c3. If c3 is a digit then the coefficient is the integer value of the string 
c2+c3. If c3 is not a digit or there is no other character in this string then 
the coefficient is the integer value of c2. Sticking with the Upper+Lowercase 
scenario if there was no additional chracter after c1 then the coefficient is 
automatically 1. Now, if c1 was not a lower case there are only two other 
options- it can either be another uppercase or a digit. If c1 is a digit we know
that foresure c is the atom and c1 either is the coefficient or the first number
of the coefficient. We say if there is another character in this string then we 
intialize this character to c4. If c4 is a digit we say the coefficient is the 
integer value of c1+c4. If c4 is not a digit, c1 is still the coefficient. Now 
going back to the options after the Upper case. The last option is for the next 
character to be an uppercase letter where in that case the c is the atom and the
coefficient is 1. Now as each of these statements satisfies and jumps out of the
if statements with its coefficient and element symbol we call a method 
findMassNumber which uses the sorted lists to go through a binary search to find 
the proper element and return it's corresponding weight. This method is passed the 
organized lists, the count and the element symbol that was assesed in the method 
numberOfGramsPerMole. This search uses the decimal value of the letters it searches 
the sorted list- whether this letter can be found above or below the 
middle point. As long as the element is found it's weight (the same numbered slot
in the natomic weight array) is returned, otherwise 0 is returned. This value is
stored in the double atomicMass. We use the value of the atomic mass times the 
integer value of the coefficient found through the if statements and add that 
to the running total. This total is accumulated as i increments and every character 
in the string is read and accounted for. The method finally returns 'total' to the
main. A message is printed which reads - for a certain molecular formula grams per
mole is the 'total'. The user is prompted again and the scanner waits for the user
to input another formula. 
    I have to be honest. I found this program difficult. At first I got the 
various sorts, searches, print methods done easily, then numberOfGramsPerMole()
hit me. After undestaning the logic the actual syntax was hard to get right. After
I realized to set j as i things were making a little bit more sense, but then I
kept getting outOfBoundsExceptions. After much debugging I saw that the string 
didnt neccessarily need to exist after a certain point therefore we couldnt just
keep adding 1 to j since some strings wouldnt have another character. At that 
point my program only worked for the inputs of upper, lower, digit, digit. I 
then thought to add another if statement saying that if j is still less than 
the length-1 (because it started as 0) but didnt add enough of them- aka every
time i added another j. After speaking with Proffessor Langsam and fixing up a 
couple of mistakes the program was smooth sailing. Thank you for this semester! 
I definetely gained an immense amount of knowledge that has piqued my interest 
in this subject and G-d willing I'll use what I've learned in this class to 
to further my studies and my future. Thanks again. 


 */
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
