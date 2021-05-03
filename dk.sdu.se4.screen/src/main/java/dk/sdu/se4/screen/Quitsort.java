/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.screen;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.SpritePart;
import java.util.List;

/**
 *
 * @author Steffen
 * @author Kasper
 */
public class Quitsort {
    
    
    
public void quickSort(List<Entity> arr, int begin, int end) {
    if (begin < end) {
        int partitionIndex = partition(arr, begin, end);

        quickSort(arr, begin, partitionIndex-1);
        quickSort(arr, partitionIndex+1, end);
    }
}

private int partition(List<Entity> arr, int begin, int end) {
    SpritePart sp = arr.get(end).getPart(SpritePart.class);
    int pivot = sp.getLayer();
    int i = (begin-1);
    for (int j = begin; j < end; j++) {
        SpritePart sp1 = arr.get(j).getPart(SpritePart.class);
        if (sp1.getLayer() <= pivot) {
            i++;
            Entity swapEntity = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, swapEntity);
        }
    }
    Entity swapTemp = arr.get(i+1);
    arr.set(i+1, arr.get(end));
    arr.set(end,swapTemp);
    return i+1;
}
}
