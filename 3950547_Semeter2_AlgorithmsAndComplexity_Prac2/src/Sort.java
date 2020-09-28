import java.util.ArrayList;

public class Sort {

    public ArrayList<school> school = new ArrayList<>();

    public void mergeSort(ArrayList<school> arr){
        /*
        Sorts data within the array in the array alphabetically using merge sort
         */
        int center = arr.size()/2;
        ArrayList<school> left = new ArrayList<school>();
        ArrayList<school> right = new ArrayList<school>();
        ArrayList<school> sorted = new ArrayList<>();
        if(arr.size()==1){
            return;
        }
        for(int i = 0;i<center;i++){
            left.add(arr.get(i));
        }
        for(int i=center;i<arr.size();i++){
            right.add(arr.get(i));
        }
        mergeSort(left);
        mergeSort(right);
        sorted = merge(left,right,arr);
        school = sorted;

    }

    public ArrayList<school> merge(ArrayList<school> left, ArrayList<school> right, ArrayList<school> arr){
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).schoolName.compareTo(right.get(rightIndex).schoolName)) < 0) {
                arr.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                arr.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList<school> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i=restIndex; i<rest.size(); i++) {
            arr.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
        return arr;
    }


}
