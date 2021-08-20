package java_core_for_android.lesson10_collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*@author Artiom Ponomariov*/
public class Phonebook {
    Map<String, ArrayList<String>> phones = new HashMap<>();

    public void add(String name, String phoneaNumber) {
        ArrayList<String> arrayList;
        if (phones.containsKey(name)) {
            arrayList = phones.get(name);
        } else {
            arrayList = new ArrayList<>();
        }

        if (!arrayList.contains(phoneaNumber)) {
            arrayList.add(phoneaNumber);
            phones.put(name, arrayList);
        }
    }


    public String get(String name) {
        ArrayList<String> arrayList;
        if (phones.containsKey(name)) {
            arrayList = phones.get(name);
        } else {
            return "Абонента " + name + " в списке нет!";
        }

        Iterator<String> iterator = arrayList.iterator();
        StringBuilder stringBuilder = new StringBuilder(name + ": ");
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next());
            if(iterator.hasNext()){
                stringBuilder.append(", ");
            } else {
                stringBuilder.append(".");
            }
        }
        return stringBuilder.toString();
    }
}
