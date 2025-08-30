package FactoryMethod;

abstract class Notification {
    abstract void notifyUser();
    String msg; // Common message field for derived classes
}

class SmsNotification extends Notification {
    @Override
    void notifyUser() {
        System.out.println("SMS notification");
        System.out.println("Message is: " + msg);
    }

    // Specific method for setting SMS message
    void setMessage(String m) {
        this.msg = m;
    }
}

class EmailNotification extends Notification {
    @Override
    void notifyUser() {
        System.out.println("Email notification");
    }
}

class NotificationFactory {
    // Create appropriate notification type
    public Notification createNotification(String type) {
        if (type == null || type.isEmpty())
            return null;
        if ("SMS".equalsIgnoreCase(type)) {
            return new SmsNotification();
        } else if ("EMAIL".equalsIgnoreCase(type)) {
            return new EmailNotification();
        }
        return null;
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        // Create SMS notification and set the message
        SmsNotification sms = (SmsNotification) factory.createNotification("SMS");
        sms.setMessage("Hello user, this is an SMS!");
        sms.notifyUser();

        // Create Email notification
        Notification email = factory.createNotification("EMAIL");
        email.notifyUser();
    }
}
