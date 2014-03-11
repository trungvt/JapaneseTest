package com.trungvt.japanese;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static HashMap<String, Grammar> readExcelFileForHash(String fileUrl)
			throws IOException {
		HashMap<String, Grammar> result = new HashMap<>();
		XSSFSheet sheet = getSheetByDefault(fileUrl);
		Iterator<Row> rows = sheet.iterator();
		while (rows.hasNext()) {
			Row currentRow = rows.next();
			Grammar currentGrammar = new Grammar(currentRow.getCell(0)
					.toString(), currentRow.getCell(1).toString(), currentRow
					.getCell(2).toString(), currentRow.getCell(3).toString(),
					currentRow.getCell(4).toString());
			result.put(currentRow.getCell(0).toString(), currentGrammar);
		}
		return result;
	}

	public static ArrayList<Grammar> readExcelFileForList(String fileUrl)
			throws IOException {
		ArrayList<Grammar> result = new ArrayList<Grammar>();
		XSSFSheet sheet = getSheetByDefault(fileUrl);
		Iterator<Row> rows = sheet.iterator();
		while (rows.hasNext()) {
			Row currentRow = rows.next();
			Grammar currentGrammar = new Grammar(currentRow.getCell(0)
					.toString(), currentRow.getCell(1).toString(), currentRow
					.getCell(2).toString(), currentRow.getCell(3).toString(),
					currentRow.getCell(4).toString());
			result.add(currentGrammar);
		}
		return result;
	}

	private static XSSFSheet getSheetByDefault(String fileUrl) {
		XSSFSheet sheet = null;
		try {
			File inputFile = new File(fileUrl);
			FileInputStream fileInputStream = new FileInputStream(inputFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sheet;
	}
}
