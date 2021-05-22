package lab_04_2018e102;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Author:  2018/E/102
 * This programme is used to implement a treeMultiSet
 */
public class MultiSet<E>{

    //declare a private map
    private SortedMap<E,Integer> map = new TreeMap<E, Integer>();

    /**
     * This method is used to add details to the multiset
     * @param index
     */
    public void add(E index){
        if(contains(index)){
            map.replace(index, map.get(index)+1);
        }else{
            map.put(index, 1);
        }
        System.out.println(index + " is added to the Multiset");
    }


    /**
     * This method used to delete data from the multiset
     * @param index
     * @return
     */
    public boolean remove(E index){
        if(contains(index)){
            map.remove(index);  //remove index valued data
            int counter = count(index);
            map.put(index, counter-1);   //add next element to the deleted element's location
            return true;
        }else{
            return false;
        }
    }


    /**
     * This method is used to take the count
     * @param index
     * @return
     */
    public int count(E index) {
        return map.get(index);
    }


    /**
     * This method is used to check is the element contains i the map
     * @param index
     * @return
     */
    public boolean contains(E index){
        return map.containsKey(index);
    }


    /**
     * This method is used to delete all elements
     * @param index
     * @return
     */
    public boolean removeAllElements(E index){
        if(contains(index)){
            map.remove(index);
            return true;
        }else{
            return false;
        }
    }


    /**
     * This method is used to put data into an array
     * @param arr
     * @return
     */
    public E[] toArray(E[] arr){
        E[] obj = null;
        for( int i=0 ; arr.length>i ; i++){
            obj[i] = arr[i];
        }
        return obj;
    }


    public static void main(String[] args){

        MultiSet<String> multiset = new MultiSet();

        multiset.add("miyushan");
        multiset.add("nadeesha");
        multiset.add("sumesh");
        multiset.add("isuru");

        multiset.remove("nadesha");

        System.out.println("\n" + multiset);

    }
}

