package br.insper.robot19;

import java.util.*;

public class BuscaA{
    private Block start = null;
    private Block end = null;
    private GridMap map = null;

    private Queue<Node> border;

    public BuscaA(GridMap map, Block start, Block end){
        this.map = map;
        this.start = start;
        this.end = end;
    }

    /**
     * Método que realiza a busca
     * @return
     */
    public Node buscar() {

        HashSet<Node> isAdded = new HashSet<>();
        Node root = new Node(start, null, null, 0);

        //Limpa a fronteira e insere o nó raiz

        Comparator<Node> comparator = new NodeComparatorA();
        border = new PriorityQueue<Node>(comparator);
        border.add(root);

        while(!border.isEmpty()) {

            Node node = border.remove();
            Block atual = node.getValue();

            if(atual.row == end.row && atual.col == end.col) {
                return node;

            } else for(RobotAction acao : RobotAction.values()) {

                Block proximo = map.nextBlock(atual, acao);

                if(proximo != null && proximo.type != BlockType.WALL) {
                    Node novoNode = new Node(proximo, node, acao, proximo.type.cost);
                    novoNode.setTot(tot(novoNode));
                    if (!isAdded.contains(novoNode)){
                        border.add(novoNode);
                        isAdded.add(novoNode);
                    }
                }
            }
        }
        return null;
    }





    public float heuristic(Node node){
        Block atual = node.getValue();
        int Hx =  Math.abs(- atual.col +  end.col);
        int Hy =  Math.abs(- atual.row + end.row);
        return Hx + Hy;
    }

    public float tot(Node node){
        return node.getPathCost() + heuristic(node);

    }
    /**
     * Resolve o problema com base em busca, realizando
     * o backtracking após chegar ao estado final
     *
     * @return A solução encontrada
     */
    public RobotAction[] resolver() {

        // Encontra a solução através da busca
        Node destino = buscar();
        if(destino == null) {
            return null;
        }

        //Faz o backtracking para recuperar o caminho percorrido
        Node atual = destino;
        Deque<RobotAction> caminho = new LinkedList<RobotAction>();
        while(atual.getAction() != null) {
            caminho.addFirst(atual.getAction());
            atual = atual.getParent();
        }
        return caminho.toArray(new RobotAction[caminho.size()]);
    }
}



