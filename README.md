# Avagadro's Number Calculator

## Purpose

This program allows a user to input a molecular formula and 
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

## Execution

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
two arrays the size of MAX- one of strings and one of doubles. 
<br><br>
I now begin calling different methods. I intialize an `int` called `count` that's the returned value
from the method `readPeriodicTable()`. The method `readPeriodicTable` is passed the 
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
elements are in the array- this value is returned to the main and set as `count`.
The next method we call is `BubbleSort()` method. This method is meant to sort 
both arrays simultaneously in so that the string array ends up in alphabetical 
order. The method is passed the two filled arrays and the count. It performs a 
bubble sort comparing the Character values of the Strings of the element symbols. 
The `s.compareTo(s1) >0` method allows us to asses if one string is greater than 
the next - that means that the decimal value of one string is greater than the 
next aka this letter comes after the next symbol's letter in the alphabet.
If the string is greater than the next the two are swapped and when moving the
location of one slot of the string array, the matching atomic wheight slot is 
also swapped. This process continues until all the strings are in their right 
places-listed from A-Z. This method doesnt return anything as it's just sorting 
the arrays. In the main, the next method that is called is the `printTable()`
method. This method is passed the sorted array of element symbols, the sorted 
array of atomic weights and the amount of slots each of these arrays have 
(which is the same amount). This method prints a header for the table 
then prints the sorted arrays simultaneously separated by a tab. The element 
symbol is printed then that symbol's atomic weight is printed until everything 
in the array is printed. The main now prompts the user by calling the method 
`promptUser()` which prints a message to enter a Molecular formula and enter 0 to
stop the loop. The user's input is set to the string `molecularFormula`. I set 
up a while loop which stops if the inputed string is "0". So while the input is 
not "0" we set the `total` to be the value returned from the `numberOfGramsPerMole()` 
method. <br><br>
Now for the actual calculation...The `numberOfGramsPerMole()` method includes
various `if-else` statements to find the exact element symbol and coefficient pair. 
This method stores the element symbol, the coefficient amount, then sends the 
binary search method the element symbol and returns the weight of that element. 
This returned amount is then times by the coefficient and is added to 
the running total. <br><br>
To start, `numberOfGramsPerMole()` reads in the two arrays, the 
`count`, and the string that was inputed by the user. Now within this method we 
initialize a String `atom` as a null pointer, intialize the integer `coefficient` 
to 1, and the double `total` to 0. we start a `for` loop that is initialized as 
i=0, i<= the length of the user's molecular formula -1 and when the loop goes through we add one to i- looking
at the character in the next position. The first step in the for loop 
is to initialize `j=i` so that we dont interfere with the count of i as we go 
through the `if-else` statements. Basically j right now is the location that i is 
at. I set the character at the location of j in the string that the user inputed
as c using the `charAt(j)` method. The basic gist of the rest of the method is checking 
whether te character is an uppercase letter, lowercase letter, or digit character. If the character is an uppercase 
letter then we know that we've started a new Element and the next character(if there is one) can 
be either a lower case letter, an upper case letter or a number. 

As each of the if statements are satisfied, they 'jump out' of the
loop with the coefficient and element symbol where we call the 
`findMassNumber()` method which uses a binary search to find 
the proper element and return it's corresponding weight from the sorted arrays. 
This method is passed the organized lists, the count and the element symbol that was assesed in 
`numberOfGramsPerMole()`. As long as the element is found it's weight (the same numbered slot
in the natomic weight array) is returned, otherwise 0 is returned. This value is
stored in `atomicMass`. We use the value of the atomic mass times the 
integer value of the coefficient found through the if statements and add that 
to the running total. This total is accumulated as i increments and every character 
in the string is read and accounted for. The method finally returns `total` to the
main. A message is printed which reads - "for `a certain molecular formula` grams per
mole is `total`. " The user is prompted again and the scanner waits for the user
to input yet another formula to start this process over. 

## End Notes
I have to be honest. I found this program difficult. At first I got the 
various sorts, searches, print methods done easily, then numberOfGramsPerMole()
hit me. After understanding the logic of the method, the actual syntax was hard to get right. After
I realized to set j as i , things were making a little bit more sense, but then I
kept getting outOfBoundsExceptions. After much debugging I saw that the string 
didnt neccessarily need to exist after a certain point therefore we couldnt just
keep adding 1 to j since some strings wouldnt have another character. At that 
point my program only worked for the inputs of upper, lower, digit, digit. I 
then thought to add another if statement saying that if j is still less than 
the length-1 (because it started as 0) but didnt add enough of them- aka every
time i added another j. After speaking with my Proffessor and fixing up a 
couple of mistakes the program was smooth sailing. What I've learned from this project definetely helped me  
further my studies in CS
