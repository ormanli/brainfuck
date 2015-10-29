package com.serdarormanli.brainfuck.data;

public class InputData {
	private static final int LENGTH = 30000;
	private int index = 1;
	private int[] data = new int[index + LENGTH];

	public void incrementIndex() {
		if (index < data.length) {
			index++;
		}
	}

	public void decrementIndex() {
		if (index > 1) {
			index--;
		}
	}

	public int getCurrentData() {
		return data[index];
	}

	public void setCurrentData(int value) {
		data[index] = value;
	}

	public void incrementData() {
		data[index]++;
	}

	public void decrementData() {
		data[index]--;
	}
}
