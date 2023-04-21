import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class ArchReaderDecorator extends ReaderDecorator{

    protected abstract ByteArrayOutputStream unArch(ByteArrayOutputStream stream);
    protected abstract boolean isValidFileType();
    protected abstract boolean isPasswordNecessary();

    protected boolean preProcess(String filename){
        // TODO: Open file (in a default way)
        boolean result = true;

        System.out.println("ArchReaderDecorator::open / preProcess::Just trying to open zip file: " + filename);
        result = isValidFileType() && !isPasswordNecessary();

        return result;
    }

    protected ByteArrayOutputStream process(ByteArrayOutputStream readerStream) throws IOException {
        System.out.println("+ArchReaderDecorator read / process without parameters");

        // TODO: Read file (in a default way)
        System.out.println("ArchReaderDecorator::read::Just trying to read zip file");

        return unArch(readerStream);
    }
}
