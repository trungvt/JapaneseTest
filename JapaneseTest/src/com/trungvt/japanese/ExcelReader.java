package com.trungvt.japanese;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader {
	private static final int MAX_ROWS = 100;

	public static HashMap<String, Grammar> readExcelFileForHash(String fileUrl)
			throws IOException {
		HashMap<String, Grammar> result = new HashMap<>();
		Sheet sheet = getSheetByDefault(fileUrl);
		for (int i = 0; i < MAX_ROWS; i++) {
			Cell[] cells = sheet.getRow(i);
			result.put(cells[0].getContents(),
					new Grammar(cells[0].getContents(), cells[1].getContents(),
							cells[2].getContents(), cells[3].getContents(),
							cells[4].getContents()));
		}
		return result;
	}

	public static ArrayList<Grammar> readExcelFileForList(String fileUrl)
			throws IOException {
		ArrayList<Grammar> result = new ArrayList<Grammar>();
		Sheet sheet = getSheetByDefault(fileUrl);
		for (int i = 0; i < MAX_ROWS; i++) {
			Cell[] cells = sheet.getRow(i);
			result.add(new Grammar(cells[0].getContents(), cells[1]
					.getContents(), cells[2].getContents(), cells[3]
					.getContents(), cells[4].getContents()));
		}
		return result;
	}

	private static Sheet getSheetByDefault(String fileUrl) throws IOException {
		Sheet sheet = null;
		File excelFile = new File(fileUrl);
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(excelFile);
			sheet = workbook.getSheet(0);
			return sheet;
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return sheet;
	}
}
