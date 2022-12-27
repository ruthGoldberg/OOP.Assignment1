package observer;


/**
 * this is a class which implements from Member interface
 * ConcreteMember contains UndoableStringBuilder which every member holds
 * ConcreteMember also contains one method which is responsible for updating the members' USB
 */

public class ConcreteMember implements Member {

    private UndoableStringBuilder usb;


    /**
     * this method is responsible for updating the members' USB
     * @param usb - the new UndoableStringBuilder
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
    }

    /**
     * get method for the UndoableStringBuilder
     * @return the UndoableStringBuilder
     */

    public UndoableStringBuilder getUsb() {
        return usb;
    }

    @Override
    public String toString() {
        return  usb.toString();
    }
}
