package finalexam.knockknock;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * A unit test that will test a KnockKnockServer without requiring a network 
 * connection by using a mocked socket.
 * 
 * Uncomment the tests one at a time to run them and verify that your client
 * is working as expected.
 * 
 * @author GCCIS faculty
 */
public class KnockKnockServerTest {
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
        // String[] linesToWrite = {
        //     "Knock, Knock.",
        //     "Broccoli",
        //     "Broccoli doesn't have a last name, silly!"
        // };
        // String[] linesToRead = {};
        // Mocket mocket = new Mocket(linesToRead);
        // KnockKnockServer server = new KnockKnockServer(mocket, linesToWrite[1], linesToWrite[2]);

        // // invoke
        // server.close();

        // // analyze
        // assertTrue(mocket.isClosed());
    }

    @Test
    public void tellKnockKnockBroccoli() throws IOException {
        // // setup
        // String[] expected = {
        //     "Knock, Knock.",
        //     "Broccoli",
        //     "Broccoli doesn't have a last name, silly!"
        // };
        // String[] linesToRead = {
        //     "Who's there?",
        //     "Broccoli, who?"
        // };
        // Mocket mocket = new Mocket(linesToRead);
        // KnockKnockServer server = new KnockKnockServer(mocket, expected[1], expected[2]);

        // // invoke
        // server.tellKnockKnock();

        // // analyze
        // String[] actual = mocket.getLinesWritten();
        // assertArrayEquals(expected, actual);
    }

    @Test
    public void tellKnockKnockBoo() throws IOException {
        // // setup
        // String[] expected = {
        //     "Knock, Knock.",
        //     "Boo",
        //     "Why are you crying?"
        // };
        // String[] linesToRead = {
        //     "Who's there?",
        //     "Boo, who?"
        // };
        // Mocket mocket = new Mocket(linesToRead);
        // KnockKnockServer server = new KnockKnockServer(mocket, expected[1], expected[2]);

        // // invoke
        // server.tellKnockKnock();

        // // analyze
        // String[] actual = mocket.getLinesWritten();
        // assertArrayEquals(expected, actual);
    }
}
