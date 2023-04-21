public class FileProcessingEngineBuilder {
    public static IFileReader buildSimpleTxtReader(){
        IFileReader additionalReaderFeature = null;
        IFileReader simpleTXTReader = new FileReaderDecorator(additionalReaderFeature);
        return simpleTXTReader;
    }

    public static IFileReader buildZipTxtReader() {
        IFileReader additionalReaderFeature = new ZipReaderDecorator(null);
        IFileReader unZipTxtReader = new FileReaderDecorator(additionalReaderFeature);
        return unZipTxtReader;
    }

    public static IFileReader buildMD5TxtReader() {
        IFileReader additionalReaderFeature = new MD5EncryptReaderDecorator(null);
        IFileReader md5CryptoTxtReader = new FileReaderDecorator(additionalReaderFeature);
        return md5CryptoTxtReader;
    }

    public static IFileReader buildComplexTxtReader(String options){
        IFileReader complexTxtReader = null;
        return complexTxtReader;
    }
}
