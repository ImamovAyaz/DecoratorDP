import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FileReaderDecorator extends ReaderDecorator {
    public FileReaderDecorator(IFileReader reader) {
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    protected boolean preProcess(String filename) {
        // TODO: Open file (in a default way)
        boolean result = true;
        System.out.println("FileReaderDecorator::open / preProcess::Just trying to open txt file: " + filename);

        return result;
    }

    protected ByteArrayOutputStream process(ByteArrayOutputStream readerStream) throws IOException {
        System.out.println("+FileReaderDecorator read / process without parameters");

        // TODO: Read file (in a default way)
        System.out.println("FileReaderDecorator::read::Just trying to read txt file");
        return readerStream;
    }
}
