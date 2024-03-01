import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FindThirdMax {

	public static void main(String[] args) {
//		Integer[] arrayOfIntegers = { 7, 20, 18, 4, 20, 19, 20, 3 };

		int size = 100000000;
		ArrayList<Integer> arrayOfIntegers = generateRandomArray(size);

		System.out.println("Input Data : " + size);

		// algorithm1
		System.out.println("\n*********** algorithm1 *************");
		long startNanoTime = System.nanoTime();
		long startMilliTime = System.currentTimeMillis();
		int thirdMax = algorithm1(arrayOfIntegers);
		long endNanoTime = System.nanoTime();
		long endMilliTime = System.currentTimeMillis();
		System.out.println("algorithm1 Nano Time = " + (endNanoTime - startNanoTime));
		System.out.println("algorithm1 Milli Time = " + (endMilliTime - startMilliTime));
		System.out.println("algorithm1 Third Max = " + thirdMax);

		// algorithm2
		System.out.println("\n*********** algorithm2 *************");
		startNanoTime = System.nanoTime();
		startMilliTime = System.currentTimeMillis();
		thirdMax = algorithm2(arrayOfIntegers);
		endNanoTime = System.nanoTime();
		endMilliTime = System.currentTimeMillis();
		System.out.println("algorithm2 Nano Time = " + (endNanoTime - startNanoTime));
		System.out.println("algorithm2 Milli Time = " + (endMilliTime - startMilliTime));
		System.out.println("algorithm2 Third Max = " + thirdMax);

	}

	private static ArrayList<Integer> generateRandomArray(int size) {
		ArrayList<Integer> randomArrayOfIntegers = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			randomArrayOfIntegers.add(random.nextInt(size));
		}
		return randomArrayOfIntegers;
	}

	private static int algorithm1(List<Integer> arrayOfIntegers) {

		int firstMax;
		int secondMax;
		int thirdMax;
		firstMax = secondMax = thirdMax = arrayOfIntegers.get(0);
		int indexOfFirstMax;
		int indexOfSecondMax;
		indexOfFirstMax = indexOfSecondMax = -1;

		for (int i = 0; i < arrayOfIntegers.size(); i++) {
			if (arrayOfIntegers.get(i) > firstMax) {
				firstMax = arrayOfIntegers.get(i);
				indexOfFirstMax = i;
			}
		}

		for (int i = 0; i < arrayOfIntegers.size(); i++) {
			if (i != indexOfFirstMax && arrayOfIntegers.get(i) > secondMax) {
				secondMax = arrayOfIntegers.get(i);
				indexOfSecondMax = i;
			}
		}

		for (int i = 0; i < arrayOfIntegers.size(); i++) {
			if (i != indexOfFirstMax && i != indexOfSecondMax && arrayOfIntegers.get(i) > thirdMax) {
				thirdMax = arrayOfIntegers.get(i);
			}
		}

		return thirdMax;
	}

	private static int algorithm2(List<Integer> arrayOfIntegers) {

		int max;
		int preMax;
		int prePreMax;
		max = preMax = prePreMax = arrayOfIntegers.get(0);
		int indexOfFirstMax;
		int indexOfSecondMax;
		indexOfFirstMax = indexOfSecondMax = -1;

		for (int i = 0; i < arrayOfIntegers.size(); i++) {
			if (arrayOfIntegers.get(i) > max) {
				preMax = max;
				max = arrayOfIntegers.get(i);
				indexOfFirstMax = i;
			}

			if (i != indexOfFirstMax && arrayOfIntegers.get(i) > preMax) {
				prePreMax = preMax;
				preMax = arrayOfIntegers.get(i);
				indexOfSecondMax = i;
			}

			if (i != indexOfFirstMax && i != indexOfSecondMax && arrayOfIntegers.get(i) > prePreMax) {
				prePreMax = arrayOfIntegers.get(i);
			}
		}

		return prePreMax;
	}

}
