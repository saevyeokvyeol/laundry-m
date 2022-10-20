package com.laundry_m.mvc.laundry_m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {
    public String[] solution(String[] orders) {
    	Map<String, Set<String>> map = new HashMap<>();
    	
    	for (String o : orders) {
    		List<String> order = Arrays.asList(o.split(" "));
    		boolean flag = true;
    		Set<String> set = null;
    		if (map.get(order.get(0)) != null) {
    			set = map.get(order.get(0));
    		} else {
    			set = new HashSet<>();
    		}
    		set.addAll(order);
    		map.put(order.get(0), set);
		}
    	
    	int max = 0;
        List<String> a = new ArrayList<>();
    	for (String str : map.keySet()) {
    		if (map.get(str).size() > max) {
    			max = map.get(str).size();
    			a.clear();
    			a.add(str);
    		} else if (map.get(str).size() == max) {
    			a.add(str);
    		}
    	}
    	
    	Collections.sort(a);
    	String[] answer = new String[a.size()];
    	int i = 0;
    	for (String s : a) {
    		answer[i++] = s;
    	}
    	
        return answer;
    }
    
    public boolean solution(int[] arr) {
    	boolean answer = true;
    	Stack<Integer> num = new Stack<>();
    	Stack<Integer> stack = new Stack<>();
    	for (int i = 100000; i >= 1; i--) {
    		num.add(i);
    	}
    	
		for (int j : arr) {
			while (!num.isEmpty() && num.peek() < j) {
				stack.add(num.pop());
			}
			
			if (!num.isEmpty() && j == num.peek()) num.pop();
			else if (!stack.isEmpty() && j == stack.peek()) stack.pop();
			else {
				answer = false;
				break;
			}
		}
    	
        return answer;
    }
    
    public long[] solution(long n) {
        long []answer = {0,0};
        answer[0] = (n / 7 * 2);
        if (n % 7 == 6) answer[0] += 1;

        answer[1] = (n / 7) * 2;
        if (n % 7 == 1) answer[1] += 1;
        else if (n % 7 > 1) answer[1] += 2;
        
        return answer;
    }
}
