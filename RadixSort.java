
public class RadixSort {
	static void radixSort(int[] arr) {
		// finding the maximum element in the array
		  int max = arr[0];
		  for (int i = 1; i < arr.length; i++) {
		    if (max < arr[i])
		      max = arr[i];
		  }
             // getting the  place value of every digit starting with 1s , thats why pos is = 1;
		  // we get the place value of next digit by multiplying the current place value by 10 hence pos *=10;
		  // pos is position of every digit
		  for (int pos = 1; max / pos > 0; pos = pos * 10)
		    countingSortForRadix(arr, pos);
		}
	       //   the counting sort algorithm for Radix sort
	static void countingSortForRadix(int[] arr, int pos) {
		// creating a count array  which is first initialized to zeros
		  int countingArray[] = new int[10];
		  for(int i = 0; i < countingArray.length;i++) {
			  countingArray[i] = 0;
		  }
		  // getting the count of every digit in an integer/number
		  for (int i = 0; i < arr.length; i++)
		    countingArray[(arr[i] / pos) % 10]++;
         // calculating the cumulative sum of every digit in in integer/number
		  for (int i = 1; i < 10; i++)
		    countingArray[i] += countingArray[i - 1];

		  int[] outputArray = new int[10];
		  for(int i = 0 ; i < arr.length; i++) {
			  outputArray[i] = 0;
		  }
		  for (int i = arr.length - 1; i >= 0; i--)
		    outputArray[--countingArray[(arr[i] / pos) % 10]] = arr[i];
		

		  for (int i = 0; i < arr.length; i++)
		    arr[i] = outputArray[i];
		}
	public static void main(String[] args) {
		  int[] arr = {73,481,57,23,332,800,8,1000,754,125};

		  radixSort(arr);
		  for (int i = 0; i < arr.length; i++)
		    System.out.print(arr[i] + " ");
		}
}
