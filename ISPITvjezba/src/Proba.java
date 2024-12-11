public enum Proba {
    REPUBLIKA, KRALJEVINA, FEDERACIJA,
    DIKTATURA;

    @Override
    public String toString() {
        if(this==REPUBLIKA)return "repka";
        else return super.toString();
    }
}
