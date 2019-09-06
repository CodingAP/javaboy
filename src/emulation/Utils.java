package emulation;

public class Utils {
	public static void printArray(int[] array) {
		Utils.printArray(array, 0, array.length);
	}
	
	public static void printArray(int[] array, int start) {
		Utils.printArray(array, start, array.length);
	}
	
	public static void printArray(int[] array, int start, int end) {
		System.out.print("[");
		for (int i = start; i < end; i++) {
			if (i == end - 1) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.print("]");
	}
	
	public static void printArray(String[] array) {
		Utils.printArray(array, 0, array.length);
	}
	
	public static void printArray(String[] array, int start) {
		Utils.printArray(array, start, array.length);
	}
	
	public static void printArray(String[] array, int start, int end) {
		System.out.print("[");
		for (int i = start; i < end; i++) {
			if (i == end - 1) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.print("]");
	}
	
	public static void printArrayAsHex(int[] array) {
		Utils.printArrayAsHex(array, 0, array.length);
	}
	
	public static void printArrayAsHex(int[] array, int start) {
		Utils.printArrayAsHex(array, start, array.length);
	}
	
	public static void printArrayAsHex(int[] array, int start, int end) {
		System.out.print("[");
		for (int i = start; i < end; i++) {
			if (i == end - 1) {
				System.out.print(Integer.toHexString(array[i]));
			} else {
				System.out.print(Integer.toHexString(array[i]) + ", ");
			}
		}
		System.out.print("]");
	}
	
	public static int covert8to16(int lsb, int msb) {
		return (msb << 8) | lsb;
	}
	
	public static String toHex(int value) {
		return Integer.toHexString(value);
	}
	
	public static String toBinary(int value) {
		return Integer.toBinaryString(value);
	}
}