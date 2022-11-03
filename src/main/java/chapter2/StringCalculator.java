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
        for (String c : data) {
            if(validate(c)) {
                sum += Integer.parseInt(c);
            }
        }
        return sum;
    }

    public boolean validate(String c) {
        if(Integer.parseInt(c) < 0)
            throw new RuntimeException("Invalid number");
        return true;
    }
}
