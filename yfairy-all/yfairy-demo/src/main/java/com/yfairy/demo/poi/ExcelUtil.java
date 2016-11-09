package com.yfairy.demo.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yfairy.common.utils.DateUtil;

public class ExcelUtil {

	public static <T> void write(OutputStream outputStream, List<String> titles, List<String> fieds,
			List<T> sourceDatas) {
		Workbook wb = null;
		try {
			wb = new XSSFWorkbook();
			CreationHelper createHelper = wb.getCreationHelper();

			CellStyle cellStyle = wb.createCellStyle();
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			// 单元格
			Sheet sheet0 = wb.createSheet();
			// 写标题行
			Row row0 = sheet0.createRow(0);
			for (int i = 0; i < titles.size(); i++) {
				String titleTemp = titles.get(i) == null ? "" : titles.get(i);
				Cell cell = row0.createCell(i);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(titleTemp);
			}
			// 写data
			for (int i = 0; i < sourceDatas.size(); i++) {
				T item = sourceDatas.get(i);
				if (null != item) {
					JSONObject rowData = JSON.parseObject(JSON.toJSONStringWithDateFormat(item, "yyyy-MM-dd HH:mm:ss"));
					// 写改行数据
					Row row = sheet0.createRow((i + 1));
					for (int j = 0; j < titles.size(); j++) { // 遍历字段，写行中的每列
						String key = fieds.get(j);
						Object columnVal = rowData.get(key);

						Cell cell = row.createCell(j);
						cell.setCellStyle(cellStyle);
						if (null != columnVal) {
							if (columnVal instanceof Integer) {
								cell.setCellValue((Integer) columnVal);
							} else if (columnVal instanceof Float) {
								cell.setCellValue((Float) columnVal);
							} else if (columnVal instanceof Double) {
								cell.setCellValue((Double) columnVal);
							} else if (columnVal instanceof BigDecimal) {
								cell.setCellValue(new BigDecimal(columnVal.toString()).doubleValue());
							} else if (columnVal instanceof Boolean) {
								cell.setCellValue((Boolean) columnVal);
							} else if (columnVal instanceof String) {
								if (DateUtil.isDateTime(columnVal.toString())) {
									// 日期
									CellStyle datecellStyle = wb.createCellStyle();
									datecellStyle.setDataFormat(
											createHelper.createDataFormat().getFormat(DateUtil.YYYY_MM_DD_HH_MM_SS));
									datecellStyle.setAlignment(CellStyle.ALIGN_CENTER);
									datecellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
									cell.setCellStyle(datecellStyle);
									cell.setCellValue(DateUtil.parseDateTime(columnVal.toString()));
								} else {
									cell.setCellValue(columnVal.toString());
								}
							} else {
								cell.setCellValue(columnVal.toString());
							}
						} else {
							cell.setCellValue("");
						}

					}

				}
			}

			wb.write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != outputStream) {
					outputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		String basePath = "C:\\Users\\jiangzi\\Desktop";

		List<Man> sourceList = new ArrayList<>();
		Man m1 = new Man("张三", 18, "哈哈", new Date(), new BigDecimal(8888.88), false);
		Man m2 = new Man("李思", 19, "哈哈", new Date(), new BigDecimal(8881.88), true);
		Man m3 = new Man("王五", 18, "哈哈", new Date(), new BigDecimal(8882.88), false);
		Man m4 = new Man("赵六", 20, "哈哈", new Date(), new BigDecimal(8883.88), true);
		Man m5 = new Man("孙琦", 18, "哈哈", new Date(), new BigDecimal(8885.88), true);
		sourceList.add(m1);
		sourceList.add(m2);
		sourceList.add(m3);
		sourceList.add(m4);
		sourceList.add(m5);
		for (int i = 0; i < 3000; i++) {
			sourceList.add(m2);
		}
		List<String> titles = Arrays.asList("姓名", "性别", "年龄", "生日", "金钱", "婚否");
		List<String> fieds = Arrays.asList("name", "sex", "age", "birthday", "money", "marry");
		write(new FileOutputStream(new File(basePath, "工作薄.xlsx")), titles, fieds, sourceList);
		long end = System.currentTimeMillis();
		long sub = end - start;
		System.out.println("succe:" + sub + "毫秒.");
	}

}
