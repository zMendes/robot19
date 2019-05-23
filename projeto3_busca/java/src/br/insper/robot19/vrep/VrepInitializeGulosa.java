package br.insper.robot19.vrep;

import br.insper.robot19.*;

public class VrepInitializeGulosa {
    public  static void main(String args[]){
        VrepSimulator sim = VrepSimulator.getInstance();
        VrepWorld world = sim.createWorld();
        VrepRobot robot = sim.createRobot();

        //robot.execute(RobotAction.DOWN, 1.00f);
        float cellSize = 0.5f;


        GridMap map = world.buildMap(cellSize);

        GraficoMap m = new GraficoMap(map);

        m.desenha();

        int[] rowColIni = map.getStart();
        int[] rowColFim = map.getGoal();
        Block inicial = new Block(rowColIni[0], rowColIni[1], BlockType.FREE) ;
        Block alvo = new Block(rowColFim[0], rowColFim[1], BlockType.FREE) ;
        BuscaGulosa busca = new BuscaGulosa(map, inicial, alvo);
        RobotAction[] solucao = busca.resolver();
        for(RobotAction action : solucao) {
            robot.execute(action, cellSize);}

    }

}
