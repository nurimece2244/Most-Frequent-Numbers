import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
* Program finds and displays the most frequent numbers
* @author Nur Ýmece
* @since 27.7.2020
*/
public class Nur_Ýmece {
public static void main(String[] args) {
//int[] numbers = loadNumbers("src/data1.txt"); // loads input numbers from a text file
//int[] numbers = loadNumbers("src/data2.txt");
int[] numbers = loadNumbers("src/data3.txt");
}
 /**
* Load numbers from a text file
* @param filename Name of the file
* @return Array containing numbers
*/
private static int[] loadNumbers(String filename) {
File file = new File(filename);
Scanner input = null;
try {
input = new Scanner(file);
} catch (FileNotFoundException e) {
System.out.println(filename + ": Input file can not be found!\nExiting program...");
System.exit(1);
}
int[] values = new int[10000];
int counter = 0;
while(input.hasNext()) {
String line = input.nextLine();
values[counter++] = Integer.parseInt(line.trim());

}

int[] numbers = new int[counter]; // keep values from text file
int[] freqArray = new int[counter]; // frequency of the elements of the array


for (int i = 0; i < counter; i++) {
	numbers[i] = values[i]; 
	
}
/**
 * In this nested loop
 * we check the frequency of the array elements
 */
for(int search=0; search<counter; search++) { 
	int counter2 =1; // keep the frequency of element and each time begin 1
	for(int k=search+1; k< counter; k++) { 
		if(numbers[search] == numbers[k]) { // check the value the same or not 
			counter2++; // increasing the value of element counter
			freqArray[k]= -1; // to avoid counting the same element again
			// write the frequency value to one element
			
			}
	}

if(freqArray[search]!= -1) { // if is not "-1", write the frequency value to one element
	freqArray[search]= counter2;
// we find the frequencies of all elements and throw them into the array
	
}	
}	

int maxFreq= freqArray[0]; // at the beginning we accept the first element max frequency
	for(int k = 1; k< counter;k++) {
			if( maxFreq < freqArray[k]) { // if maximum frequency smaller than the new value 
				// the new value becomes the maximum value
				maxFreq = freqArray[k];	
				
	        }
	}
System.out.println("Most Frequent Numbers: ");
/**
 * Shows values with maximum frequencies
 */
for(int p =0; p< counter; p++) {
if(maxFreq == freqArray[p] ) { // Controls the values that have the maximum value in the array
System.out.printf("Number: %2d, Frequency: %2d\n",numbers[p], freqArray[p]);
	}
}


return numbers;
}
}