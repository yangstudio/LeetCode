package yang;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/03/30/20:10
 */
public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            while (num >= 1000) {
                stringBuilder.append(getStr(1000));
                num -= 1000;
            }
            if (num >= 900 && num < 1000) {
                stringBuilder.append(getStr(900));
                num -= 900;
            }
            if (num >= 500 && num < 900) {
                stringBuilder.append(getStr(500));
                num -= 500;
            }
            if (num >= 400 && num < 500) {
                stringBuilder.append(getStr(400));
                num -= 400;
            }
            while (num >= 100 && num < 400) {
                stringBuilder.append(getStr(100));
                num -= 100;
            }
            if (num >= 90 && num < 100) {
                stringBuilder.append(getStr(90));
                num -= 90;
            }
            if (num >= 50 && num < 90) {
                stringBuilder.append(getStr(50));
                num -= 50;
            }
            if (num >= 40 && num < 50) {
                stringBuilder.append(getStr(40));
                num -= 40;
            }
            while (num >= 10 && num < 40) {
                stringBuilder.append(getStr(10));
                num -= 10;
            }
            if (num == 9) {
                stringBuilder.append(getStr(9));
                num -= 9;
            }
            if (num >= 5 && num < 9) {
                stringBuilder.append(getStr(5));
                num -= 5;
            }
            if (num == 4) {
                stringBuilder.append(getStr(4));
                num -= 4;
            }
            while (num >= 1 && num < 4) {
                stringBuilder.append(getStr(1));
                num -= 1;
            }
        }
        return stringBuilder.toString();
    }
    private String getStr(int num) {
        switch (num) {
            case 1 : return "I";
            case 4 : return "IV";
            case 5 : return "V";
            case 9 : return "IX";
            case 10 : return "X";
            case 40 : return "XL";
            case 50 : return "L";
            case 90 : return "XC";
            case 100 : return "C";
            case 400 : return "CD";
            case 500 : return "D";
            case 900 : return "CM";
            case 1000 : return "M";
            default:return "";
        }
    }
}
