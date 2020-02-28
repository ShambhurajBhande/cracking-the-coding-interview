package ctci.treeandgraph;/* @author Shambhuraj created on 2/20/2020*/

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph<T> {
    public ArrayList<LinkedList<T>> nodes;

    Graph(){
        nodes=new ArrayList<>();
    }
    public void addChildren(int index,T data){
        LinkedList linkedList;
        if (index<nodes.size()) {
              linkedList = nodes.get(index);
        }else{
            linkedList=new LinkedList();
        }
        linkedList.add(data);
        nodes.add(linkedList);
    }

    public LinkedList getNodes(int index){
        return nodes.get(index);
    }
    public ArrayList getGraph(){
        return nodes;
    }

}



