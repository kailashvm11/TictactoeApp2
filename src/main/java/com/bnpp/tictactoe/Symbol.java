package com.bnpp.tictactoe;

public enum Symbol {
    CROSS('X'), NOUGHT('O'), NO_SYMBOL(' ');

    private char value;

    Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
