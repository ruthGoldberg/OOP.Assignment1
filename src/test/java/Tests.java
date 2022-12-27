import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Tests {

    GroupAdmin test = new GroupAdmin();
    ConcreteMember member1 = new ConcreteMember();
    ConcreteMember member2 = new ConcreteMember();
    ConcreteMember member3 = new ConcreteMember();
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        logger.info(()->JvmUtilities.objectFootprint(test));
        logger.info(()->JvmUtilities.objectFootprint(member1));
        logger.info(()->JvmUtilities.objectFootprint(member1,member2));
        logger.info(()->JvmUtilities.objectTotalSize(member1,member2,member3));
        test.append("This is a test");
        logger.info(()->JvmUtilities.objectFootprint(test));
        logger.info(() -> JvmUtilities.jvmInfo());

    }
    @Test
    void updateAll() {
        test.register(member1);
        test.append("Hello");
        assertEquals(test.getCurrentString() , member1.getUsb());
        test.register(member2);
        test.append(" this is a");
        assertEquals(test.getCurrentString() , member1.getUsb());
        assertEquals(test.getCurrentString() , member2.getUsb());
        test.register(member3);
        test.append(" test");
        assertEquals(test.getCurrentString() , member1.getUsb());
        assertEquals(test.getCurrentString() , member2.getUsb());
        assertEquals(test.getCurrentString() , member3.getUsb());
        test.unregister(member1);
        UndoableStringBuilder m1current = new UndoableStringBuilder();
        m1current.append("Hello this is a test");
        test.append("!");
        assertEquals(m1current.toString() , member1.getUsb().toString());
        assertEquals(test.getCurrentString() , member2.getUsb());
        assertEquals(test.getCurrentString() , member3.getUsb());

    }

    @Test
    void register() {
        test.register(member1);
        assertEquals(member1, test.getMyMembers().get(0));
        test.register(member2);
        assertEquals(member2, test.getMyMembers().get(1));
        test.register(member3);
        assertEquals(member3, test.getMyMembers().get(2));
    }

    @Test
    void unregister() {
        test.register(member1);
        test.register(member2);
        test.register(member3);
        test.unregister(member2);
        assertEquals(member3, test.getMyMembers().get(1));
        test.unregister(member1);
        assertEquals(member3, test.getMyMembers().get(0));
        test.unregister(member3);
        assertEquals(true, test.getMyMembers().isEmpty());

    }

    @Test
    void update() {
        test.register(member1);
        assertEquals(null,member1.getUsb());
        test.append("Hello this is a test");
        assertEquals(test.getCurrentString(),member1.getUsb());
    }
}
