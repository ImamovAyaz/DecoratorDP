import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ZipReaderDecorator extends ArchReaderDecorator {
    public ZipReaderDecorator(IFileReader reader){
        logDependencyAdding(reader, "constructor");
        this.reader = reader;
    }

    protected ByteArrayOutputStream unArch(ByteArrayOutputStream stream){
        System.out.println("-ZipReaderDecorator unZip with parameter: " + stream.toString());

        return stream;
    }

    protected boolean isValidFileType(){
        // Note: Is this file type valid

        System.out.println("-ZipReaderDecorator isValidFileType");
        return true;
    }

    protected boolean isPasswordNecessary(){
        // Note: Is this file need password

        System.out.println("-ZipReaderDecorator isPasswordNecessary");
        return false;
    }
}