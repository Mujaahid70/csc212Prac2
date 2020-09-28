/*
Created by Mujaahid Abrahams, Student number 3950547,
class that contains the method used to traverse a given graph, using the algorithms Breath First Search and Depth First Search,
with in the methods BFS and DFS respectively.
It also contains method DSFUntil as a helper method to DFS.
 */
import java.util.*;

public class Search{


    public ArrayList<Integer> BFS(int s, int size){
        /*
        This method takes in parameters s (index of starting point of traversal) and size (size of a given graph)
         */
        boolean[] visted = new boolean[size];//visited is a boolean array that will be used to mark vertices if visited (then true) or not visited(then false)
        ArrayList<Integer> traversalPath = new ArrayList<>();
        LinkedList<Integer> que = new LinkedList<>();//create a que, to keep track of what values need to be checked.

        visted[s] = true;
        que.add(s);

        while(que.size()!=0){
            s=que.poll();
            traversalPath.add(s);

            for(int i=s;i<size-1;i++){//for loop is used to get the index of all adjacent vertices
                int n=i+1;
                if(!visted[n]){//if vertex has not been visited then mark as visited and add to que
                    visted[n] = true;
                    que.add(n);
                }
            }
        }
        return traversalPath;
    }

    public ArrayList<Integer> DFS(int s,int size){
         /*
        This method takes in parameters s (index of starting point of traversal) and size (size of a given graph)
         */
        boolean visted[] = new boolean[size];//visited is a boolean array that will be used to mark vertices if visited (then true) or not visited(then false)
        ArrayList<Integer> traversalPath = new ArrayList<>();
        DFSUntil(s,visted,traversalPath,size);
        return traversalPath;


    }

    public void DFSUntil(int v, boolean visted[], ArrayList<Integer> traversalPath,int size){
        /*
        This method is a helper method to DFS that takes in parameters of, v (index of starting point),
        visted (boolean array used to keep track of what vertices has been visted or not),
       traversalPath (and array used to hold the vertices in order of traversal),
       size (size of a given graph).
         */
        visted[v] = true;
        traversalPath.add(v);
        for (int i = v; i < size-1; i++) {//for loop is used to get the index of all adjacent vertices
            int n = i + 1;
            if (!visted[n]) {//if vertex has not been visited then recur method until all adjacent vertices have been visited
                DFSUntil(n, visted, traversalPath,size);
            }
        }
    }

}