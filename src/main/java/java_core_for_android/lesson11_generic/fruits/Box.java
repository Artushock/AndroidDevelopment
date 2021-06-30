package java_core_for_android.lesson11_generic.fruits;

import java.util.ArrayList;
import java.util.Arrays;

/*@author Artiom Ponomariov*/
public class Box<T extends Fruit>{
    private ArrayList<T> fruitList = new ArrayList<>();

    @SafeVarargs
    public Box(T... fruits) {
        fruitList.addAll(Arrays.asList(fruits));
    }

    public void addFruit(T f){
        fruitList.add(f);
    }

    public void pourAppleTo(Box<T> box){
        for (T t : fruitList){
            box.addFruit(t);
        }
        fruitList = new ArrayList<>();
    }

    public float getWeight(){
        float w = 0;
        for (Fruit f: fruitList){
            w += f.getWeight();
        }
        return w;
    }

    public boolean compare(Box<?> box){
        return this.getWeight() == box.getWeight();
    }
}
