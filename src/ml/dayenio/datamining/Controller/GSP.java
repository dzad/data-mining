package ml.dayenio.datamining.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by @siemah on 28/02/2019.
 * @var minSupp Integer represent a minimum support
 * @var items Array[String] contain a bunch of items
 * @var itemsSupp HashMap is a list of key:value of Item:redundancy
 */
public class GSP {

    private int minSupp;
    private LinkedList<String> items;
    private HashMap<String, Integer> itemsSupp;

    public GSP(){}

    /**
     * constructor of GSP class
     * @param minSupp Integer minimum support
     * @param items String[] list of items
     */
    public GSP(int minSupp, LinkedList<String> items) {
        this.init(minSupp, items);
    }

    /**
     * assign some values to GSP vars
     * @param minSupp minimum support
     * @param items list of items
     * @return instance of this class GSP
     */
    public GSP init(int minSupp, LinkedList<String> items) {
        this.minSupp = minSupp;
        this.items = items;
        this.itemsSupp = new HashMap<>();
        this.items.forEach(s -> {
            this.itemsSupp.put(s, 0);
        });
        return this;
    }

    /**
     * calculate the redundancy of each item
     * @param itemsChains String represent a data items
     * @return HashMap key is item and value is number of redundancy
     */
    public GSP computeRedundancyIn (ArrayList<String> itemsChains) {
        for (String item:this.items) {
            itemsChains.forEach(itemsChain -> {
                int currentSupp;
                if( itemsChain.contains(item)) {
                    currentSupp = this.itemsSupp.get(item);
                    this.itemsSupp.put(item, currentSupp+1);
                }
            });
        }
        return this;
    }

    /**
     * delete all items has a redundancy value less than minimum support
     * @return  GSP instance (fluent pattern)
     */
    public GSP removeItemsLessThanMinSupp () {
        LinkedList<String> itemsToRemove = new LinkedList();
        this.itemsSupp.forEach((s, integer) -> {
            if(integer < this.minSupp) itemsToRemove.add(s);
        });
        itemsToRemove.forEach(s -> this.itemsSupp.remove(s));
        return this;
    }

    /**
     * calculate cartesian product of items has
     * minSupp(minimum support greater than minSupp)
     * @return Array[String] result of cartesian product
     */
    public LinkedList<String> computeCartesianProduct() {
        LinkedList<String> result = new LinkedList<>();
        Set<String> items = this.itemsSupp.keySet();
        for (String currentItem1 : items) {
            for (String currentItem2 : items) {
                result.add(currentItem1+currentItem2);
            }
        }
        return result;
    }

    /**
     * set a minSupp (can use this method to clear a minSupp
     * by passing an empty "new" HashMap instance)
     * @param minSupp minimum support
     */
    public void setMinSupp (int minSupp) {
        this.minSupp = minSupp;
    }

    /**
     * getter of itemsSupp
     * @return
     */
    public HashMap<String, Integer> getItemsSupp(){
        return this.itemsSupp;
    }

}

@FunctionalInterface
interface Callback {
    String cb(String x, String y);
}