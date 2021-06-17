package java_core_for_android.lesson11_generic.fruits;

/*@author Artiom Ponomariov*/
public abstract class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}
