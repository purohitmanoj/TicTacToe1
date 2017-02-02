package com.game.entity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * User: Manoj Purohit
 * Purpose of it is to ...
 */
public class MachinePlayer implements Player {

    private  Set<Move> computerMoves = new HashSet<Move>();
    private  Set<Move> allPossibleMoves = new HashSet<Move>();

    public MachinePlayer(){
        super();
        for(int i = 0; i < 3; i++){
            for(int j= 0;j<3 ; j++) {
                allPossibleMoves.add(new Move(i, j));
            }
        }
    }

    @Override
    public Move getNextMove(Set<Move>  otherPlayersMoves) {
        Object[] objects = allPossibleMoves.toArray();
        Random random = new Random(hashCode());
        int Low = 1;
        int High = 10;
        boolean validMove = false;
        Move move = null;
        while (!validMove) {
            int result = random.nextInt(High - Low) + Low;

//            System.out.println("Randon Number generated : " + result);
            result = result - 1;
            Move object = (Move)objects[result];
            if (!computerMoves.contains(object) && !otherPlayersMoves.contains(object)) {

                move = object;

//                @TODO
                // Check in the loosing sequence it has been or not
                validMove = true;
            } else {
                System.out.println(object.toString() + "Move is not valid");
            }


        }


        return move;
    }

    @Override
    public void setPlayedMove(Move move) {
        computerMoves.add(move);
    }

    @Override
    public Set<Move> getPlayedMoves() {
        return computerMoves;
    }

    @Override
    public void  playerStatus() {
        StringBuilder sb = new StringBuilder("The player - ").append(getName()).append("-Status is as Follows");
        if (getPlayedMoves().isEmpty()) {
            sb.append("not played yet");
        } else {
            for (Move move : computerMoves) {
                sb.append(move.toString());
            }
        }
        System.out.println(sb.toString());
    }


    @Override
    public String getName() {
        return "Machine Player";
    }

}
