import java.util.Stack;

public class LargestRectangleHistogram {

	private static void findLargestRectangularArea(int[] height) {
		int n = height.length;
		Stack<Integer> s = new Stack<>();
		int maxArea=height[0];
		int top = -1;
		int j = 0;
		for(int i = 0; i < n ; i++){
			j = i;
			if(!s.isEmpty())top = s.peek();
			while(!s.isEmpty() && height[s.peek()] > height[i]){
				j = s.pop();
				maxArea = Math.max(maxArea, height[j]*(top-j+1));
			}
			height[j]=height[i];
			s.push(j);
			if(i!=j)s.push(i);
		}
		if(!s.isEmpty())top = s.peek();
		while(!s.isEmpty()){
			j = s.pop();
			maxArea = Math.max(maxArea, height[j]*(top-j+1));
		}
		System.out.println(maxArea);
		
	}
	
	public static int findLargestRectangle(int h[]) {
		int area = 0;
		Stack<Integer> hStack = new Stack<>();
		Stack<Integer> posStack = new Stack<>();
		int currentHeight = 0;
		int tempH = 0;
		int tempPos = 0;
		for(int i=0;i<h.length;i++) {
			currentHeight = h[i];
			tempPos = i;
			if(hStack.isEmpty() || currentHeight > hStack.peek()) {
				hStack.push(currentHeight);posStack.push(i);
			}else if(currentHeight < hStack.peek()){
				while(!hStack.isEmpty() && currentHeight < hStack.peek()) {
					tempH = hStack.pop();
					tempPos = posStack.pop();
					area = Math.max(area, (i-tempPos)*tempH);
				}
				hStack.push(currentHeight);
				posStack.push(tempPos);
			}
		}
		while(!hStack.isEmpty()) {
			tempH = hStack.pop();
			tempPos = posStack.pop();
			area = Math.max(area, (h.length-tempPos)*tempH);
		}
		return area;
	}
	
	public static void main(String[] args) {
		int height[]={4 ,1000, 1000, 1000, 1000};
		int height2[] = {1,1,1,1,1,1,1,1,4,5,6,2,2};
		int hist[] = {7, 2, 1, 4, 5, 1, 3, 3};
		findLargestRectangularArea(height);
		System.out.println(findLargestRectangle(height));
		findLargestRectangularArea(height2);
		System.out.println(findLargestRectangle(height2));
		findLargestRectangularArea(hist);
		System.out.println(findLargestRectangle(hist));
		
	}

}
