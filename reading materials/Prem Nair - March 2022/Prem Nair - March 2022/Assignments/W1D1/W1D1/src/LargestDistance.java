import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class LargestDistance {

	public static void main(String[] args) {
		int size = 1000000;
		ArrayList<Integer> arrayOfIntegers = generateRandomArray(size);

		System.out.println("Input Data : " + size);
		
		// algorithm1
		System.out.println("\n*********** algorithm1 *************");
		long startNanoTime = System.nanoTime();
		long startMilliTime = System.currentTimeMillis();
		int largestDistance = algorithm1(arrayOfIntegers);
		long endNanoTime = System.nanoTime();
		long endMilliTime = System.currentTimeMillis();
		System.out.println("algorithm1 Nano Time = " + (endNanoTime - startNanoTime));
		System.out.println("algorithm1 Milli Time = " + (endMilliTime - startMilliTime));
		System.out.println("algorithm1 Largest Distance = " + largestDistance);

		// algorithm2
		System.out.println("\n*********** algorithm2 *************");
		startNanoTime = System.nanoTime();
		startMilliTime = System.currentTimeMillis();
		largestDistance = algorithm2(arrayOfIntegers);
		endNanoTime = System.nanoTime();
		endMilliTime = System.currentTimeMillis();
		System.out.println("algorithm2 Nano Time = " + (endNanoTime - startNanoTime));
		System.out.println("algorithm2 Milli Time = " + (endMilliTime - startMilliTime));
		System.out.println("algorithm2 Largest Distance = " + largestDistance);

		// algorithm3
		System.out.println("\n*********** algorithm3 *************");
		startNanoTime = System.nanoTime();
		startMilliTime = System.currentTimeMillis();
		largestDistance = algorithm3(arrayOfIntegers);
		endNanoTime = System.nanoTime();
		endMilliTime = System.currentTimeMillis();
		System.out.println("algorithm3 Nano Time = " + (endNanoTime - startNanoTime));
		System.out.println("algorithm3 Milli Time = " + (endMilliTime - startMilliTime));
		System.out.println("algorithm3 Largest Distance = " + largestDistance);

		// algorithm4
		System.out.println("\n*********** algorithm4 *************");
		startNanoTime = System.nanoTime();
		startMilliTime = System.currentTimeMillis();
		largestDistance = algorithm4(arrayOfIntegers);
		endNanoTime = System.nanoTime();
		endMilliTime = System.currentTimeMillis();
		System.out.println("algorithm4 Nano Time = " + (endNanoTime - startNanoTime));
		System.out.println("algorithm4 Milli Time = " + (endMilliTime - startMilliTime));
		System.out.println("algorithm4 Largest Distance = " + largestDistance);
	}

	private static ArrayList<Integer> generateRandomArray(int size) {
		ArrayList<Integer> randomArrayOfIntegers = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			randomArrayOfIntegers.add(random.nextInt(size));
		}
		return randomArrayOfIntegers;
	}

	private static int algorithm1(ArrayList<Integer> arrayOfIntegers) {
		ArrayList<Integer> arrayOfEvenIntegers = new ArrayList<>();
		for (int i = 0; i < arrayOfIntegers.size(); i++) {
			if (arrayOfIntegers.get(i) % 2 == 0) {
				arrayOfEvenIntegers.add(arrayOfIntegers.get(i));
			}
		}
		return arrayOfEvenIntegers.size() - 1;
	}

	private static int algorithm2(ArrayList<Integer> arrayOfIntegers) {
		int firstIndex = -1;
		int lastIndex = -1;
		for (int i = 0; i < arrayOfIntegers.size(); i++) {
			if (arrayOfIntegers.get(i) % 2 == 0) {
				if (firstIndex < 0) {
					firstIndex = i;
				}
				for (int j = firstIndex; j < arrayOfIntegers.size(); j++) {
					if (arrayOfIntegers.get(j) % 2 == 0) {
						lastIndex = j;
					}
				}
			}
		}
		return lastIndex - firstIndex;
	}

	private static int algorithm3(ArrayList<Integer> arrayOfIntegers) {
		int maxEvenIndex = -1;
		int minEvenIndex = -1;
		for (int i = 0; i < arrayOfIntegers.size(); i++) {
			if (arrayOfIntegers.get(i) % 2 == 0) {
				if (maxEvenIndex == -1 && minEvenIndex == -1) {
					maxEvenIndex = minEvenIndex = i;
				}
				if (arrayOfIntegers.get(i) > arrayOfIntegers.get(maxEvenIndex)) {
					maxEvenIndex = i;
				}
				if (arrayOfIntegers.get(i) < arrayOfIntegers.get(minEvenIndex)) {
					minEvenIndex = i;
				}
			}
		}
		return Math.abs(maxEvenIndex - minEvenIndex);
	}

	private static int algorithm4(ArrayList<Integer> arrayOfIntegers) {
		int maxEven = arrayOfIntegers.stream().filter(i -> i % 2 == 0).max(Comparator.comparing(Integer::valueOf)).get();
		int maxEvenIndex = arrayOfIntegers.indexOf(maxEven);
		System.out.println("maxEven = " + maxEven);
		int minEven = arrayOfIntegers.stream().filter(i -> i % 2 == 0).min(Comparator.comparing(Integer::valueOf)).get();
		int minEvenIndex = arrayOfIntegers.indexOf(minEven);
		System.out.println("minEven = " + minEven);
		return Math.abs(maxEvenIndex - minEvenIndex); 
	}
}
