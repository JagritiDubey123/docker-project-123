def call(){
  sh 'echo Hi Team, How are you!!!'
  sh "date"
}
def greet(name) {
    println "Hello, $name!"
}
// Define variables and data types
def name = "John"
def age = 30
def fruits = ["apple", "banana", "orange"]
def person = [name: "Alice", age: 25]

// Define a function
def greet(name) {
    println "Hello, $name!"
}

// Control structures
if (age >= 18) {
    println "You are an adult."
} else {
    println "You are a minor."
}

for (fruit in fruits) {
    println "I like $fruit."
}

// Define a class
class Person {
    String name
    int age

    Person(String name, int age) {
        this.name = name
        this.age = age
    }

    void greet() {
        println "Hello, my name is $name and I am $age years old."
    }
}

// Create an object of the class
def personObj = new Person("Alice", 25)
personObj.greet()

