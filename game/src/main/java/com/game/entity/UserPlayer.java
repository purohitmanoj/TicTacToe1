package com.game.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Manoj Purohit
 * Purpose of it is to ...
 */
public class UserPlayer implements Player {
    private Set<Move> userMoves = new HashSet<Move>();
    public static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String getName() {
        return "Human Player";
    }

    @Override
    public Move getNextMove(Set<Move> otherPlMoves) {
        System.out.println(" Human it is your turn please make a move in x,y format e.g. 0,0 for all valid moves see documentation");
        Move move = null;
        try {
            while (move == null) {
                String input = BR.readLine();
                move = getMoveFromInputString(input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return move;
    }

    @Override
    public void setPlayedMove(Move move) {
        userMoves.add(move);
    }

    private Move getMoveFromInputString(String input) {
        Move move = null;
        if ((input != null && !input.isEmpty())) {
            if (input.contains(",")) {
                String[] split = input.split(",");
                if (split.length == 2) {
                    try {
                        int x = Integer.parseInt(split[0]);
                        int y = Integer.parseInt(split[1]);

                        move = new Move(x, y);
                    } catch (NumberFormatException npe) {
                        System.out.println("Enter Valid Number");
                    }

                }
            }


        }
        if (move == null) {

            System.out.println(" Please make a valid move in x,y format ");
        }
        return move;
    }

    @Override
    public Set<Move> getPlayedMoves() {
        return userMoves;
    }

    @Override
    public void playerStatus() {
        StringBuilder sb = new StringBuilder("The player - ").append(getName()).append("-Status is as Follows");
        if (getPlayedMoves().isEmpty()) {
            sb.append("not played yet");
        } else {
            for (Move move : userMoves) {
                sb.append(move.toString());
            }
        }
        System.out.println(sb.toString());
    }

}
