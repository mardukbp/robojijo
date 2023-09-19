package org.example;


import io.github.robson.stdio.REPL;

public class Main
{
    public static void main(String[] args)
    {
        REPL.start(new KeywordLibrary());
    }
}
