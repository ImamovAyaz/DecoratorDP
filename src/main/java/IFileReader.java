import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface IFileReader {
    public ByteArrayOutputStream read() throws IOException;

    public boolean open(String filename) throws IOException;

    public void setRider(IFileReader reader); // TODO: Think about it?
}
