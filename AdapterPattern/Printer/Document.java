package AdapterPattern.Printer;

// This represents the new system's expected Document type
public class Document {
    private String content;

    public Document(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}


interface Printer {
    void printDocument(Document document);
}




