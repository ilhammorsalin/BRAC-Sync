import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class util_ArrayList {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Ilham");
        arr.add("Mansib");
        arr.add("Sami");
        System.out.println(arr);

        arr.add(1, "Sharar");
        System.out.println(arr);

        arr.remove("Ilham");
        System.out.println(arr);

        arr.remove(0);
        System.out.println(arr);

        arr.set(0, "Esan");
        System.out.println(arr);

        System.out.println(arr.size());
        System.out.println(arr.get(1));

        ArrayList<Integer> num = new ArrayList<>();

        num.add(9);
        num.add(1);
        num.add(2);
        num.add(5);

        System.out.println(num);
        Collections.sort(num);
        System.out.println(num);
    }

    public static void dupeRemove(ArrayList al){
        for(int i=0; i<al.size(); i++){
            for(int j=i+1; j<al.size(); j++){
                if(Objects.equals(al.get(i), al.get(j))){
                    al.remove(j);
                    j--;
                }
            }
        }
    }
}
