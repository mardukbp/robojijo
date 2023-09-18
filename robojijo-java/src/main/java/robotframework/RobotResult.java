package robotframework;


public class RobotResult {
    private final String status;
    private final String output;
    private final Object return_value;
    private final String error;
    private final String traceback;
    private final boolean continuable;
    private final boolean fatal;

    private RobotResult(String status, String output, Object return_value, String error, String traceback, boolean continuable, boolean fatal) {
        this.status = status;
        this.output = output;
        this.return_value = return_value;
        this.error = error;
        this.traceback = traceback;
        this.continuable = continuable;
        this.fatal = fatal;
    }

    public String getStatus() {
        return status;
    }

    public String getOutput() {
        return output;
    }

    public Object getReturn() {
        return return_value;
    }

    public String getError() {
        return error;
    }

    public String getTraceback() {
        return traceback;
    }

    public boolean getContinuable() {
        return continuable;
    }

    public boolean getFatal() {
        return fatal;
    }

    public static RobotResult pass(String output, Object returnValue) {
        return new RobotResult("PASS", output, returnValue, null, null, true, false);
    }

    public static RobotResult fail(String error, String traceback) {
        return new RobotResult("FAIL", null, null, error, traceback, true, false);
    }
}
