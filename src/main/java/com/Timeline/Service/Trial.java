package com.Timeline.Service;

import java.util.ArrayList;

public class Trial {
	public static void main(String[] args) {
		ArrayList<String> timeId = new ArrayList<String>();
		timeId.add("timeline_1");
		timeId.add("timeline_2");
		timeId.add("timeline_3");
		timeId.add("timeline_4");

		int j = 2;

		for (int k = j; k <= timeId.size(); k--) {

			System.out.println("values of k is : " + k);
			if (k == 0)
				break;

		}

	}
}
