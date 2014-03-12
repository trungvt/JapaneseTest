package com.trungvt.japanese;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

enum TestMode {
	EXCERCISE, TEST,
}

public class Tester {
	private static ArrayList<Grammar> grammarList;

	public static void main(String[] args) throws IOException {
		grammarList = ExcelReader.readExcelFileForList(args[0]);
		DoTest();
	}

	private static void DoTest() throws IOException {
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

	private static void TestSession(TestMode mode) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Grammar> tempList = new ArrayList<>(grammarList);
		String modeString = (mode == TestMode.EXCERCISE) ? "EXCERCISE" : "TEST";
		System.out.println("************* START " + modeString
				+ " *************");
		Random random = new Random();
		int randomNext = 0;
		int length = grammarList.size();
		int totalGrammars = length;
		int score = 0;
		while (length > 0) {
			// display the content of testing grammar
			randomNext = random.nextInt(length);
			Grammar grammarTest = tempList.get(randomNext);
			if (grammarTest != null) {
				System.out.println();
				System.out.println("+++++++++++++++++++++++++++++++++++++++");
				System.out.println(grammarTest.getContent());
				System.out.println("+++++++++++++++++++++++++++++++++++++++");
			} else {
				System.out.println("Something wrong here!");
				return;
			}
			// take 3 random grammars to build the quiz
			ArrayList<Grammar> quizList = quizGrammarList(grammarTest);
			int correctAnswerIndex = quizList.indexOf(grammarTest);
			System.out.println("Please choose one of these options: ");
			for (int i = 0; i < quizList.size(); i++) {
				System.out.println("\t" + (i + 1) + " - "
						+ quizList.get(i).getExplaination());
			}
			String input = "";
			System.out.print("Your choice: ");
			input = br.readLine();
			if (input.equalsIgnoreCase("q")) {
				return;
			} else if (input.equalsIgnoreCase("help")) {
				if (mode.equals(TestMode.EXCERCISE)) {
					showContent(grammarTest.getExplaination());
				} else {
					showContent("Opps! No cheat in test class huh!");
				}
			}
			if (input.equalsIgnoreCase(String.valueOf(correctAnswerIndex))) {
				showContent("CORRECT");
				length--;
				if (mode == TestMode.TEST) {
					score++;
				}
				showContent("DETAILS: " + grammarTest.getNote());
				showContent(grammarTest.getExample());
				tempList.remove(grammarTest);
			} else {
				
			}
		}
	}

	private static ArrayList<Grammar> quizGrammarList(Grammar currentGrammar) {
		ArrayList<Grammar> result = new ArrayList<Grammar>();
		Random random = new Random();
		int randomNext = 0;
		while (result.size() < 3) {
			randomNext = random.nextInt(grammarList.size());
			if (randomNext != grammarList.indexOf(currentGrammar)) {
				Grammar newQuizGrammar = grammarList.get(randomNext);
				if (newQuizGrammar != null) {
					result.add(newQuizGrammar);
				}
			}
		}
		result.add(random.nextInt(4), currentGrammar);
		return result;
	}

	private static void showContent(String input) {
		System.out.println(input);
	}
}