import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        if (this.data.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return this.data.remove(this.data.size() - 1);

    }
    public String peek(){
        if (this.data.isEmpty()) {
        throw new IllegalArgumentException();
        }
        return this.data.get(this.data.size() - 1);

    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }

}
