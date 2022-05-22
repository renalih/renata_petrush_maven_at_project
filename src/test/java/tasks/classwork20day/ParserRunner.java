package tasks.classwork20day;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ParserRunner {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        MyParser parser = new MyParser();

        parser.parseGSON();
        parser.fromGSON();
        parser.parseDOM();

    }
}
