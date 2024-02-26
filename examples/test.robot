*** Settings ***
Library    JavaLibrary

*** Test Cases ***
Sum two integers
    ${result}    Sum ints          3    5
    Should Be Equal As Integers    ${result}    8

Concatenate two strings
    ${result}   Concat Strings     hello        world
    Should Be Equal As Strings     ${result}    helloworld

NAND
    ${result}    NAND    ${True}    ${False}
    Should Be True       ${result}
