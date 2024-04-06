package az.springbootlessons.sudokusolverbot;


import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class SeleniumService {
    private final WebDriver driver;

    @Autowired
    public SeleniumService(WebDriver driver) {
        this.driver = driver;
    }

    public void doSomething() {
        int[][] puzzle = new int[9][9];
        driver.get("https://www.sudokuonline.io/");
        System.out.println("Running selenium service...");
        WebElement table = driver.findElement(By.id("sudoku"));
        System.out.println(table.getTagName());
        List<WebElement> td = driver.findElements(By.cssSelector("div#sudoku > div.cell"));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(Objects.equals(td.get(i * 9 + j).getAttribute("data-value"), "") ? "0" : td.get(i * 9 + j).getAttribute("data-value"));
                puzzle[i][j] = Objects.equals(td.get(i * 9 + j).getAttribute("data-value"), "") ? 0 : Integer.parseInt(td.get(i * 9 + j).getAttribute("data-value"));
            }
            System.out.println();
        }
        SudokuSolver sudokuSolver = new SudokuSolver(puzzle);
        sudokuSolver.solve();
        System.out.println(puzzle[0][0]);
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                JavascriptExecutor js = (JavascriptExecutor) driver;
//                js.executeScript("document.querySelector('div#sudoku > div.cell:nth-child(" + (i * 9 + j + 1) + ")').setAttribute('data-value', '" + puzzle[i][j] + "')");
//            }
//        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("document.querySelector('div#sudoku > div.cell:nth-child(" + (i * 9 + j + 1) + ")').setAttribute('data-value', '" + puzzle[i][j] + "')");
                td.get(i * 9 + j).sendKeys(Keys.ARROW_RIGHT);
            }
            td.get(
                    i * 9 + 8
            ).sendKeys(Keys.ARROW_DOWN);
        }
    }

}
