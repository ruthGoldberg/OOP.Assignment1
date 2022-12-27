package observer;


import java.util.EmptyStackException;
import java.util.Stack;

public class UndoableStringBuilder {

    /**
     * this class delegates from StringBuilder class with the option of undo
     * this class contains StringBuilder object which is being used for the StringBuilder methods
     * and a stack of Strings for the undo function
     */


    private StringBuilder myObject = new StringBuilder();
    private Stack<String> history;

    public UndoableStringBuilder() {
        history = new Stack<>();

    }

    /**
     * @param str - given String to add at the end of the original string
     * @return myObject - the original String + str
     */
    public UndoableStringBuilder append(String str) {
        try {
            if (str == null)
                throw new IllegalArgumentException();
            myObject.append(str);
            history.push(this.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("String must not be null");
        }
        return this;

    }

    /**
     * @param start -index of the first char
     * @param end   - index of the last char
     * @return myObject - the original String without the String between the indexes
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            myObject = myObject.delete(start, end);
            history.push(myObject.toString());
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("index is out of bounds");
        }
        return this;
    }

    /**
     * @param offset - index in the original string
     * @param str    - the given string to insert in the given index
     * @return myObject - the original String with the given string in the given index
     */
    public UndoableStringBuilder insert(int offset, String str) {
        try {
            if (str == null)
                throw new IllegalArgumentException();
            myObject = myObject.insert(offset, str);
            history.push(myObject.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println("String must not be null");
        } catch (StringIndexOutOfBoundsException ex1) {
            System.out.println("index is out of bounds");
        }
        return this;
    }

    /**
     * @param start -index of the first char
     * @param end   - index of the last char
     * @param str   - given String to replace
     * @return myObject - the original String changed between the given indexes by the given String
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        try {
            if (str == null)
                throw new IllegalArgumentException();
            myObject = myObject.replace(start, end, str);
            history.push(myObject.toString());
        } catch (IllegalArgumentException ex2) {
            System.out.println("String must not be null");
        } catch (StringIndexOutOfBoundsException ex3) {
            System.out.println("index is out of bounds");
        }
        return this;
    }

    /**
     * @return the original String reversed
     */
    public UndoableStringBuilder reverse() {
        myObject = myObject.reverse();
        history.push(myObject.toString());
        return this;
    }

    /**
     * undoing the last method
     */
    public void undo() {
        try {
            history.pop();
            myObject = new StringBuilder(history.peek());
        } catch (EmptyStackException ex) {
        }

    }

    @Override
    public String toString() {

        return myObject.toString();
    }
}


