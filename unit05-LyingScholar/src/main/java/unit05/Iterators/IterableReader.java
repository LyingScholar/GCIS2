package unit05.Iterators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableReader implements Iterable<String>, Iterator<String>, AutoCloseable {
//When did we learn AutoCloser? HAd to google this for an hour
    private BufferedReader reader;
    private String nextLine;

    public IterableReader(String fileName) throws IOException {
        this.reader = new BufferedReader(new FileReader(fileName));
        readLine();
    }

    private void readLine() {
        try {
            nextLine = reader.readLine();
        } catch (IOException e) {
            nextLine = null;
        }
    }


    @Override
    public String next() {
        if (nextLine == null) {
            throw new NoSuchElementException("No more lines to read, go touch grass");
        }


        String lineToReturn = nextLine;
        readLine();
        return lineToReturn;
    }

    @Override
    public boolean hasNext() {
        return nextLine != null;
    }


    @Override
    public Iterator<String> iterator() {
        return this;
    }
    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    //this main is copid from the assignment itself
    public static void main(String[] args) throws IOException {
        try (IterableReader reader = new IterableReader("data/simple.txt");) 
        {
            while (reader.hasNext()) {
                System.out.println(reader.next());
            }
        }
        try (IterableReader reader = new IterableReader("data/simple.txt");)     
        {
            for (String line : reader) {
                System.out.println(line);
            }
        }

        // try (IterableReader reader = new IterableReader("data/alice.txt");)     
        // {
        //     for (String line : reader) {
        //         System.out.println(line);
        //     }
        // }
    }
//Output was:
// one
// two
// three
// four
// five
// one
// two
// three
// four
// five
}