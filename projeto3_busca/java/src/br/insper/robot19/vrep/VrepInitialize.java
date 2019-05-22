package br.insper.robot19.vrep;

import br.insper.robot19.*;

public class VrepInitialize {

    public  static void main(String args[]){
        VrepSimulator sim = VrepSimulator.getInstance();
        VrepWorld world = sim.createWorld();
        VrepRobot robot = sim.createRobot();

        //robot.execute(RobotAction.DOWN, 2.00f);
        float cellSize = 0.5f;


        GridMap map = world.buildMap(cellSize);

        int[] rowColIni = map.getStart();
        int[] rowColFim = map.getGoal();
        Block inicial = new Block(rowColIni[0], rowColIni[1], BlockType.FREE) ;
        Block alvo = new Block(rowColFim[0], rowColFim[1], BlockType.FREE) ;
        BuscaA busca = new BuscaA(map, inicial, alvo);
        RobotAction[] solucao = busca.resolver();
        for(RobotAction ac : solucao) {
            robot.execute(ac, 5.00f);}
        }

    }




