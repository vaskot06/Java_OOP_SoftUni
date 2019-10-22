package Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : urls) {
            boolean invalidUrlFound = false;
            for (int i = 0; i < url.length(); i++) {
                if (url.charAt(i) >= 48 && url.charAt(i) <= 57) {
                    sb.append("Invalid URL!").append(System.lineSeparator());
                    invalidUrlFound = true;
                    break;
                }
            }
            if (!invalidUrlFound) {
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            boolean invalidNumberFound = false;
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) < 48 || number.charAt(i) > 57) {
                    sb.append("Invalid number!").append(System.lineSeparator());
                    invalidNumberFound = true;
                    break;
                }
            }
            if (!invalidNumberFound) {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
