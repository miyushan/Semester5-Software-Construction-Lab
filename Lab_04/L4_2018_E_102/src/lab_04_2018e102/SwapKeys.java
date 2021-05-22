package lab_04_2018e102;

import java.util.HashMap;
import java.util.Map;


/**
 * Author:  2018/E/102
 * This programme is used to swap keys and values in a map function
 */
public class SwapKeys {
    public static void main(String[] args) {

        Map<String,String> firstMap = new HashMap<>(); //declare a map
        //add elements to the map
        firstMap.put("shakeer","miyushan");
        firstMap.put("nadeesha","damsara");
        firstMap.put("dineth","damsara");
        firstMap.put("isuru","akalanka");

        System.out.println("\tBefore swap:");
        print(firstMap);   //print initial map

        swap(firstMap);     //call to swap

    }


    /**
     * This method is used to swap key and values in each elements of the initial map
     * @param secondMap
     */
    public static void swap(Map<String,String> secondMap){
        Map<String,String> newMap = new HashMap<>();       //new Map for changed Map

        System.out.println("\n\tAfter swap:");
        secondMap.forEach((key, value) -> {     //arrowfunction to check each element's value and key
            if(newMap.containsKey(value)){
                try{
                    throw new Exception("Duplicated key and Values");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            else {
                newMap.put(value,key);  //store swapped data into new map
            }
        });
        print(newMap);  //print new map

    }


    /**
     * This method is used to print map elements
     * @param names
     */
    static void print(Map<String,String> names){
        for (Map.Entry pairEntry: names.entrySet()){
            System.out.println(pairEntry.getKey()+" : "+pairEntry.getValue());
        }
    }

}
