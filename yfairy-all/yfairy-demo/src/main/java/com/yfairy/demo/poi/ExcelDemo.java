package com.yfairy.demo.poi;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ExcelDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * HSSF is the POI Project's pure Java implementation of the Excel
		 * '97(-2007) file format. <br>
		 * 1.HSSF普通excel.xls的实现 XSSF is the POI <br>
		 * Project's pure Java implementation of the Excel 2007 OOXML (.xlsx)
		 * file format. <br>
		 * 2.XSSF是POI Project的纯Java实现的Excel 2007 OOXML（.xlsx）文件格式。
		 * 3.忙碌的开发者指南HSSF和XSSF功能：
		 * https://poi.apache.org/spreadsheet/quick-guide.html
		 */
		createWorkBook();
		/**
		 * 读和写 Reading and Rewriting Workbooks
		 * 
		 * InputStream inp = new FileInputStream("workbook.xls"); //InputStream
		 * inp = new FileInputStream("workbook.xlsx");
		 * 
		 * Workbook wb = WorkbookFactory.create(inp); Sheet sheet =
		 * wb.getSheetAt(0); Row row = sheet.getRow(2); Cell cell =
		 * row.getCell(3); if (cell == null) cell = row.createCell(3);
		 * cell.setCellType(CellType.STRING); cell.setCellValue("a test");
		 * 
		 * // Write the output to a file FileOutputStream fileOut = new
		 * FileOutputStream("workbook.xls"); wb.write(fileOut); fileOut.close();
		 * 
		 */
	}

	public static void createWorkBook() throws Exception {
		/**
		 * When opening a workbook, either a .xls HSSFWorkbook, or a .xlsx
		 * XSSFWorkbook, the Workbook can be loaded from either a File or an
		 * InputStream. Using a File object allows for lower memory consumption,
		 * while an InputStream requires more memory as it has to buffer the
		 * whole file. 使用file读取占用的内存更低，内部使用了缓冲 If using WorkbookFactory, it's
		 * very easy to use one or the other:
		 * 
		 * // Use a file Workbook wb = WorkbookFactory.create(new
		 * File("MyExcel.xls"));
		 * 
		 * // Use an InputStream, needs more memory Workbook wb =
		 * WorkbookFactory.create(new FileInputStream("MyExcel.xlsx"));
		 */
		long start = System.currentTimeMillis();
		String basePath = "C:\\Users\\jiangzi\\Desktop";

		List<Man> sourceList = new ArrayList<>();
		Man m1 = new Man("张三", 18, "哈哈", new Date(), new BigDecimal(8888), false);
		Man m2 = new Man("李思", 19, "哈哈", new Date(), new BigDecimal(8881), true);
		Man m3 = new Man("王五", 18, "哈哈", new Date(), new BigDecimal(8882), false);
		Man m4 = new Man("赵六", 20, "哈哈", new Date(), new BigDecimal(8883), true);
		Man m5 = new Man("孙琦", 18, "哈哈", new Date(), new BigDecimal(8885), true);
		sourceList.add(m1);
		sourceList.add(m2);
		sourceList.add(m3);
		sourceList.add(m4);
		sourceList.add(m5);

		Workbook hssfWb = new HSSFWorkbook();
		File hssfFile = new File(basePath, "hssfWb.xls");
		OutputStream hssfOut = new BufferedOutputStream(new FileOutputStream(hssfFile));

		createSheetAndCell(hssfWb, sourceList);

		hssfWb.write(hssfOut);
		hssfOut.close();
		hssfWb.close();

		Workbook xssfWb = new XSSFWorkbook();
		File xssfFile = new File(basePath, "xssfWb.xlsx");
		OutputStream xssfOut = new BufferedOutputStream(new FileOutputStream(xssfFile));

		createSheetAndCell(xssfWb, sourceList);

		xssfWb.write(xssfOut);
		xssfOut.close();
		xssfWb.close();

		long end = System.currentTimeMillis();
		long sub = end - start;
		System.out.println("succe:" + sub + "毫秒.");
	}

	public static void createSheetAndCell(Workbook wb, List<Man> sourceList) {
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		Sheet sheet = wb.createSheet("sheet1");
		for (int i = 0; i < sourceList.size(); i++) {
			Row row = sheet.createRow(i);
			JSONObject jsonObject = JSON
					.parseObject(JSON.toJSONStringWithDateFormat(sourceList.get(i), "yyyy-MM-dd HH:mm:ss"));
			int entrySizeStart = 0;
			for (Entry<String, Object> entry : jsonObject.entrySet()) {
				Object value = entry.getValue();
				if (null != value) {
					if (value instanceof Date) {
						System.out.println("date");
					} else if (value instanceof Long) {
						System.out.println("long");
					}
				}
				Cell cell = row.createCell(entrySizeStart);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(entry.getValue().toString());
				entrySizeStart++;
			}

		}
	}

}
