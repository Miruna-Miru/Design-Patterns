package AdapterPattern.Printer;

public class PrinterAdapter implements Printer {
    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void printDocument(Document document) {
        // The adapter converts the Document into a String and calls the old printer's method.
        oldPrinter.printText(document.getContent());
    }
}
