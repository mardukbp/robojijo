*** Settings ***
Library    JavaLibrary

*** Test Cases ***
Sum two integers
    ${result}    Sum ints          3    5
    Should Be Equal As Integers    ${result}    8

Sum the integers in a list
    ${ints}      Create List       ${1}    ${2}    ${3}
    ${result}    Sum list          ${ints}
    # Should Be Equal As Integers    ${result}    6

Double the integers in a list
    ${ints}            Create List    ${1}    ${2}    ${3}
    ${result}          Double list    ${ints}
    ${expected}        Create List    ${2}    ${4}    ${6}
    Should Be Equal    ${result}      ${expected}

Concatenate two strings
    ${result}   Concat Strings     hello        world
    Should Be Equal As Strings     ${result}    helloworld

Concatenate a list of strings
    ${strings}    Create List    Hello        World
    ${result}     Concat List    ,            ${strings}
    Should Be Equal As Strings   ${result}    Hello,World

Add two histograms
    ${hist1}           Create Dictionary    apples=${3}    bananas=${2}
    ${hist2}           Create Dictionary    apples=${1}    bananas=${3}
    ${result}          Add histograms       ${hist1}       ${hist2}
    ${expected}        Create Dictionary    apples=${4}    bananas=${5}
    Should Be Equal    ${result}            ${expected}
