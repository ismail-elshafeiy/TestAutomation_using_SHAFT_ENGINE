package examples.files;

import com.shaft.gui.internal.image.ImageProcessingActions;
import org.testng.annotations.Test;

public class Test_imageComparison {
    @Test
    public void f() {
        String refrenceFolderPath = "src/test/resources/TestDataFiles/imageComparer/image.png";
        String testFolderPath = "src/test/resources/TestDataFiles/imageComparer/imageTest.png";
        ImageProcessingActions.compareImageFolders(refrenceFolderPath, testFolderPath, 98);
    }
}
