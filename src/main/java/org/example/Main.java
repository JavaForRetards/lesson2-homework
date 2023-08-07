package org.example;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//made with bytes, since the value is small enough to fit in 8 bits, but it doesn't really matter
		byte[] originalArray = new byte[5];

		//get the input
		Scanner s = new Scanner(System.in);
		int counter = 0;
		do {
			System.out.print("Please input a positive integer lower than 10: ");
			byte k = s.nextByte();
			if(k < 0 || k > 10)
				System.out.print("The number must be positive and lower than 10!");
			else {
				originalArray[counter] = k;
				counter++;
			}
		} while(counter < 5);
		s.close();

		//print out members
		for(byte b : originalArray) {
			switch(b) {
				case 0:
					System.out.println("zero");
					break;
				case 1:
					System.out.println("one");
					break;
				case 2:
					System.out.println("two");
					break;
				case 3:
					System.out.println("three");
					break;
				case 4:
					System.out.println("four");
					break;
				case 5:
					System.out.println("five");
					break;
				case 6:
					System.out.println("six");
					break;
				case 7:
					System.out.println("seven");
					break;
				case 8:
					System.out.println("eight");
					break;
				case 9:
					System.out.println("nine");
					break;
			}
		}

		//what follows is one possible approach, called BubbleSort, easily the simplest "famous" solution to this problem
		//it's quite slow, but it wins in simplicity
		//there's dozens, see https://en.wikipedia.org/wiki/Sorting_algorithm if you're curious

		//create second array, containing same elements as first
		byte[] sortedArray = new byte[originalArray.length];
		for(int i = 0; i < originalArray.length; i++)
			sortedArray[i] = originalArray[i];
		//for loop above is equivalent to the following:
		//System.arraycopy(originalArray, 0, sortedArray, 0, originalArray.length);

		for(int i = 0; i < sortedArray.length - 1; i++) { //for each array member save the last
			for(int j = i + 1; j < sortedArray.length; j++) {
				if(sortedArray[j] < sortedArray[i]) { //compare it with all members ahead of it
					//swap array contents
					//no need to actually account for identical values
					byte tmp = sortedArray[i];
					sortedArray[i] = sortedArray[j];
					sortedArray[j] = tmp;
				}
			}
		}

		//print the result:
		System.out.print("[");
		for(int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i]);
			if(i == sortedArray.length - 1)
				System.out.println("]");
			else System.out.print(", ");
		}
	}
}