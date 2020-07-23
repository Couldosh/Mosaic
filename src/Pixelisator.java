import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class Pixelisator {
    public static WritableRaster pixelise(BufferedImage image,int pixelisation){
        Raster rasterSrc = image.getData();
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
        return dest;
    }
}
