package GmailClone;

public class GmailCloneModel {
    String messageTitle;
    String messageText;
    String date;
    int image;

    public GmailCloneModel(String messageTitle, String messageText, String date, int image) {
        this.messageTitle = messageTitle;
        this.messageText = messageText;
        this.date = date;
        this.image = image;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getDate() {
        return date;
    }

    public int getImage() {
        return image;
    }
}
