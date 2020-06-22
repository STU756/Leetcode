package com.jia;

public class StringTest {
	public static void main(String[] args) {
		Strategy[] strategies = {
				new Strategy() { // [2]
					@Override
					public String approach(String msg) {
						return msg.toUpperCase() + "!";
					}
				},
				msg -> msg.substring(0, 5), // [3]
				Unrelated::twice // [4]
		};
	}
}
interface Strategy {
	String approach(String msg);
}

class Soft implements Strategy {
	@Override
	public String approach(String msg) {
		return msg.toLowerCase() + "?";
	}
}

class Unrelated {
	static String twice(String msg) {
		return msg + " " + msg;
	}
}
