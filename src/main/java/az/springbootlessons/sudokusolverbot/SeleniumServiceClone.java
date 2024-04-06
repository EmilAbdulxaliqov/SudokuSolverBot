package az.springbootlessons.sudokusolverbot;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class SeleniumServiceClone {
    private final WebDriver driver;

    @Autowired
    public SeleniumServiceClone(WebDriver driver) {
        this.driver = driver;
    }

    public void doSomething() {
        int[][] puzzle = new int[9][9];
        driver.get("https://sudoku.com.au/");
        System.out.println("Running selenium service...");
        WebElement table = driver.findElement(By.id("sudokutable"));
        List<WebElement> td = driver.findElements(By.cssSelector("table#sudokutable td"));
        int count = 0;
        for (WebElement element : td) {
            System.out.print(Objects.equals(element.getText(), " ") ? "0" : element.getText());
            puzzle[count / 9][count % 9] = Objects.equals(element.getText(), " ") ? 0 : Integer.parseInt(element.getText());
            count++;
        }
        for (int[] ints : puzzle) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println(table.getTagName());
//        SudokuSolver.
        SudokuSolver sudokuSolver = new SudokuSolver(puzzle);
        sudokuSolver.solve();
        sudokuSolver.printBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!Objects.equals(td.get(i * 9 + j).getText(), " ")) {
                    td.get(i * 9 + j).clear();
                }
            }
        }
//        driver.quit();
    }

}
