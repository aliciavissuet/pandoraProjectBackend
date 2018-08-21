package hello;

public class ResponseString {
    private final int id;
    private final String content;

//    public ResponseString(String content) {
//        this.id = id;
//        this.content = content;
//    }

    public String getContent() {
        return content;
    }
    public int getId(){
        return id;
    }

    public ResponseString(int id, String content) {
        this.id = id;
        this.content = content;
    }
}
