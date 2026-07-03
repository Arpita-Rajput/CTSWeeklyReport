package com.arpita.week1.solid;

public class SolidDemo {
    public static void main(String[] args) {
        // Single Responsibility
        Invoice invoice = new Invoice(100.0);
        InvoicePrinter printer = new InvoicePrinter(new ConsolePrinter());
        printer.printInvoice(invoice);

        // Open/Closed - shape area calculator
        AreaCalculator calculator = new AreaCalculator();
        calculator.addShape(new Circle(5));
        calculator.addShape(new Rectangle(4, 3));
        System.out.println("Total area: " + calculator.totalArea());

        // Liskov - subclasses usable through base types
        Bird sparrow = new FlyingBird("Sparrow");
        sparrow.fly();

        // Dependency Inversion - depend on abstraction
        NotificationSender sender = new NotificationSender(new ConsoleNotifier());
        sender.send("Dependency inversion example");
    }
}
