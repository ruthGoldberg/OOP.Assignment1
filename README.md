# OOP.Assignment1
Expanding capabilities of ‫‪StringBuilder while using observer Design patterns

## UndoableStringBuilder
StringBuilder class with the option of undo method

### Sender
Interface which describes the sender of the updates

### Member
Interface which describes the receiver of the updates

### GroupAdmin
This class implements from the Sender interface, it is contains the methods of UdoableStringBuilder class and a list of members who should receive updates on any changes made to the UndoableStringBuilder.
Besides the functions we were asked to implement, we added another function called UpdateAll which goes through all the members of the list and calls the Update method from the Member interface on any member on the arraylist.
In this class we also added Get functions for the current UnsoableStringBuilder and for the ArrayList.


### ConcreteMember
This class implements from the Member interface , it is contains the implementation of the Update method which updates the members' UndoableStringBuilder to be the knowest UndoableStringbuilder.
This class also contains a Get method for the member which returns the members' UndoableStringBuilder.

### tests
Our test class contains tests for the methods in GroupAdmin class : updateAll , register and unregister.
In addition, contains tests for the update method of the ConcreteMember class.
Whe used the JVM prints of the memory as requested. 
