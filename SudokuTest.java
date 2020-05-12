import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class SudokuTest extends TestCase {
    Sudoku easy = new Sudoku(Sudoku.easyGrid);
    Sudoku medium = new Sudoku(Sudoku.mediumGrid);
    Sudoku hard = new Sudoku(Sudoku.hardGrid);
    public static final int[][] seriousGrid = Sudoku.stringsToGrid(
            "3 0 0 0 0 0 0 8 0",
            "0 0 1 0 9 3 0 0 0",
            "0 4 0 7 8 0 0 0 3",
            "0 9 3 8 0 0 0 1 2",
            "0 0 0 0 4 0 0 0 0",
            "5 2 0 0 0 6 7 9 0",
            "6 0 0 0 2 1 0 4 0",
            "0 0 0 5 3 0 9 0 0",
            "0 3 0 0 0 0 0 5 1");


    public static final int[][] superSeriousGrid = Sudoku.stringsToGrid(
            "3 0 0 0 0 0 0 8 0",
            "0 0 0 0 9 3 0 0 0",
            "0 4 0 7 8 0 0 0 3",
            "0 9 3 8 0 0 0 1 2",
            "0 0 0 0 0 0 0 0 0",
            "5 0 0 0 0 6 0 9 0",
            "0 0 0 0 2 0 0 4 0",
            "0 0 0 5 3 0 9 0 0",
            "0 3 0 0 0 0 0 5 1");

    public static final int[][] badGrid = Sudoku.stringsToGrid(
            "3 0 0 0 0 0 0 8 0",
            "0 0 0 0 9 3 0 0 0",
            "0 4 0 7 8 0 0 0 3",
            "0 9 3 2 1 1 1 1 1",
            "0 0 0 0 0 0 0 0 0",
            "5 0 0 0 0 6 0 9 0",
            "0 0 0 0 2 0 0 4 0",
            "0 0 0 5 3 0 9 0 0",
            "0 3 0 0 0 0 0 5 1");
    @Test
    public void test1() {


        int ans = easy.solve();
        assertEquals(1, ans);

       ans = medium.solve();
       assertEquals(1,ans);

       ans = hard.solve();
       assertEquals(1,ans);

       Sudoku serious = new Sudoku(seriousGrid);

       ans = serious.solve();

       assertEquals(6,ans);

       Sudoku superSerious = new Sudoku(superSeriousGrid);
       ans = superSerious.solve();

       assertEquals(100, ans);


    }
    @Test



    public void testElapse(){
        Sudoku serious = new Sudoku(seriousGrid);
        serious.solve();
        Sudoku superSerious = new Sudoku(superSeriousGrid);
        superSerious.solve();
        assertTrue(serious.getElapsed() < 1000);
        assertTrue(superSerious.getElapsed() <1000);
    }
    @Test
    public void testSolutin(){
        Sudoku easy2 = new Sudoku(Sudoku.easyGrid);
        easy2.solve();
        Sudoku expected = new Sudoku("1 6 4 7 9 5 3 8 2 \n" +
                "2 8 7 4 6 3 9 1 5 \n" +
                "9 3 5 2 8 1 4 6 7 \n" +
                "3 9 1 8 7 6 5 2 4 \n" +
                "5 4 6 1 3 2 7 9 8 \n" +
                "7 2 8 9 5 4 1 3 6 \n" +
                "8 1 9 6 4 7 2 5 3 \n" +
                "6 7 3 5 2 9 8 4 1 \n" +
                "4 5 2 3 1 8 6 7 9");
        assertEquals(expected.toString(), easy2.getSolutionText());

        Sudoku Hard = new Sudoku(Sudoku.hardGrid);
        Hard.solve();
        expected = new Sudoku("3 7 5 1 6 2 4 8 9 \n" +
                "8 6 1 4 9 3 5 2 7 \n" +
                "2 4 9 7 8 5 1 6 3 \n" +
                "4 9 3 8 5 7 6 1 2 \n" +
                "7 1 6 2 4 9 8 3 5 \n" +
                "5 2 8 3 1 6 7 9 4 \n" +
                "6 5 7 9 2 1 3 4 8 \n" +
                "1 8 2 5 3 4 9 7 6 \n" +
                "9 3 4 6 7 8 2 5 1");
        assertEquals(Hard.getSolutionText(), expected.toString());


        Sudoku bad = new Sudoku(badGrid);
        bad.solve();
        assertEquals("", bad.getSolutionText());
    }



}
