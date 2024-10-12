package Package2;

import java.util.ArrayList;
import java.util.List;

public class BuildingSkylines {

	public static void main(String[] args) {
		// Q3 -->
		
		// Example input: list of buildings
        int[][] buildings = {
            {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
        };
        List<int[]> skyline = getSkyline(buildings);


        // Output the skyline
        System.out.println("Skyline:");
        for (int[] point : skyline) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }

	}
	
	public static List<int[]> getSkyline(int[][] buildings) {
		if (buildings.length == 0)
			return new ArrayList<>();
		return getSkylinee(buildings,0,buildings.length-1);
	}
	
	public static List<int[]> getSkylinee(int[][] buildings,int left,int right) {
		if(left == right) {
			List<int[]> result = new ArrayList<>();
			result.add(new int[]{buildings[left][0],buildings[left][2]});
			result.add(new int[]{buildings[left][1],0});
			return result;
		}
		
		int middle = (left+right) / 2;
		List<int[]> leftSkyline = getSkylinee(buildings, left, middle);
		List<int[]> rightSkyline = getSkylinee(buildings, middle+1, right);
		
		return mergeSkylinee(leftSkyline, rightSkyline);
		
	}
	
	public static List<int[]> mergeSkylinee(List<int[]> left,List<int[]> right){
		List<int[]> merged = new ArrayList<>(); 
		int leftIndex = 0,rightIndex = 0;
		int leftHeight = 0,rightHeight = 0;
		int currentHeight = 0;
		
		while(leftIndex < left.size() && rightIndex < right.size()) {
			int[] points;
			if(left.get(leftIndex)[0] < right.get(rightIndex)[0]) {
				points = new int[]{left.get(leftIndex)[0],
					Math.max(left.get(leftIndex)[1], rightHeight)};
				leftHeight = left.get(leftIndex)[1];
				leftIndex++;
			}else if(left.get(leftIndex)[0] > right.get(rightIndex)[0]) {
				points = new int[] {right.get(rightIndex)[0],
						Math.max(right.get(rightIndex)[1], leftHeight)};
				rightHeight = right.get(rightIndex)[1];
				rightIndex++;
			}else {
				points = new int[] {left.get(leftIndex)[0],
						Math.max(left.get(leftIndex)[1], right.get(rightIndex)[1])};
				leftHeight = left.get(leftIndex)[1];
				rightHeight = right.get(rightIndex)[1];
				leftIndex++;
				rightIndex++;
			}
			
			if(currentHeight != points[1]) {
				merged.add(points);
				currentHeight = points[1];
			}
		}
		
		while(leftIndex < left.size()) {
			merged.add(left.get(leftIndex));
			leftIndex++;
		}
		
		while(rightIndex < right.size()) {
			merged.add(right.get(rightIndex));
			rightIndex++;
		}
		
		return merged;
	}

}
