package com.arpita.week1.solid;

public class InvoicePrinter {
    private final Printer printer;

    public InvoicePrinter(Printer printer) {
        this.printer = printer;
    }

    public void printInvoice(Invoice invoice) {
        printer.print("Invoice amount: " + invoice.getAmount());
    }
}
