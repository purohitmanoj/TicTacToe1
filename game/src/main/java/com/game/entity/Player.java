package com.game.entity;

import java.util.Set;

/**
 * User: Manoj Purohit
 * Purpose of it is to ...
 */
public interface Player {

    String getName();

    Move getNextMove(Set<Move>  otherPlayersMoves);

    void setPlayedMove(Move move);

    Set<Move> getPlayedMoves();

    void playerStatus();

}