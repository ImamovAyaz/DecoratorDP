import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class RSAEncryptReaderDecorator extends EncryptReaderDecorator {
    public RSAEncryptReaderDecorator(IFileReader reader){
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    protected ByteArrayOutputStream encrypt(ByteArrayOutputStream stream){
        System.out.println("-RSAEncryptReaderDecorator encrypt with parameter: " + stream.toString());

        return stream;
    }

    protected boolean isValidFileType(){
        // Note: Is this file type valid

        System.out.println("-RSAEncryptReaderDecorator isValidFileType");
        return true;
    }

    protected boolean isPasswordNecessary(){
        // Note: Is this file need password

        System.out.println("-RSAEncryptReaderDecorator isPasswordNecessary");
        return false;
    }
}
