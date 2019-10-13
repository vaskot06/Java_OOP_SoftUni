package SayHelloExtended;

public abstract class BasePerson implements Person{
    private String NAME;

    BasePerson(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.NAME;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException();
        }else {

            this.NAME = name;
        }
    }
}
