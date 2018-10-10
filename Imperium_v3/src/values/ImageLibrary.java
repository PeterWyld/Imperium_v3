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
	
	/**
	 * Fills the attribute unitImgArr with the images in a file
	 * @param filePath is the name of the file that the unit images should come from
	 * If an image can't be read then a blank buffered image is created as a substitution
	 */
	public void initialiseUnitImages(String filePath) {
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
	
	/**
	 * Fills the attribute tileImgArr with the images in a file
	 * @param filePath is the name of the file that the tile images should come from
	 * If an image can't be read then a blank buffered image is created as a substitution
	 */
	public void initialiseTileImages(String filePath) { 
		
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
	
	/**
	 * clears unit image array to reduce memory usage (at possible future processing cost)
	 */
	public void unloadUnitImages() {
		unitImgArr = null;
	}
	
	/**
	 * clears tile image array to reduce memory usage (at possible future processing cost)
	 */
	public void unloadTileImages() {
		tileImgArr = null;
	}
}