import java.util.Queue;
import java.util.LinkedList;

public class adjList{

    public static void main(String[] args) {
        adjList g = new adjList(5);
        g.insert(0,1);
        g.insert(0,2);
        g.insert(0,3);
        g.insert(0,3);

        g.display();
    }

    edge[] arr;

    class edge{
        int src, dst;
        edge next;

        edge(int src, int dst){
            this.src = src;
            this.dst = dst;
            this.next = null;
        }
    }

    void display(){
        for(int i=0; i<arr.length; i++){
            System.out.print(i + ": ");
            while(arr[i]!=null){
                System.out.print(arr[i].dst + ", ");
                arr[i] = arr[i].next;
            }
            System.out.println();
        }
    }

    adjList(int size){
        arr = new edge[size];
        for(int i=0; i<arr.length; i++){
            arr[i]=null;
        }
    }
    
    void insert(int src, int dst){
        if(exist(arr[src], dst)){
            return;
        }        
        
        edge s = new edge(src, dst);
        s.next = arr[src];
        arr[src] = s;
        
        edge d = new edge(dst, src);
        d.next = arr[dst];
        arr[dst] = d;
    }

    boolean exist(edge head, int dst){
        while(head != null){
            if(head.dst == dst){
                return true;
            }
            head = head.next;
        }
        return false;
    }


}