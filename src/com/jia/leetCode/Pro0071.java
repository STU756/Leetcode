package com.jia.leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Pro0071 {
	public String simplifyPath(String path) {
		LinkedList<String> queue = new LinkedList<String>();
		String[] strs = path.split("/");
		for (int i = 0; i < strs.length; i++) {
			if (!strs[i].equals("")) {
				if (strs[i].equals(".")) {

				} else if (strs[i].equals("..")) {
					if (queue.size() > 0) {
						queue.pollFirst();
					}
				}
				else {
					queue.push(strs[i]);
				}
			}
		}
		if(queue.size() == 0) return "/";
		StringBuilder sb = new StringBuilder();
		while (queue.size() > 0) {
			sb.append("/" + queue.pollLast());
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "/a/./b/../../c/";
		System.out.println(new Pro0071().simplifyPath(str));
	}
}
