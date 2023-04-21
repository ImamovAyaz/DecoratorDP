import java.io.ByteArrayOutputStream;
import java.io.IOException;

// TODO: Please try to find out how to cover thus entity with Unit Tests
public abstract class ReaderDecorator implements IFileReader {
    protected IFileReader reader;

    public void setRider(IFileReader reader){
        logDependencyAdding(reader, "setRider");
        this.reader = reader;
    }

    public boolean open(String filename) throws IOException {
        // TODO Possibly: with reader usage
        boolean isOk = true;
        if (reader != null){
            isOk = reader.open(filename);
        }

        System.out.println("+ReaderDecorator open with parameter: " + filename);

        return isOk && preProcess(filename);
    }

    public ByteArrayOutputStream read() throws IOException {
        // TODO: Implement additional behaviour using reader

        ByteArrayOutputStream readerStream = null;
        if (reader != null){
            readerStream = reader.read();
        }
        else {
            readerStream = new ByteArrayOutputStream();
        }

        System.out.println("+ReaderDecorator read without parameters");

        return process(readerStream);
    }

    protected abstract ByteArrayOutputStream process(ByteArrayOutputStream readerStream) throws IOException;

    protected abstract boolean preProcess(String filename);

    protected void logDependencyAdding(IFileReader reader, String methodToLog){
        String classToLog = this.getClass().getSimpleName();

        String msg = "+" + classToLog + " " + methodToLog + " with parameter IFileReader: ";
        if (reader != null) {
            msg += reader.toString();
        }
        else {
            msg += "null";
        }
        System.out.println(msg);
    }
}
