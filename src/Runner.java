import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        int pixelisation = 10;
        try {
            BufferedImage imageSrc = ImageIO.read(new File("./images/img1.jpg"));

            BufferedImage dest = Pixelisator.pixelate(imageSrc,pixelisation);
            ImageIO.write(dest, "jpg", new File("./images/image-pixelated.jpg"));
        } catch (IOException e) {
            System.out.println("RIP");
        }
    }
}
