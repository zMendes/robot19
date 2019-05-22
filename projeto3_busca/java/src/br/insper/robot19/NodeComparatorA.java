package br.insper.robot19;

import java.util.Comparator;

public class NodeComparatorA implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        if (o1.getTot() < o2.getTot()){
            return -1;
        }
        if (o1.getTot()> o2.getTot()){
            return 1;
        }
        else{return 0;}
    }
}
