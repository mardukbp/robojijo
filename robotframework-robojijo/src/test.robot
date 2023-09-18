*** Settings ***
Library    JavaLibrary

*** Test Cases ***
Test 1,2,3
    ${full_name}      JavaLibrary.Get Full Name   John    Doe
    Keyword Fails