/*
Created by Mujaahid Abrahams, Student number 3950547,
Class that constructs a graph. It contains 2 constructor classes, vertex and Edge.
As well as the public data-structure - HashSet of type school to store the values of the vertex and Edge.
It also contains the following methods:
void Graph()
boolean addEgde(vertex v1, vertex v2)
boolean addVert(vertex v)
 */
import java.util.*;

public class Graph{



    public static class vertex{
        /*
        This class is a constructor for the object vertex, that sets a school as a vertex.
        It consists of variables:
        school sch
        LinkedList<Edge> list
        And methods:
        vertex(school name)
        String getSchoolName()
        LinkedList<Edge> getEdges()
         */
        private school sch;
        private LinkedList<Edge> list;

        public vertex(school name){
            /*
            This method initializes values for attributes in the class vertex
             */
            this.sch = name;
            list = new LinkedList<>();
        }

        public String getSchoolName(){
            /*
            returns the name of the school of the vertex
             */
            return sch.schoolName;
        }

        public LinkedList<Edge> getEdges(){
            /*
            returns the Edges connected to the vertex
             */
            return list;
        }
    }

    class Edge{
        /*
        Constructor class for the object Edge, that sets a vertex as an edge.
        It consists of variable: vertex dvert (or destination vertex)
        And contains method: Edge(vertex dest)
         */
        private vertex dvert;

        public Edge(vertex dest){
            /*
            initializes values for the attributes within Edge
             */
            this.dvert = dest;
        }

    }

    public HashSet<vertex> nodes;

    public Graph(){
        /*
        initializes variable nodes
         */
        nodes = new HashSet<>();
    }

    public boolean addEdge(vertex v1,vertex v2){
        /*
        This method add an Edge to the variable node between two vertices.
         */
        nodes.add(v2);
        return v1.getEdges().add(new Edge(v2));
    }

    public  boolean addVert(vertex v){
        /*
        This method adds' a vertex with the graph
         */
        nodes.add(v);
        return nodes.add(v);

    }

}
