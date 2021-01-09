package com.example.java_and_kotlin_g11

class Person{
    private var name: String
    private var age: Int

    constructor(strName: String, newAge: Int) {
        this.name = strName;
        this.age = newAge;
    }

    fun getInfo(): String {
        return "${name} ${age}";
    }
    fun getName(): String {
        return name;
    }
}