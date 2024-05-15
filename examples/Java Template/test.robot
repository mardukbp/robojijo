*** Settings ***
Library    JavaLibrary

*** Test Cases ***
Sum the integers in a list
    ${ints}      Create List       ${1}    ${2}    ${3}
    ${result}    Sum list          ${ints}
    Should Be Equal As Integers    ${result}    6

Double the integers in a list
    ${ints}            Create List    ${1}    ${2}    ${3}
    ${result}          Double list    ${ints}
    ${expected}        Create List    ${2}    ${4}    ${6}
    Should Be Equal    ${result}      ${expected}

Sum the integers in a matrix
    ${row 1}      Create List       ${1}        o
    ${row 2}      Create List       ${0}        ${1}
    ${matrix}     Create List       ${row 1}    ${row 2}
    ${result}     Sum matrix        ${matrix}
    Should Be Equal As Integers    ${result}    2

Concatenate a list of strings
    ${strings}    Create List    Hello        World
    ${result}     Concat List    ,            ${strings}
    Should Be Equal As Strings   ${result}    Hello,World

Build a sentence
    ${word 1}      Create List       h    e    l    l    ${0}
    ${word 2}      Create List       w    o    r    l    d
    ${letters}     Create List       ${word 1}    ${word 2}
    ${result}     Build Sentence         ${SPACE}     ${letters}
    Should Be Equal    ${result}    hello world

Add two histograms
    ${hist1}           Create Dictionary    apples=${3}    bananas=${2}
    ${hist2}           Create Dictionary    apples=${1}    bananas=s
    ${result}          Add histograms       ${hist1}       ${hist2}
    ${expected}        Create Dictionary    apples=${4}    bananas=${5}
    Should Be Equal    ${result}            ${expected}

Set environment variables
    ${envVars}         Create Dictionary    path=${CURDIR}    verbose=${True}
    Set Env Vars    ${envVars}
