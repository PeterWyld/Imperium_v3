package values;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class ImageLibrary {
	public Image[] unitImgArr;
	public Image[] tileImgArr;
	
	public ImageLibrary() {
		initialiseUnitImages("imgs/Units");
		initialiseTileImages("imgs/Tiles");
	}
	
	public void initialiseUnitImages(String filePath) {
		//loads in the images for units, if load fails then a blank image is created
		File units = new File(filePath);
		File[] unitImgs = units.listFiles();
		unitImgArr = new Image[unitImgs.length];
		Image aUnitImg = null;
		
		for(int i = 0; i <= unitImgs.length - 1; i++) {
			try {
				aUnitImg = ImageIO.read(unitImgs[i]);
			} catch (IOException exec) {
				aUnitImg = new BufferedImage(16,16, BufferedImage.TYPE_INT_ARGB); //Requires Testing
				//Citation -- Oracle, Creating and drawing an Image, 02/10/2018, https://docs.oracle.com/javase/tutorial/2d/images/drawonimage.html
			}
			unitImgArr[i] = aUnitImg;
		}
	}
	
	public void initialiseTileImages(String filePath) { 
		//loads in the images for tiles, if load fails then a blank image is created
		
		//This is a separate function from the unit version due to the possibility of wanting to load and unload these separately
		
		File tiles = new File(filePath);
		File[] tileImgs = tiles.listFiles();
		tileImgArr = new Image[tileImgs.length];
		Image aTileImg = null;
		
		for(int i = 0; i <= tileImgs.length - 1; i++) {
			try {
				aTileImg = ImageIO.read(tileImgs[i]);
			} catch (IOException exec) {
				aTileImg = new BufferedImage(16,16, BufferedImage.TYPE_INT_ARGB); //REQUIRES TESTING
				//Citation -- Oracle, Creating and drawing an Image, 02/10/2018, https://docs.oracle.com/javase/tutorial/2d/images/drawonimage.html
			}
			tileImgArr[i] = aTileImg;
		}
	}
	
	public void unloadUnitImages() {
		//unloads images for possible memory purposes (at expense of having to load images again in future)
		unitImgArr = null;
	}
	
	public void unloadTileImages() {
		//unloads images for possible memory purposes (at expense of having to load images again in future)
		tileImgArr = null;
	}
}