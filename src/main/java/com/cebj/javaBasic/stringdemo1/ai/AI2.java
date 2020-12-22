package com.cebj.javaBasic.stringdemo1.ai;

import java.util.Scanner;

public class AI2 {
    private boolean replied = false;

    public String answer(String question) {
        String ret = replyCanStart(question);
        ret = (ret == null)? replyAsk(question) : ret;
        ret = (ret == null)? question + "! " : ret;
        return ret;
    }

    private String replyCanStart(String question) {
        String[] canStart = new String[]{"会", "能", "有", "敢", "在"};
        for (int i = 0; i < canStart.length && (!replied); i++) {
            if (question.startsWith(canStart[i])) {
                replied = true;
                return canStart[i] + "!";
            }
        }
        return null;
    }

    private String replyAsk(String question) {
        String[] askTail = new String[]{"吗？", "吗?", "吗"};
        for (int i = 0; i < askTail.length && (!replied); i++) {
            if (question.endsWith(askTail[i])) {
                replied = true;
                return question.replace(askTail[i], "! ");
            }
        }
        return null;
    }
}
