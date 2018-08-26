package org.westos.generic;

import java.util.Date;

public class MyTest5 {
    public static void main(String[] args) {
        //泛型统配符 ? 统配任意类型
        Animal<?> objectAnimal = new Animal<Date>();
        //向上限定 右边的泛型只能是他的本身，或者他的父类
        Animal<? super Animal> animal = new Animal<Object>();
        //向下限定 右边的泛型只能是他的本身，或者他的子类
        Animal<? extends Animal> animal2 = new Animal<Dog>();
       // boolean addAll (Collection < ? extends E > c)
    }
}

class Animal<A>{}
class Dog<A> extends Animal<A>{}
class Cat<A> extends  Animal<A>{}
