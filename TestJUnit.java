import org.junit.*;
import static org.junit.Assert.*;

public class TestJUnit {
    private RegisteredGames rg;
    private Game g1, g2, g3;
    
    @Before
    public void before() {
        rg = new RegisteredGames();
        g1 = new Game("Journey", "Thatgamecompany", "PS3", 18);
        g2 = new Game("Skylanders: Giants", "Toys for Bob", "PS3", 7);
        g3 = new Game("Mass Effect 2", "BioWare", "PS3", 18);
    }

    @After
    public void after() {
        System.out.println("Test was successful.");
    }


    /**
     * Test: add(Game g)
     *
     * */

    @Test
    public void test1() {
        assertEquals("Test 1 : ", rg.getList().toString(), "[]");
        rg.add(g1);
        rg.add(g1);
        assertEquals("Test 2 : ", rg.getList().toString(), "[" + g1.toString() + "]");

        rg.add(g1);
        rg.add(g2);
        rg.add(g3);
        assertEquals("Test 3 : ", rg.getList().toString(), "[" + g1.toString() + ", " + g3.toString()
                + ", " + g2.toString() + "]");

        Game g4 = new Game("Mass Effect 2", "BioWare", "Xbox 360", 18);
        rg.add(g4);
        assertEquals("Test 4 : ", rg.getList().toString(), "[" + g1.toString() + ", " + g3.toString()
                + ", " + g4.toString() + ", " + g2.toString() + "]");




    }

    /**
     * Test 2 : setOrder(int number) & getList()
     * */
    @Test
    public void test2() {
        rg.add(g1);
        rg.add(g2);
        rg.add(g3);

        rg.setOrder(0);
        assertEquals("Test 1 : ", rg.getList().toString(), "[" + g1.toString() + ", " + g3.toString()
                + ", " + g2.toString() + "]");

        rg.setOrder(1);
        assertEquals("Test 2 : ", rg.getList().toString(), "[" + g2.toString() + ", " + g1.toString()
                + ", " + g3.toString() + "]");


        Game g4 = new Game("Skylanders: Giants", "Toys for Bob", "Wii U", 7);
        rg.add(g4);
        rg.setOrder(1);

        assertEquals("Test 3 : ", rg.getList().toString(), "[" + g2.toString() + ", " + g4.toString() + ", " +
                g1.toString() + ", " + g3.toString() + "]");

        rg.setOrder(0);

        assertEquals("Test 4 : ", rg.getList().toString(), "[" + g1.toString() + ", " + g3.toString() + ", " +
                g2.toString() + ", " + g4.toString() + "]");


    }


    /**
     * Test 3 : getListPlatforms()
     *
     * */

    @Test
    public void test3() {
        assertEquals("Test 1 : ", rg.getListPlatforms().toString(), "[]");
        rg.add(g1);
        rg.add(g2);
        rg.add(g3);
        assertEquals("Test 2 : ", rg.getListPlatforms().toString(), "[PS3:3]");

        rg.add(new Game("Skylanders: Giants", "Toys for Bob", "Wii U", 7));
        assertEquals("Test 3 : ", rg.getListPlatforms().toString(), "[PS3:3, Wii U:1]");

        Game g4 = new Game("Grand Theft Auto V", "Rockstar North", "Xbox One", 18);
        rg.add(g4);
        assertEquals("Test 4 : ", rg.getListPlatforms().toString(), "[PS3:3, Wii U:1, Xbox One:1]");
        rg.add(g4);
        assertEquals("Test 5 : ", rg.getListPlatforms().toString(), "[PS3:3, Wii U:1, Xbox One:1]");
    }

    public static void main(String[] args) {

    }

}
