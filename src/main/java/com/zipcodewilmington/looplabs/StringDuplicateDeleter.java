package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public String[] intArray;
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
        this.intArray = Arrays.copyOf(intArray,intArray.length);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        for(int x =0;x<intArray.length;x++){
            Integer occ = getNumberOfOccurrences(intArray,intArray[x]);
            if(occ >= maxNumberOfDuplications){
                intArray = removeValue(intArray,intArray[x]);
                x--;
            }
        }
        super.array = Arrays.copyOf(intArray,intArray.length);
        return super.array;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        for(int x =0;x<intArray.length;x++){
            Integer occ = getNumberOfOccurrences(intArray,intArray[x]);
            if(occ == exactNumberOfDuplications){
                super.array = removeValue(intArray,intArray[x]);
                x--;
            }

        }
        super.array = Arrays.copyOf(intArray,intArray.length);
        return super.array;
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
