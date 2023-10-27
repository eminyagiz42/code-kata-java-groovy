package practice;

public class RemoveLastZeroArr {

    public static void main(String[] args) {
        int [] arr = {1, 7, 8, 9, 10, 12, -1, 6, 5, 4, 3, 11, 0, 0};

        int [] newArr = removeLastZeros(arr);
        //output:  int [] arr = {1, 7, 8, 9, 10, 12, -1, 6, 5, 4, 3, 11};
        for (int num : newArr) {
            System.out.println("num = " + num);
        }
    }

    private static int[] removeLastZeros(int[] arr) {
        int firstLastIndex = 0;
        for (int k = arr.length-1; k > 0; k--) {
            if(arr[k] != 0 ){
                firstLastIndex = k;
                break;
            }
        }
        int index = 0;
        int[] newArr = new int[firstLastIndex + 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[index++] = arr[i];
        }
        return newArr;
    }
}
