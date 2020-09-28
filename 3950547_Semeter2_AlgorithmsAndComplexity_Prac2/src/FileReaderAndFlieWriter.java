import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class FileReaderAndFlieWriter {

    public ArrayList<school> sch = new ArrayList<>();

    public void ReadInVal() {
        /*
        Reads in the data from the csv file into the school array
         */
        BufferedReader buff = null;
        try{
            buff = new BufferedReader(new FileReader("Soweto.csv"));
            String info ;
            while((info =buff.readLine())!=null){
                String[] arr = info.split(";");
                if(!arr[3].equalsIgnoreCase("rating")) {
                    if (Float.parseFloat(arr[3]) == 5.0) {
                        school s = new school(arr[0], arr[1], arr[2], arr[3]);
                        sch.add(s);
                    }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createFile(HashSet<Graph.vertex> nodes){
        /*
        Creates and writes, txt file, named Output
         */

        Sort sort = new Sort();
        Search search = new Search();



        FileWriter write = null;
        try {
            write = new FileWriter("Output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter print = new PrintWriter(write);
        print.print("Values [");
        for(Graph.vertex v:nodes) {
            print.print( v.getSchoolName()+",");
        }
        print.print("]");
        print.print("\n");

        sort.mergeSort(sch);

        print.print("Sorted [");
        for(int i=0;i<sch.size();i++) {
            if(i==sch.size()-1) {
                print.print(sch.get(i).schoolName );
            }
            else{
                print.print(sch.get(i).schoolName+", ");
            }
        }
        print.print("]\n");
        print.print("\n");

        print.print("Following the Depth First Traversal of a Graph only contain schools with a rating of 5");
        print.print("\n"+search.DFS(0,nodes.size()));
        print.print("\n");

        print.print("\nFollowing is the Breath First Traversal of a Graph only contain schools with a rating of 5(starting from vertex 0)");
        print.print("\n"+search.BFS(0,nodes.size()));
        print.close();
    }

}
