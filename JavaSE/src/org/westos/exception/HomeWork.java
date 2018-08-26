package org.westos.exception;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {

    }

    public static void test1(){
        System.out.println("main 1");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ma(n);
        System.out.println("main2");
    }

    public static void ma(int n) {
        try {
            System.out.println("ma1");
            mb(n);
            System.out.println("ma2");
        } catch (EOFException e) {
            System.out.println("Catch EOFException");
        } catch (IOException e) {
            System.out.println("Catch IOException");
        } catch (SQLException e) {
            System.out.println("Catch SQLException");
        } catch (Exception e) {
            System.out.println("Catch Exception");
        } finally {
            System.out.println("In finally");
        }
    }

    public static void mb(int n) throws Exception {
        System.out.println("mb1");
        if (n == 1) throw new EOFException();
        if (n == 2) throw new FileNotFoundException();
        if (n == 3) throw new SQLException();
        if (n == 4) throw new NullPointerException();
        System.out.println("mb2");
    }
}

class Father {
    public void ma() throws IOException {
    }
}
interface IA {
    void mb();
}
class TestException extends Father implements IA {
    public void ma() throws IOException{
    }
    public void mb() {
    }
}


