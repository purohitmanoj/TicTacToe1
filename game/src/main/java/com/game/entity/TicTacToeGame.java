package com.game.entity;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * User: Manoj Purohit
 * Purpose of it is to ...
 * Internal game representation
 * (0,0) (1,0) (2,0)
 (0,1) (1,1) (2,1)
 (0,2) (1,2) (2,2)
 */
@Component
public class TicTacToeGame {

    Player player2 = null;
    Player player1 = null;


    public void startGame() {
        System.out.println(" The new Game Starts .. Drum Rolls");
        // Who wins the Toss
        if (isMachineWonTheToss()) {
            player1 = new MachinePlayer();
            player2 = new UserPlayer();
            System.out.println(" Machine Won the Toss. Please wait for your turn to make next move ");
        } else {
            player1 = new UserPlayer();
            player2 = new MachinePlayer();
            System.out.println(" You Won the Toss. Please make next move ");
        }
        Move player1Move = null;
        Move player2Move = null;
//        player1.setPlayedMove(player1Move);
//        player1.playerStatus();
//
//        Move player2Move = player2.getNextMove(player1.getPlayedMoves());
//        player2.setPlayedMove(player2Move);
//        player2.playerStatus();
        while (!isGameOver()) {

            player1Move = player1.getNextMove(player2.getPlayedMoves());
            while (!isNextMoveValid(player1Move)) {
                player1Move = player1.getNextMove(player2.getPlayedMoves());
            }
            player1.setPlayedMove(player1Move);
            player1.playerStatus();
            player2.playerStatus();

            if (isGameOver()) {
                break;
            }
            player2Move = player2.getNextMove(player1.getPlayedMoves());
            while (!isNextMoveValid(player2Move)) {
                player2Move = player2.getNextMove(player1.getPlayedMoves());
            }
            player2.setPlayedMove(player2Move);
            player1.playerStatus();
            player2.playerStatus();


        }

        //Plyaer 1 Win

        Player winner = null;
        if (checkWiniingCombination(player1.getPlayedMoves())) {
            winner = player1;
        }
        //Plyaer 2 Win
        if (winner == null) {
            if (checkWiniingCombination(player2.getPlayedMoves())) {
                winner = player2;
            }
        }

        if (winner == null) {
            System.out.println(" Game is Draw could have been more interesting :(");
        } else {
            System.out.println("The winner is \n\n\n ");
            System.out.println(winner.getName());
            player1.playerStatus();
            player2.playerStatus();

        }


    }

    private boolean isMachineWonTheToss() {

        Random random = new Random(hashCode());
        int Low = 10;
        int High = 1000;
        int result = random.nextInt(High - Low) + Low;

        if (result % 2 == 1) {
            return true;
        }
        return false;


    }


    private boolean isGameOver() {
        boolean b = false;
        if (player1.getPlayedMoves().size() > 2 || player2.getPlayedMoves().size() > 2) {

            int total = player1.getPlayedMoves().size() + player2.getPlayedMoves().size();
            // Running out of move
            if (total > 5) {
                b = true;
            } else {

                //Check for winning combination
                b = checkWiniingCombination(player1.getPlayedMoves()) || checkWiniingCombination(player2.getPlayedMoves());

            }

        }

        return b;

    }

    public boolean checkWiniingCombination(Set<Move> userMoves) {
        boolean isSameUptoNow = false;
        if (userMoves.isEmpty() || userMoves.size() <= 2) {
            return false;
        } else {
            int horizontalSame = -1;
            int verticalSame = -1;

            boolean samehorizontal = true;
            for (Move currentMove : userMoves) {
                if (horizontalSame == -1) {
                    horizontalSame = currentMove.getX();
                    samehorizontal = false;
                } else {
                    if (currentMove.getX() != horizontalSame) {
                        samehorizontal = false;
                        break;
                    }  else {
                        samehorizontal = true;
                    }
                }
            }

            if (samehorizontal
                    ) {
                return true;
            }

            boolean sameVerticalSame = true;
            for (Move currentMove : userMoves) {
                if (verticalSame == -1) {
                    verticalSame = currentMove.getY();
                    sameVerticalSame = false;
                } else {
                    if (currentMove.getY() != verticalSame) {
                        sameVerticalSame = false;
                        break;
                    }  else {
                        sameVerticalSame = true;
                    }
                }
            }

            if (sameVerticalSame
                    ) {
                return true;
            }

            // if unequal then check for cross scenario
            boolean isCenterElement = checkContainsCenterElement(userMoves);
            if (isCenterElement) {

                isSameUptoNow = checkCrossMoves(userMoves);
            }
        }

        return isSameUptoNow;
    }

    private boolean checkCrossMoves(Set<Move> userMoves) {

            //Chech for  cross
            if (userMoves.contains(new Move(0, 0)) && userMoves.contains(new Move(1, 1)) && userMoves.contains(new Move(2, 2))) {
                return true;
            }
        if (userMoves.contains(new Move(0, 2)) && userMoves.contains(new Move(1, 1)) && userMoves.contains(new Move(2, 0))) {
                return true;
            }
        return false;



    }

    private boolean checkContainsCenterElement(Set<Move> userMoves) {
        for (Move currentMove : userMoves) {
            if (currentMove.getX() == 1 && currentMove.getY() == 1) {
                return true;
            }
        }
        return false;
    }


    public boolean isNextMoveValid(Move move) {
        if (player1.getPlayedMoves().contains(move)) {
            return false;
        }
        if (player2.getPlayedMoves().contains(move)) {
            return false;
        }
        return true;
    }


    private Player getTheWinner() {

        return null;

    }

}
