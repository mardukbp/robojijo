package org.example;


import rf.robson.robotframework.Doc;
import rf.robson.robotframework.Keyword;
import rf.robson.robotframework.RobotLibrary;


@Doc(doc="""
Some Java Library
""")
public class JavaLibrary extends RobotLibrary {
    @Keyword(name="Sum ints")
    @Doc(doc= """
    Sum two integer numbers

    *Example*
    
    | ``Sum ints   a   b``
    """)
    public int sumInts(int a, int b) {
        return a + b;
    }

    @Keyword(name="Concat strings")
    @Doc(doc="Concatenate two strings")
    public String concat(String a, String b) {
        return a + b;
    }

    @Keyword(name="NAND")
    @Doc(doc="The logic gate NAND")
    public boolean nand(boolean a, boolean b) {
        return !(a && b);
    }
}
