package StatePattern;



interface State {
    void publish(Document doc);
    void review(Document doc);
}

class DraftState implements State {
    public void publish(Document doc) {
        System.out.println("Moving to moderation.");
        doc.setState(new ModerationState());
    }
    public void review(Document doc) {
        System.out.println("Draft cannot be reviewed.");
    }
}

class ModerationState implements State {
    public void publish(Document doc) {
        System.out.println("Publishing document.");
        doc.setState(new PublishedState());
    }
    public void review(Document doc) {
        System.out.println("Reviewing document in moderation.");
    }
}

class PublishedState implements State {
    public void publish(Document doc) {
        System.out.println("Document already published.");
    }
    public void review(Document doc) {
        System.out.println("Published document cannot be reviewed.");
    }
}

class Document {
    private State state;
    public Document() {
        state = new DraftState();
    }
    public void setState(State state) {
        this.state = state;
    }
    public void publish() {
        state.publish(this);
    }
    public void review() {
        state.review(this);
    }
}

public class DocumentEditor {
    public static void main(String[] args) {
        Document doc = new Document();
        doc.review();
        doc.publish();
        doc.review();
        doc.publish();
        doc.publish();
    }
}
