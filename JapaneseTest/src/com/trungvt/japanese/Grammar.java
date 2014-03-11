package com.trungvt.japanese;

public class Grammar {
	private String index;
	private String content;
	private String explaination;
	private String note;
	private String example;

	public Grammar(String _index, String _content, String _explaination,
			String _note, String _example) {
		this.index = _index;
		this.content = _content;
		this.explaination = _explaination;
		this.note = _note;
		this.example = _example;
	}

	public String getIndex() {
		return this.index;
	}

	public String getContent() {
		return this.content;
	}

	public String getExplaination() {
		return this.explaination;
	}

	public String getNote() {
		return this.note;
	}

	public String getExample() {
		return this.example;
	}
}
