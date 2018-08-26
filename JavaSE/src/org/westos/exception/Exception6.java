package org.westos.exception;

import java.io.FileNotFoundException;

public class Exception6 {
}

class Super {
    public void test() throws FileNotFoundException {
        System.out.println("super test..");
    }
}

class Sub extends Super{
    public void test()  {
        System.out.println("sub test..");
    }
}
