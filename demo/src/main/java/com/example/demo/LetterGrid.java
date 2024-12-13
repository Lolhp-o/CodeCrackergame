package com.example.demo;

import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LetterGrid {

    // Отображаем буквы в случайном порядке на панели
    public void displayGrid(HBox gridPanel, String targetWord) {
        gridPanel.getChildren().clear();  // Очищаем текущие элементы

        // Перемешиваем буквы
        List<Character> letters = new ArrayList<>();
        for (char letter : targetWord.toCharArray()) {
            letters.add(letter);
        }
        Collections.shuffle(letters);  // Перемешиваем буквы

        // Добавляем метки с буквами в gridPanel
        for (char letter : letters) {
            gridPanel.getChildren().add(createLetterLabel(letter));  // Создаем и добавляем метки с буквами
        }
    }

    // Создание метки с буквой
    private Label createLetterLabel(char letter) {
        Label label = new Label(String.valueOf(letter));
        label.setStyle("-fx-font-size: 18px; -fx-text-fill: #F4E95C;");
        return label;
    }
}
