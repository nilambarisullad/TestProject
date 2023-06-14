package com.jsonReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GreatestCommonDiv {

	public static void main(String[] args) {
		int [] inputArray = {5,2,0,8};
		GreatestCommonDiv obj = new GreatestCommonDiv();
		System.out.println(obj.highestCommonFactor(inputArray));
	}
	
	public int highestCommonFactor(int[] numbers) {

		List<Integer> ascendingNumbers = Arrays.stream(numbers)     // IntStream 
                .boxed()        // Stream<Integer>
                .collect(Collectors.toList());
		
		ascendingNumbers.sort(null);
						
		List<Integer> divisibleNumbers = new ArrayList<Integer>();

		List<Integer> temp = new ArrayList<Integer>();

		ascendingNumbers.stream().filter(s->s<=0).forEach(n->System.out.println("Please enter postitive numbers."));

		for(int i=0 ; i<ascendingNumbers.size(); i++)
		{
			//System.out.println(ascendingNumbers.get(i));
			
			divisibleNumbers = new ArrayList<Integer>();

			for(int divisible = 1 ; divisible<=ascendingNumbers.get(i);divisible++) {
				int factor = ascendingNumbers.get(i)% divisible ;
				if(factor==0) {
					divisibleNumbers.add(divisible);
			        Collections.sort(divisibleNumbers, Comparator.reverseOrder());
				}
			}

			if(i==0) {
				temp = divisibleNumbers;
			}
			
			if(i!=0) {
				divisibleNumbers.retainAll(temp);
				temp = divisibleNumbers;
			}
			
		}
		
		divisibleNumbers.forEach(s -> System.out.println("Final"+s));

		return Collections.max(divisibleNumbers);
	}

}
