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
	public static HashMap<String, Grammar> readExcelFileForHash(String fileUrl)
			throws IOException {
		HashMap<String, Grammar> result = new HashMap<>();
		Sheet sheet = getSheetByDefault(fileUrl);
		for (int i = 0; i < sheet.getRows(); i++) {
			Cell[] cells = sheet.getRow(i);
			result.put(
					cells[0].toString(),
					new Grammar(cells[0].toString(), cells[1].toString(),
							cells[2].toString(), cells[3].toString(), cells[4]
									.toString()));
		}
		return result;
	}

	public static ArrayList<Grammar> readExcelFileForList(String fileUrl)
			throws IOException {
		ArrayList<Grammar> result = new ArrayList<Grammar>();
		Sheet sheet = getSheetByDefault(fileUrl);
		for (int i = 0; i < sheet.getRows(); i++) {
			Cell[] cells = sheet.getRow(i);
			result.add(new Grammar(cells[0].toString(), cells[1].toString(),
					cells[2].toString(), cells[3].toString(), cells[4]
							.toString()));
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
