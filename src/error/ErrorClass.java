package error;

public class ErrorClass {

    String title;
    String message;
    int type;

    public ErrorClass(int type, String title, String message) {
        this.title = title;
        this.message = message;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public int getType() {
        return type;
    }
}
