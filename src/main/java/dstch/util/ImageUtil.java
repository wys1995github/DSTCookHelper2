package main.java.dstch.util;

import java.io.InputStream;

import javafx.scene.image.Image;

public class ImageUtil
{

	public static String IMGPATH_ICON = "/com/dstch/image/icon.png";
	public static String IMGPATH_POT = "/com/dstch/image/pot.png";
	
	public static Image binaryStream2Image(InputStream in) {
		return new Image(in, 40, 40, false, false);
	}

//	public static Image getIconImage() {
//		InputStream ips = ImageUtil.class.getResourceAsStream(ImageUtil.IMGPATH_ICON);
//		Image imgIcon = null;
//		try {
//			imgIcon = ImageIO.read(ips);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		return imgIcon;
//	}
//	
//	public static ImageIcon getPotImage() {
//		InputStream ips = ImageUtil.class.getResourceAsStream(ImageUtil.IMGPATH_POT);
//		ImageIcon potIcon = loadImage(ips);
//		return potIcon;
//	}

}