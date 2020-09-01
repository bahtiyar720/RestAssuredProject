package day01;

import org.junit.jupiter.api.*;

public class beforeAfterJunit5 {
    @BeforeAll //this method run only once before the entire test
    public static void setUp(){
        System.out.println("this run before all");
    }
    @BeforeEach
    public  void beforeEachTest(){
        System.out.println("running before each test");
    }
    @AfterEach
    public  void afterEachTest(){
        System.out.println("running after each test");
    }
    @Test
    public void test01(){
        System.out.println("test01 is running");
    }
    @Test
    public void test02(){
        System.out.println("test02 is running");
    }
    @AfterAll
    public static void tearDown(){
        System.out.println("this run all the way at the end");
    }

}
