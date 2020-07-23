import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        int pixelisation = 5;
        try {
            BufferedImage imageSrc = ImageIO.read(new File("./images/img1.jpg"));
            Raster rasterSrc = imageSrc.getData();
            WritableRaster dest = rasterSrc.createCompatibleWritableRaster();

            for(int y = 0; y < rasterSrc.getHeight(); y += pixelisation) {
                for(int x = 0; x < rasterSrc.getWidth(); x += pixelisation) {
                    double[] pixel = new double[3];
                    pixel = rasterSrc.getPixel(x, y, pixel);

                    for(int yd = y; (yd < y + pixelisation) && (yd < dest.getHeight()); yd++) {
                        for(int xd = x; (xd < x + pixelisation) && (xd < dest.getWidth()); xd++) {
                            dest.setPixel(xd, yd, pixel);
                        }
                    }
                }
            }
            imageSrc.setData(dest);
            ImageIO.write(imageSrc, "jpg", new File("./images/image-pixelated.jpg"));
        } catch (IOException e) {
            System.out.println("RIP");
        }
    }
}
