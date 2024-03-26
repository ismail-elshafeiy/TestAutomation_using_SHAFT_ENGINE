package examples.files;

import com.shaft.cli.FileActions;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.testng.annotations.Test;



public class FileActions_Test {
    @Test
    public void getFileInFolder() {
        String folderPath = "src/test/resources/TestDataFiles";
        String fileName = "image.png";
        String files= FileActions.getInstance().listFilesInDirectory(folderPath);
        String files2=FileActions.getInstance().listFilesInDirectory(folderPath, (TrueFileFilter) TrueFileFilter.TRUE);
        System.out.println(files);
        System.out.println("##################");
        System.out.println(files2);

    }
}
