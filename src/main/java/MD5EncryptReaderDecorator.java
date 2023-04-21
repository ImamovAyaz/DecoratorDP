import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MD5EncryptReaderDecorator extends EncryptReaderDecorator {
    public MD5EncryptReaderDecorator(IFileReader reader){
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    protected ByteArrayOutputStream encrypt(ByteArrayOutputStream stream){
        System.out.println("-MD5EncryptReaderDecorator encrypt with parameter: " + stream.toString());

        return stream;
    }

    protected boolean isValidFileType(){
        // Note: Is this file type valid

        System.out.println("-MD5EncryptReaderDecorator isValidFileType");
        return true;
    }

    protected boolean isPasswordNecessary(){
        // Note: Is this file need password

        System.out.println("-MD5EncryptReaderDecorator isPasswordNecessary");
        return false;
    }
}
