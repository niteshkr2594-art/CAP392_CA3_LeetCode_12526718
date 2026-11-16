import java.util.*;

class NumberContainers {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, TreeSet<Integer>> list = new HashMap<>();

    public NumberContainers() {
    }

    public void change(int index, int number) {
        if(map.containsKey(index)){
            int old = map.get(index);
            list.get(old).remove(index);
        }
        map.put(index, number);

        if(!list.containsKey(number)){
            list.put(number, new TreeSet<>());
        }
        list.get(number).add(index);
    }

    public int find(int number){
        if(!list.containsKey(number) || list.get(number).isEmpty()){
            return -1;
        }
        return list.get(number).first();
    }
}
