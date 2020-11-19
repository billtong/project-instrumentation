public abstract class Sort {
    protected int[] array;
    public abstract void handle();

    public int[] getArray() {
            return array;
    }

    public Sort(int[] array) {
        this.array = array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
