import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class EncryptReaderDecorator extends ReaderDecorator {
    protected abstract ByteArrayOutputStream encrypt(ByteArrayOutputStream stream);

    protected abstract boolean isValidFileType();

    protected abstract boolean isPasswordNecessary();

    protected boolean preProcess(String fileName){
        // TODO: Open file (in a default way)
        boolean result = true;

        System.out.println("EncryptReaderDecorator::open / preProcess::Just trying to open md5 file: " + fileName);
        result = isValidFileType() && !isPasswordNecessary();

        return result;
    }

    protected ByteArrayOutputStream process(ByteArrayOutputStream readerStream) throws IOException {
        System.out.println("+EncryptReaderDecorator read / process without parameters");

        // TODO: Read file (in a default way)
        System.out.println("EncryptReaderDecorator::read::Just trying to read md5 file");

        return encrypt(readerStream);
    }
}
