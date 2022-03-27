package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public String[] stringArray;
    public StringDuplicateDeleter(String[] stringArray) {
        super(stringArray);
        this.stringArray = Arrays.copyOf(stringArray,stringArray.length);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] stringArray = Arrays.copyOf(super.array,super.array.length);
        for(int x =0;x<stringArray.length;x++){
            Integer occ = getNumberOfOccurrences(stringArray,stringArray[x]);
            if(occ >= maxNumberOfDuplications){
                stringArray = removeValue(stringArray,stringArray[x]);
                x--;
            }
        }
        String[] stringArray2 = Arrays.copyOf(stringArray,stringArray.length);
        return stringArray2;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] stringArray = Arrays.copyOf(super.array,super.array.length);
        for(int x =0;x<stringArray.length;x++){
            Integer occ = getNumberOfOccurrences(stringArray,stringArray[x]);
            if(occ == exactNumberOfDuplications){
                stringArray = removeValue(stringArray,stringArray[x]);
                x--;
            }

        }
        String[] stringArray2 =  Arrays.copyOf(stringArray,stringArray.length);
        return stringArray2;
    }

    public static Integer getNumberOfOccurrences(Object[] objectArray, Object objectToCount) {
        int count = 0;
        for(Object s:objectArray){
            if(s.equals(objectToCount)){
                count++;
            }
        }
        return count;
    }

    public static String[] removeValue(Object[] objectArray, Object objectToRemove) {

        int count = getNumberOfOccurrences(objectArray, objectToRemove);
        int newArrayLength = objectArray.length - count;
        Object[] newArray = new Object[newArrayLength];
        int x = 0;
        for (int i = 0; i < objectArray.length; i++) {
            if (!(objectArray[i].equals(objectToRemove))) {
                newArray[x] = objectArray[i];
                x++;
            }
        }
        String[] integerArray = Arrays.copyOf(newArray, newArray.length, String[].class);
        return integerArray;
    }

}
