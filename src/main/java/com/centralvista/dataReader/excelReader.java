package com.centralvista.dataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.centralvista.testBase.TestBase;

public class excelReader extends TestBase {

	private String path;
	private FileInputStream fis = null;
	private FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;

	public static final String TESTDATA_SHEET_PATH = "G:\\myprojects\\GitFirstProject\\src\\main\\java\\com\\centralvista\\testdata\\TestData.xlsx";

	private static Workbook book;
	private static Sheet sheetData;
	private static JavascriptExecutor js;

	public excelReader() throws FileNotFoundException {
		super();
	}

	public excelReader(String path) throws IOException {
		this.path = path;
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	public int getRowCount(String sheetName) {
		return workbook.getSheet(sheetName).getLastRowNum();
	}

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		try (FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH)) {
			book = WorkbookFactory.create(file);
			sheetData = book.getSheet(sheetName);

			if (sheetData == null) {
				throw new RuntimeException("Sheet " + sheetName + " does not exist in file: " + TESTDATA_SHEET_PATH);
			}

			int totalRows = sheetData.getLastRowNum();
			int totalCols = sheetData.getRow(0).getLastCellNum();

			Object[][] data = new Object[totalRows][totalCols];

			for (int i = 0; i < totalRows; i++) {
				Row row = sheetData.getRow(i + 1);
				for (int j = 0; j < totalCols; j++) {
					Cell cell = row != null ? row.getCell(j) : null;
					data[i][j] = cell != null ? getCellValue(cell) : "";
				}
			}

			return data;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error reading test data file", e);
		}
	}
//   Surendra Changer start here *\
	public String getCellvalue(String sheetName, int rowNum, int colNum) {
	    try (FileInputStream fis = new FileInputStream(TESTDATA_SHEET_PATH);
	         Workbook workbook = new XSSFWorkbook(fis)) {
	        
	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) throw new IllegalArgumentException("Sheet not found: " + sheetName);
	        
	        Row row = sheet.getRow(rowNum);
	        if (row == null) return "";
	        
	        Cell cell = row.getCell(colNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
	        if (cell == null) return "";

	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue().trim();

	            case NUMERIC:
	                // Use BigDecimal to avoid scientific notation and loss of precision
	                return BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();

	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());

	            case FORMULA:
	                return cell.getCellFormula();

	            default:
	                return "";
	        }
	    } catch (Exception e) {
	        System.err.println("Error reading cell: " + e.getMessage());
	        return "";
	    }
	}

  public String getdatevalue(String sheetName, int rowNum, int colNum) {
	    try (FileInputStream fis = new FileInputStream(TESTDATA_SHEET_PATH);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) throw new IllegalArgumentException("Sheet not found: " + sheetName);

	        Row row = sheet.getRow(rowNum);
	        if (row == null) return "";

	        Cell cell = row.getCell(colNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
	        if (cell == null) return "";

	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue().trim();

	            case NUMERIC:
	                double value = cell.getNumericCellValue();

	                // Check if it's a date
	                if (DateUtil.isCellDateFormatted(cell) || (value > 30000 && value < 60000)) {
	                    Date date = DateUtil.getJavaDate(value);
	                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	                    return sdf.format(date);
	                }

	                // Return as number
	                return String.valueOf((int) value);

	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());

	            default:
	                return "";
	        }
	    } catch (Exception e) {
	        System.err.println("Error reading cell: " + e.getMessage());
	        return "";
	    }
	}
	public String getCellData(String sheetName, String colName, int rowNum) {
		if (rowNum <= 0)
			return "";

		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return "";

		sheet = workbook.getSheetAt(index);
		Row headerRow = sheet.getRow(0);
		if (headerRow == null)
			return "";

		int colNum = -1;
		for (int i = 0; i < headerRow.getLastCellNum(); i++) {
			Cell headerCell = headerRow.getCell(i);
			if (headerCell != null && headerCell.getStringCellValue().trim().equalsIgnoreCase(colName.trim())) {
				colNum = i;
				break;
			}
		}

		if (colNum == -1)
			return "";

		Row dataRow = sheet.getRow(rowNum - 1);
		if (dataRow == null)
			return "";
		Cell cell = dataRow.getCell(colNum);
		return cell != null ? getCellValue(cell) : "";
	}

	public String getCellData(String sheetName, int colNum, int rowNum) {
		if (rowNum <= 0)
			return "";

		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return "";

		sheet = workbook.getSheetAt(index);
		Row row = sheet.getRow(rowNum - 1);
		if (row == null)
			return "";
		Cell cell = row.getCell(colNum);
		return cell != null ? getCellValue(cell) : "";
	}

	private static String getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue());
			} else {
				return String.valueOf((long) cell.getNumericCellValue());
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case BLANK:
			return "";
		default:
			return cell.toString();
		}
	}

	/* Surendra Changes for Ministry members */

	public static List<Map<String, String>> readExcel(String path, String sheetName) {
		List<Map<String, String>> dataList = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(path); Workbook workbook = WorkbookFactory.create(fis)) {
			Sheet sheet = workbook.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = headerRow.getLastCellNum();

			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				Map<String, String> data = new HashMap<>();
				for (int j = 0; j < colCount; j++) {
					String key = headerRow.getCell(j).getStringCellValue();
					String value = "";
					Cell cell = row.getCell(j);
					if (cell != null) {
						cell.setCellType(CellType.STRING);
						value = cell.getStringCellValue();
					}
					data.put(key, value);
				}
				dataList.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList;
	}

	public static Map<String, String> getRow(String path, String sheetName, int index) {
		List<Map<String, String>> allData = readExcel(path, sheetName);
		if (index >= 0 && index < allData.size()) {
			return allData.get(index);
		} else {
			throw new RuntimeException("Row index out of range.");
		}
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		js = (JavascriptExecutor) TestBase.getDriver();
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(2000);

		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(2000);

		js.executeScript("$.growl({ title: 'Notification', message: 'Test Execution' });");

		switch (messageType.toLowerCase()) {
		case "error":
			js.executeScript("$.growl.error({ title: 'ERROR', message: '" + message + "' });");
			break;
		case "info":
			js.executeScript("$.growl.notice({ title: 'INFO', message: '" + message + "' });");
			break;
		case "warning":
			js.executeScript("$.growl.warning({ title: 'WARNING', message: '" + message + "' });");
			break;
		default:
			System.out.println("Unknown message type");
		}

		Thread.sleep(2000);
	}
}
