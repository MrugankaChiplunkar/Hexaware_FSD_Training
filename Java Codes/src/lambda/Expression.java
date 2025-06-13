package lambda;
@FunctionalInterface
interface Expression {
    double calculate(double salary);
}

// Using a lambda expression
calculate bonus = (salary) -> salary * 5 / 100;

// Usage
System.out.println(bonus.calculate(50000));  // Output: 2500.0
