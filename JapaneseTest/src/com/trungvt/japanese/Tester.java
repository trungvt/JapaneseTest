package com.trungvt.japanese;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Tester {
	private static ArrayList<Grammar> grammarList;
	private static HashMap<String, Grammar> grammarHash;

	public static void main(String[] args) throws IOException {
		System.out.println("OKKKKK");
		grammarList = ExcelReader.readExcelFileForList(args[0]);
		grammarHash = ExcelReader.readExcelFileForHash(args[0]);
		System.out.println(grammarList.size());
		System.out.println(grammarHash.size());
	}
}