package com.trungvt.japanese;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

enum TestMode {
	EXCERCISE, TEST,
}

public class Tester {
	private static ArrayList<Grammar> grammarList;
	private static HashMap<String, Grammar> grammarHash;

	public static void main(String[] args) throws IOException {
		grammarList = ExcelReader.readExcelFileForList(args[0]);
		grammarHash = ExcelReader.readExcelFileForHash(args[0]);
		DoTest();
	}

	private static void DoTest() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TestMode mode = TestMode.EXCERCISE;

		System.out.println("Please choose the studying mode: ");
		System.out.println("Excercise mode ~ 1: ");
		System.out.println("Test mode ~ 2: ");
		try {
			switch (br.readLine()) {
			case "1":
				mode = TestMode.EXCERCISE;
				break;
			case "2":
				mode = TestMode.TEST;
				break;
			default:
				mode = TestMode.EXCERCISE;
				break;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		TestSession(mode);
	}

	private static void TestSession(TestMode mode) {
		String modeString = (mode == TestMode.EXCERCISE) ? "EXCERCISE" : "TEST";
		System.out.println("************* START " + modeString
				+ " *************");
		int length = grammarList.size();
		int totalGrammars = grammarHash.size();
	}
}