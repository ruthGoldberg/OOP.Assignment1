package observer;

import java.util.LinkedList;
import java.util.List;

/***
 * this is a class which implements from Sender interface
 * GroupAdmin manage all the members of the UndoableStringBuilder
 */
public class GroupAdmin implements Sender {

    private List<Member> myMembers;
    private UndoableStringBuilder currentString;

    /**
     * GroupAdmins constructor
     * initializing the list of members
     * initializing the UndoableStringBuilder
     */
    public GroupAdmin(){
        this.myMembers = new LinkedList<>();
        this.currentString =new UndoableStringBuilder() ;
    }

    /**
     * get method for the list of members
     * @return the list of members
     */

    public List<Member> getMyMembers() {
        return myMembers;
    }

    /**
     * get method for the UndoableStringBuilder
     * @return the UndoableStringBuilder
     */
    public UndoableStringBuilder getCurrentString() {
        return currentString;
    }

    /**
     * this method goes through the whole list
     * and updates every one of the members with the current UndoableStringBuilder
     */

    public void updateAll (){
        for (Member member : myMembers){
            member.update(this.currentString);
        }
    }

    /**
     * this method adds to the list the given member
     * @param obj - member who needs to be registered
     */
    @Override
    public void register(Member obj) {
        this.myMembers.add(obj);
    }


    /**
     * this method removes from the list the given member
     * @param obj -member who needs to be unregistered
     */
    @Override
    public void unregister(Member obj) {
       UndoableStringBuilder lastUpdate = new UndoableStringBuilder();
       lastUpdate.append(this.currentString.toString());
        obj.update(lastUpdate);
        this.myMembers.remove(obj);
    }

    /**
     * this method use the insert method from the UndoableStringBuildr class
     * and calls the updateAll method with the new UndoableStringBuilder
     * @param offset - index in the original string
     * @param obj - the given string to insert in the given index
     */

    @Override
    public void insert(int offset, String obj) {
        this.currentString.insert(offset, obj);
        updateAll();
    }

    /**
     * this method use the append method from the UndoableStringBuildr class
     * and calls the updateAll method with the new UndoableStringBuilder
     * @param obj- given String to add at the end of the original string
     */

    @Override
    public void append(String obj) {
        this.currentString.append(obj);
        updateAll();
    }


    /**
     * this method use the delete method from the UndoableStringBuildr class
     * and calls the updateAll method with the new UndoableStringBuilder
     * @param start -index of the first char
     * @param end   - index of the last char
     */
    @Override
    public void delete(int start, int end) {
        this.currentString.delete(start, end);
        updateAll();
    }


    /**
     * this method use the undo method from the UndoableStringBuildr class
     * and calls the updateAll method with the new UndoableStringBuilder
     */
    @Override
    public void undo() {
        this.currentString.undo();
        updateAll();
    }

    @Override
    public String toString() {
        return "GroupAdmin{" +
                "myMembers=" + myMembers +
                ", lastUpdate=" + currentString +
                '}';
    }
}
