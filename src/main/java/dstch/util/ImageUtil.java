package main.java.dstch.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import javafx.scene.image.Image;

public class ImageUtil
{

	//二进制输入流转换为Image
	public static Image binaryStream2Image(InputStream ips, int widthAndHeight) {
		return new Image(ips, widthAndHeight, widthAndHeight, false, true);
	}

	public static Image binaryStream2Image(InputStream ips, int width, int Height) {
		return new Image(ips, width, Height, false, true);
	}

	public static Image obj2Image(Object obj, int widthAndHeight) {
		InputStream ips = new ByteArrayInputStream((byte[])obj);
		return new Image(ips, widthAndHeight, widthAndHeight, false, true);
	}

	public static byte[] toByteArray(Object obj) {
		byte[] bytes = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			bytes = bos.toByteArray ();
			oos.close();
			bos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return bytes;
	}

}