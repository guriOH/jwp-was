package chapter2;

public class StringCalculator {

    public StringCalculator() {
    }

    public int calc(String data){
        if(data == null || data.isEmpty()) return 0;
        return sum(split(data));
    }

    public String[] split(String data) {
        if(data.contains(":") || data.contains(",")) {
            return data.split(",|:");
        }else
            return customSplit(data);
    }

    public String[] customSplit(String data) {
        String[] temp = data.split("\n");
        return temp[1].split(String.valueOf(temp[0].charAt(temp[0].length()-1)));
    }

    public int sum(String[] data) {
        int sum = 0;
        for (String el : data) {
            if(validate(el)) {
                sum += Integer.parseInt(el);
            }
        }
        return sum;
    }

    public boolean validate(String data) {
        if(Integer.parseInt(data) < 0)
            throw new RuntimeException("Invalid number");
        return true;
    }
}
