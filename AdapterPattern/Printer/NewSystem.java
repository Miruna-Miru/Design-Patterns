package AdapterPattern.Printer;

public class NewSystem {
    public static void main(String[] args) {
        // New system expects a Printer interface
        Printer printer = new PrinterAdapter(new OldPrinter());                                                        

        // Create a Document object
        Document document = new Document("This is a document");

        // Use the adapter to print the document
        printer.printDocument(document);
    }
}
