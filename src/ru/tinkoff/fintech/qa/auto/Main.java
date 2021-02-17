package ru.tinkoff.fintech.qa.auto;

public class Main {
    
    public static String [] standarter(String phoneNumber){
        String[] changes = new String[2];

        if (phoneNumber.indexOf("+7") == 0){
            phoneNumber = phoneNumber.replace("+7", "8");
            changes[1] = "Замена +7 на 8";
        }

        if (phoneNumber.contains("(") || phoneNumber.contains(")")){
            phoneNumber = phoneNumber.replace("(", "");
            phoneNumber = phoneNumber.replace(")", "");

            if (changes[1] == null){
                changes[1] = "В номере есть скобки";
            } else {
                changes[1] += "; В номере есть скобки";
            }
        }

        if (phoneNumber.contains(" ")){
            phoneNumber = phoneNumber.replace(" ", "");

            if (changes[1] == null){
                changes[1] = "В номере есть пробелы";
            } else {
                changes[1] += "; В номере есть пробелы";
            }
        }

        if (changes[1] == null){
            changes[1] = "Не было изменений";
        }

        if(phoneNumber.length() != 11){
            changes[0] = "Введён некорректный номер";
        } else {
            changes[0] = phoneNumber;
        }

        return changes;

    }

    public static void main(String[] args) {
        String number = "+7 (978) 000 00 28";
        String[] output = standarter(number);
        for (String s : output)
            if (s != null) {
                System.out.println(s);
            }

    }
}
