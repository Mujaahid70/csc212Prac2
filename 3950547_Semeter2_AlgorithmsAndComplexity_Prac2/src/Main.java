import java.util.*;

public class Main {


    public static void main(String[] args) {

        Graph graph = new Graph();
        FileReaderAndFlieWriter school= new FileReaderAndFlieWriter();
        Search search = new Search();
        ArrayList<school> temp;

        school.ReadInVal();
        temp = school.sch;
        Graph.vertex vert1 = new Graph.vertex(school.sch.get(0));
        graph.addVert(vert1);
       for(int i=1;i<temp.size();i++){
           Graph.vertex vert = new Graph.vertex(school.sch.get(i));
           graph.addVert(vert);
           graph.addEdge(vert1,vert);
           vert1 = vert;
       }

       school.createFile(graph.nodes);

    }
}
