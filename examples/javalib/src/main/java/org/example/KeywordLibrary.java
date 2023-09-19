package org.example;


import io.github.robson.robotframework.Doc;
import io.github.robson.robotframework.Keyword;
import io.github.robson.robotframework.RobotLibrary;
import io.github.robson.robotframework.RobotResult;

@Doc(doc="Some Java Library")
public class KeywordLibrary extends RobotLibrary {
    @Keyword(name="Get Full Name")
    @Doc(doc="Combine the first name and the last name into the full name")
    public RobotResult getFullName(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;

        return RobotResult.pass(
                "A message for the RF log",
                fullName
        );
    }

    @Keyword(name="Keyword Fails")
    @Doc(doc="A keyword that fails")
    public RobotResult keywordFails() {
        try {
            int a = 1/0;
            return RobotResult.pass("Success", a);
        }
        catch (Exception e) {
            return RobotResult.fail(
                    e.getMessage(),
                    getStacktrace(e)
            );
        }
    }
}
