package hello;

import java.util.ArrayList;

public class ResponseArrayList {

    private final long id;
    private final ArrayList<String> content;

    public ResponseArrayList(long id, ArrayList<String> content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public ArrayList<String> getContent() {
        return content;
    }

}
