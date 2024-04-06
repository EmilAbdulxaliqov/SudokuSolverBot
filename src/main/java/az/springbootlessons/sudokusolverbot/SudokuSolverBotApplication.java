package az.springbootlessons.sudokusolverbot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SudokuSolverBotApplication implements CommandLineRunner {
    private final SeleniumService seleniumService;

    public SudokuSolverBotApplication(SeleniumService seleniumService) {
        this.seleniumService = seleniumService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SudokuSolverBotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        int[][] puzzle = {
//                {5, 3, 0, 0, 7, 0, 0, 0, 0},
//                {6, 0, 0, 1, 9, 5, 0, 0, 0},
//                {0, 9, 8, 0, 0, 0, 0, 6, 0},
//                {8, 0, 0, 0, 6, 0, 0, 0, 3},
//                {4, 0, 0, 8, 0, 3, 0, 0, 1},
//                {7, 0, 0, 0, 2, 0, 0, 0, 6},
//                {0, 6, 0, 0, 0, 0, 2, 8, 0},
//                {0, 0, 0, 4, 1, 9, 0, 0, 5},
//                {0, 0, 0, 0, 8, 0, 0, 7, 9}
//        };
//        SudokuSolver solver = new SudokuSolver(puzzle);
//        if (solver.solve()) {
//            solver.printBoard();
//        } else {
//            System.out.println("No solution found");
//        }
        System.out.println("Sudoku solver bot is running...");
        seleniumService.doSomething();
    }
}
