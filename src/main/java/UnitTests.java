import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UnitTests {
    RarReaderDecorator rarReaderDecorator = new RarReaderDecorator(null);

    @DataProvider
    public Object[][] decoratorProviderMethod() {
        return new Object[][]{
                {new RarReaderDecorator(null)},
                {new ZipReaderDecorator(null)},
                {new MD5EncryptReaderDecorator(null)},
                {new RSAEncryptReaderDecorator(null)}
        };
    }

    @DataProvider
    public Object[][] objectAndStreamProvider() {
        return new Object[][]{
                {new RarReaderDecorator(null), "unArch"},
                {new ZipReaderDecorator(null), "unArch"},
                {new MD5EncryptReaderDecorator(null), "encrypt"},
                {new RSAEncryptReaderDecorator(null), "encrypt"}
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
        assertEquals("", readerStream.toString(), "Файл пустой");
    }

    @Test(dataProvider = "objectAndStreamProvider")
    public void unArchTest(ReaderDecorator readerProvider, String readerName) {
        ByteArrayOutputStream readerStream = new ByteArrayOutputStream();
        try {
            Method stream = readerProvider.getClass().getDeclaredMethod(readerName, ByteArrayOutputStream.class);
            stream.setAccessible(true);
            String invoke = stream.invoke(readerProvider, readerStream).toString();
            assertEquals(readerStream.toString(), invoke,"Разархивация/раскриптовка прошла успешно");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
