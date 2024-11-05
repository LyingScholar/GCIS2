package finalexam.knockknock;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * A unit test that will test a KnockKnockClient without requiring a network 
 * connection by using a mocked socket.
 * 
 * Uncomment the tests one at a time to run them and verify that your client
 * is working as expected.
 * 
 * @author GCCIS faculty
 */
public class KnockKnockClientTest {
    @Test
    public void testForAssertions() {
        // delete this test
        String[] array = {"abc", "def", "ghi"};
        assertArrayEquals(array, array);
        assertTrue(true);
    }

    @Test
    public void close() throws IOException {
        // // setup
        // String[] linesToRead = {};
        // Mocket mocket = new Mocket(linesToRead);
        // KnockKnockClient client = new KnockKnockClient(mocket);

        // // invoke
        // client.close();

        // // analyze
        // assertTrue(mocket.isClosed());
    }

    @Test
    public void knockKnockGoliath() throws IOException {
        // // setup
        // String[] linesToRead = {
        //     "Knock, Knock.",
        //     "Goliath",
        //     "Goliath down, you looketh tired!"
        // };

        // String[] expected = {
        //     "Who's there?",
        //     "Goliath, who?"
        // };
        // Mocket mocket = new Mocket(linesToRead);
        // KnockKnockClient client = new KnockKnockClient(mocket);

        // // invoke
        // client.knockKnock();

        // // analyze
        // String[] actual = mocket.getLinesWritten();
        // assertArrayEquals(expected, actual);
        
    }

    @Test
    public void knockKnockYodel() throws IOException {
        // // setup
        // String[] linesToRead = {
        //     "Knock, Knock.",
        //     "A little old lady",
        //     "I didn't know you could yodel!"
        // };

        // String[] expected = {
        //     "Who's there?",
        //     "A little old lady, who?"
        // };
        // Mocket mocket = new Mocket(linesToRead);
        // KnockKnockClient client = new KnockKnockClient(mocket);

        // // invoke
        // client.knockKnock();

        // // analyze
        // String[] actual = mocket.getLinesWritten();
        // assertArrayEquals(expected, actual);
        
    }
}
