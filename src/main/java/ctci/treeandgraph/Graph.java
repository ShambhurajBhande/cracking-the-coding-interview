package ctci.treeandgraph;/* @author Shambhuraj created on 2/20/2020*/

import java.util.LinkedList;

public class Graph<T> {
    public LinkedList<T>[] nodes;

    Graph(int nodeCount){
        nodes=new LinkedList[nodeCount];
    }
    public void addChildren(int index,T data){
        LinkedList linkedList;
        if (nodes[index]!=null) {
              linkedList = nodes[index];
        }else{
            linkedList=new LinkedList();
        }
      //  LinkedList children=new LinkedList<T>();
       // children.add(data);
        linkedList.add(data);
        nodes[index]=linkedList;
    }

    public LinkedList getNodes(int index){
        return nodes[index];
    }

}



