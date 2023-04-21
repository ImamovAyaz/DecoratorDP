import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;

public class UnitTests {
    @DataProvider
    public Object[][] decoratorProviderMethod() {
        return new Object[][]{
                {new RarReaderDecorator(null)},
                {new ZipReaderDecorator(null)},
                {new MD5EncryptReaderDecorator(null)},
                {new RSAEncryptReaderDecorator(null)}
        };
    }

    @Test(dataProvider = "decoratorProviderMethod")
    public void openReaderDecoratorTest(ReaderDecorator readerProvider) {
        boolean isOpened = false;
        try {
            isOpened = readerProvider.open("");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        Assert.assertTrue(isOpened, "Файл успешно открылся");
    }

    @Test(dataProvider = "decoratorProviderMethod")
    public void readReaderDecoratorTest(ReaderDecorator readerProvider) {
        ByteArrayOutputStream readerStream = new ByteArrayOutputStream();
        try {
            readerStream = readerProvider.read();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        Assert.assertEquals("", readerStream.toString(), "Файл пустой");
    }
}
