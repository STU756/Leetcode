package com.jia.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Pro0140 {
	 public List<String> wordBreak(String s, Set<String> wordDict) {
	        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	        return wordBreak(s, wordDict, map);
	    }

	    public List<String> wordBreak(String s, Set<String> wordDict,HashMap<String, List<String>> partialSolutions) {
	        if (partialSolutions.containsKey(s))
	            return partialSolutions.get(s);
	        List<String> solutionForThisWord = new ArrayList<String>();
	        if (s.length() < 1) {
	            solutionForThisWord.add("");
	            return solutionForThisWord;
	        }
	        for (String eachCandidateWord : wordDict) {
	            if (s.startsWith(eachCandidateWord)) {
	                List<String> nextSolutions = wordBreak(s.replaceFirst(eachCandidateWord, ""), wordDict, partialSolutions);
	                for (String eachNextSolution : nextSolutions) {
	                    if (eachNextSolution.length() > 0)
	                        solutionForThisWord.add(eachCandidateWord + " " + eachNextSolution);
	                    else
	                        solutionForThisWord.add(eachCandidateWord);
	                }
	            }
	        }
	        partialSolutions.put(s, solutionForThisWord);
	        return solutionForThisWord;
	    }
}
