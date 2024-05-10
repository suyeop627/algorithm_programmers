import java.util.Arrays;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        int arr1Length = getLength(arr1);
        int arr2Length = getLength(arr2);
        if(arr1Length!=arr2Length){
            answer = compare(arr1Length, arr2Length);
        }else{
            int arr1Sum = getSumOfAllElement(arr1);
            int arr2Sum = getSumOfAllElement(arr2);
            if(arr1Sum==arr2Sum){
                answer = 0;
            }else{
                answer = compare(arr1Sum, arr2Sum);
            }
        }
        return answer;
    }
    
    private int getLength(int[] arr){
        return arr.length;
    }
    private int getSumOfAllElement(int[] arr){
        return Arrays.stream(arr).sum();
    }
    private int compare(int arr1, int arr2){
        return arr1 > arr2? 1 : -1;
    }
}