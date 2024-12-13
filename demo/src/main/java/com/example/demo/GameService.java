package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameService {

    private static final String[] WORDS = { "ДУРАК", "MIDTERM", "РАКЕТА", "CHEVROLET" };
    private String targetWord;
    private List<Integer> codeList;

    // Начало новой игры
    public String startNewGame() {
        targetWord = WORDS[new Random().nextInt(WORDS.length)];  // Выбираем случайное слово из массива
        codeList = generateCodeList(targetWord.length());  // Генерируем список кодов для букв
        return targetWord;
    }

    // Генерация случайных кодов
    private List<Integer> generateCodeList(int length) {
        List<Integer> codes = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            codes.add(i);
        }
        Collections.shuffle(codes); // Перемешиваем коды
        return codes;
    }

    // Получение строки с кодами букв
    public String getCodeWordString() {
        StringBuilder sb = new StringBuilder();
        for (Integer code : codeList) {
            sb.append(code).append(" ");
        }
        return sb.toString().trim();
    }

    // Проверка введенного слова
    public boolean isValidWord(String input) {
        return input.equals(targetWord);
    }

    // Получение загаданного слова
    public String getTargetWord() {
        return targetWord;
    }
}
