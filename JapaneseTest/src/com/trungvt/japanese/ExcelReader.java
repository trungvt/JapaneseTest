package com.trungvt.japanese;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static HashMap<String, Grammar> readExcelFileForHash(String fileUrl)
			throws IOException {
		HashMap<String, Grammar> result = new HashMap<>();
		XSSFSheet sheet = getSheetByDefault(fileUrl);

		return result;
	}

	public static ArrayList<Grammar> readExcelFileForList(String fileUrl)
			throws IOException {
		ArrayList<Grammar> result = new ArrayList<Grammar>();
		XSSFSheet sheet = getSheetByDefault(fileUrl);

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
