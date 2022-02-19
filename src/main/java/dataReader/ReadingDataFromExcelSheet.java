package dataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcelSheet {

	
	public Object [][] readingDataFromExceelSheet () throws IOException
	{
		String filePath = System.getProperty("user.dir") + "//externalFiles//loginData.xlsx";
		File srcFile = new File(filePath);
		FileInputStream	fis = new FileInputStream(srcFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int numberOfRows = sheet.getLastRowNum() +1 ;
		int numbersOfColoumns = 2;
		String [][] dataArray = new String [numberOfRows][numbersOfColoumns];
		
		for (int i = 0; i<numberOfRows;i++)
		{
			for (int j = 0; j<numbersOfColoumns;j++)
			{
				dataArray[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
	wb.close();
	return dataArray;
		
	}
	

}
