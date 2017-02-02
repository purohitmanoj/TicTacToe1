package com.game.entity
        ;

import java.io.Serializable;

/**
 * User: Manoj Purohit
 * Purpose of it is to ...
 */
public class Move implements Serializable {
    private int x = 0;

    private int y = 0;

    public Move(int i, int i1) {
        x = i;
        y = i1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Move other = (Move) obj;
        if (x != other.getX())
            return false;
        if (y != other.getY())
            return false;
        return true;
    }
    @Override
    public String toString() {
        return ("(" + x + "," + y+")-");
    }
}
