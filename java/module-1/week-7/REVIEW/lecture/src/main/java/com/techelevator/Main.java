package com.techelevator;

import java.io.IOException;

public class Main {
    private static int OBJECT_COUNTER = 0;

    /**
     * When the message variable was static, it could only hold one value.
     * Creating objects is more flexible than using static, because every object can hold a different message.
     * Note the message variable is not private, so it can be accessed directly in a test (from the same package).
     */
    String message = "Hello World 1";

    public Main(String msg) {
        int thisObjectNumber = ++OBJECT_COUNTER;
        this.message = msg + thisObjectNumber;
    }

    public static void main(String[] args) {
        // Prove that every object is different.
        for (int i = 0; i < 10; i++) {
            Main myMain = new Main("I am object number ");
            myMain.printMsg();
        }

        // The variable named "myMain" can be re-declared here,
        //  because the myMain variable inside the for-loop is now out of scope.
        Main myMain = new Main("I am yet another object number ");
        // We don't need try/catch around this method call, because it throws an "Unchecked" Exception.
        myMain.setMessage(null);
        System.out.println( "This line can never be printed because that previous line throws an Exception." );
    }

    /**
     * NullPointerException extends RuntimeException.
     * Any class that extends RuntimeException is an "Unchecked" Exception,
     *  so we don't have to declare it as part of the method signature.
     */
    public void setMessage(String newMessage) {   // <-- No Exception declared here.
        if (newMessage == null) {
            throw new NullPointerException("Message cannot be null !!!!!!");
        }
        message = newMessage;
    }

    /**
     * IOException does not extend RuntimeException.
     * Any class that extends Throwable, but not RuntimeException, is a "Checked" Exception,
     *  so we have to declare it as part of the method signature.
     */
    public void setMessageWithCheckedException(String newMessage) throws IOException {
        if (newMessage == null) {
            throw new IOException("Message cannot be null !!!!!!");
        }
        message = newMessage;
    }

    public void printMsg() {
        System.out.println(message);
    }

    public String getMessage() {
        return "Hello World 2";
    }
}
