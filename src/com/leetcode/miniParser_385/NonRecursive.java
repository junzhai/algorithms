package com.leetcode.miniParser_385;

import com.leetcode.common.NestedInteger;

import java.util.Stack;

public class NonRecursive extends Solution {
    @Override
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> st = new Stack<>();
        int n = 0;
        boolean neg = false, num = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = true;
                n = n * 10 + (ch - '0');
            } else if (ch == '-') {
                num = true;
                neg = true;
            } else if (ch == ',' || ch == ']') {
                if (num) {
                    if (neg) {
                        n = -n;
                    }
                    st.peek().add(new NestedInteger(n));
                    num = false;
                    neg = false;
                    n = 0;
                }
                if (ch == ']') {
                    if (st.size() > 1) {
                        NestedInteger v = st.pop();
                        st.peek().add(v);
                    }
                }
            } else {
                st.push(new NestedInteger());
            }
        }

        if (num) {
            if (neg) {
                n = -n;
            }
            return new NestedInteger(n);
        }
        return st.peek();
    }
}
