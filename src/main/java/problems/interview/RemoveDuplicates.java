package problems.interview;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] input = new int[]{2,5,4,4,6,7,8,6,7,4,7,10,12,10};
		int[] output = new int[input.length];
		int k = 0;
		for(int i=0;i<input.length;i++){
			int currElem = input[i];
			boolean alreadyExists = false;
			for(int j=0;j<output.length;j++){
				if(output[j] == currElem){
					alreadyExists = true;
					break;
				}
			}
			if(!alreadyExists){
				output[k++] = currElem;
			}
		}
		System.out.println(Arrays.toString(output));
	}
}
