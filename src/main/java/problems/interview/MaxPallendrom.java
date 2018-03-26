package problems.interview;

import java.util.HashMap;
import java.util.HashSet;

public class MaxPallendrom {

	HashMap<String, Boolean> processedStrings = new HashMap<>();
	public String maxPallendrom(String s){
		boolean isPallendrom = isPallendrom(s);
		if(isPallendrom){
			return s;
		} else {
			String left = s.substring(1);
			String right = s.substring(0, s.length()-1);
			boolean isLeftPallendrom = isPallendrom(left);
			boolean isRightPallendrom = false;
			if(isLeftPallendrom){
				return left;
			} else {
				isRightPallendrom = isPallendrom(right);
			}
			if(isRightPallendrom){
				return right;
			}
			String leftResult = maxPallendrom(left);
			String rightResult = maxPallendrom(right);
			if(leftResult.length() > rightResult.length()){
				return leftResult;
			} else {
				return rightResult;
			}
		}
	}

	public boolean isPallendrom(String s){
		Integer start = 0;
		Integer end = s.length()-1;
		boolean isPallendrom = true;

		while (start < end){
			if(s.charAt(start) != s.charAt(end)){
				isPallendrom = false;
				break;
			} else {
				start++;
				end--;
			}
		}
		return isPallendrom;
	}
}
