package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HelloController {

    @FXML
    private Label codeWordLabel;  // Метка для CODE WORD
    @FXML
    private HBox gridPanel;      // Панель для отображения букв
    @FXML
    private TextField inputField; // Поле для ввода слова

    private GameService gameService;  // Сервис для игры
    private LetterGrid letterGrid;   // Сервис для отображения букв

    public HelloController() {
        gameService = new GameService();
        letterGrid = new LetterGrid();
    }

    // Метод для начала новой игры
    @FXML
    private void onStartButtonClick() {
        startNewGame();
    }

    // Метод для начала новой игры
    private void startNewGame() {
        String targetWord = gameService.startNewGame();  // Получаем новое слово
        codeWordLabel.setText("CODE WORD: " + gameService.getCodeWordString());

        // Обновляем отображение букв
        letterGrid.displayGrid(gridPanel, targetWord);
    }

    // Метод для проверки введенного слова
    @FXML
    private void checkWord() {
        String input = inputField.getText().toUpperCase().trim();  // Получаем введенное слово
        if (gameService.isValidWord(input)) {
            System.out.println("Поздравляем! Вы угадали слово: " + gameService.getTargetWord());
            // Запускаем новую игру
            startNewGame();
        } else {
            System.out.println("Неправильно. Попробуйте снова.");
        }
    }

    // Получение главного вида игры
    public VBox getMainGameView() {
        VBox vbox = new VBox(20);  // Используем VBox с отступами
        vbox.setSpacing(10);
        vbox.getChildren().addAll(codeWordLabel, gridPanel, inputField);  // Добавляем элементы в VBox
        return vbox;
    }
}
