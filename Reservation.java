class Reservation {
    private String name;
    private int people;
    private int tableNumber;

    public Reservation(String name, int people, int tableNumber) {
        this.name = name;
        this.people = people;
        this.tableNumber = tableNumber;
    }

    public void display() {
        System.out.println("Name: " + name +
                " | People: " + people +
                " | Table: " + tableNumber);
    }

    public String getName() {
    return name;
}

public int getPeople() {
    return people;
}

public int getTableNumber() {
    return tableNumber;
}

public void setTableNumber(int tableNumber) {
    this.tableNumber = tableNumber;
}
}