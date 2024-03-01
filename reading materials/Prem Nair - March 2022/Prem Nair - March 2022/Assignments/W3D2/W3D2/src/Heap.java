
public class Heap {

	public static void main(String[] args) {
		
		int[] integersArray = {00,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		
		int[] topDownArray = integersArray;
		int comparisons = 0;
		for(int i = 1; i<topDownArray.length;i++) {
			for(int j = i; j>1 && topDownArray[j/2] < topDownArray[j]; j=j/2) {
				topDownArray[j/2] = topDownArray[j/2] + topDownArray[j];
				topDownArray[j] = topDownArray[j/2] - topDownArray[j];
				topDownArray[j/2] = topDownArray[j/2] - topDownArray[j];
				comparisons++;
			}
		}
		
		for(int i = 1; i<integersArray.length;i++) {
			System.out.println(integersArray[i]);
		}
		System.out.println("comparisons = " + comparisons);
		
		
		
		
		
		
//		int[] bottomUpArray = integersArray;
//		
//		comparisons = 0;
//		
//		for(int i = topDownArray.length/2; i>=1;i--) {
//			for(int j = i; j>1 && topDownArray[j/2] < topDownArray[j]; j=j/2) {
//				
//			}
//		}
		
		
		
		
	}

}
