package finalexam.knockknock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * A mocked socket. Doesn't actually touch the network, but instead reads from
 * and writes to memory.
 */
public class Mocket extends Socket {
    /**
     * Output stream that stores any data written in memory.
     */
    private final ByteArrayOutputStream output;

    /**
     * Input stream that reads from memory.
     */
    private final ByteArrayInputStream input;

    /**
     * Used ot keep track of whether the close method has been called.
     */
    private boolean closed;

    /**
     * Creates a new mocket that will return the specified lines of text from
     * its input stream.
     * 
     * @param linesToRead The text to return when the input stream is used to
     * read from the mocked socket.
     */
    public Mocket(String[] linesToRead) {
        output = new ByteArrayOutputStream();

        StringBuilder builder = new StringBuilder();
        for(String line : linesToRead) {
            builder.append(line);
            builder.append("\n");
        }
        byte[] data = builder.toString().getBytes();
        input = new ByteArrayInputStream(data);

        closed = false;
    }

    @Override
    public InputStream getInputStream() {
        return input;
    }

    @Override
    public OutputStream getOutputStream() {
        return output;
    }

    @Override
    public void close() {
        closed = true;
    }

    /**
     * Returns any lines of text that have been written to the mocket's output
     * stream.
     * 
     * @return Any lines of text that have been written to the output stream.
     */
    public String[] getLinesWritten() {
        byte[] data = output.toByteArray();
        String raw = new String(data);
        return raw.split("\r?\n|\r");
    }

    /**
     * Returns true if the mock socket has been closed.
     */
    public boolean isClosed() {
        return closed;
    }
}
