package reto1_Solve;
import java.util.Date;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

public class Evidencias {
	//***********************************************************************************************************
	//*
	//* capturarPantalla
	//*
	//**********************************************************************************************************
	public static String capturarPantalla() throws Throwable
	{
		String strPath = "C:\\Users\\mjaramillo\\eclipse-workspace\\reto_Solve\\src\\test\\IMG\\Imagen" + getDateTime() + ".jpg"; //Esta variable debe ser pública con la ruta del repositorio
		Rectangle rectangleTam = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		try
		{
			Robot robot = new Robot();  
			BufferedImage image = robot.createScreenCapture(rectangleTam);
			System.out.println("Generando el fichero: " + strPath );
            FileOutputStream out = new FileOutputStream(strPath);
            ImageIO.write(image, "jpg", out);	            
			return strPath;
		}
		catch(Throwable e)
		{
			System.out.println("Error en getEvd: " + e.getMessage());
			return null;
		}
	}
	//***********************************************************************************************************
	//*
	//* TomarEvidencia
	//*
	//**********************************************************************************************************	
	public static void TomarEvidencia(String strResult)
	{
	    BufferedWriter writer;
		try
		{
			writer = new BufferedWriter(new FileWriter("C:\\Users\\mjaramillo\\eclipse-workspace\\reto_Solve\\src\\test\\EVD\\Evidencia.txt", true));
			writer.append(strResult + ";" + capturarPantalla() + "\r\n");
			writer.flush();
			writer.close();  // Close to unlock and flush to disk.
		} 
		catch (Throwable e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//***********************************************************************************************************
	//*
	//* getDateTime
	//*
	//**********************************************************************************************************		
	public static String getDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	} 
}


