package chapter2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public StringCalculator() {
    }

    public int calc(String data){
        if(checkIsEmpty(data)) return 0;

        return sum(checkValues(split(data)));
    }

    protected boolean checkIsEmpty(String data) {
        return data == null || data.isEmpty();
    }

    protected String[] split(String data) {
        if(data.contains(":") || data.contains(",")) {
            return data.split(",|:");
        }

        return customSplit(data);
    }

    protected String[] customSplit(String data) {

        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(data);

        String[] arr = null;
        if(matcher.find()) {
            String d = matcher.group(1);
            arr = matcher.group(2).split(d);
        }

        return arr;
    }

    protected int sum(String[] data) {
        int sum = 0;
        for (String el : data) {
            sum += Integer.parseInt(el);
        }
        return sum;
    }

    protected String[] checkValues(String[] data) {
        for (String el : data) {
            if(Integer.parseInt(el) < 0) throw new RuntimeException("Invalid number");
        }

        return data;
    }
}
