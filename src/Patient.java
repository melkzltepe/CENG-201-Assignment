import java.util.Scanner;

public class Patient {
    private static int idCounter = 1000000;
    private String name;
    private int severity;
    private int age;
    private Patient next;
    private int id;

    public Patient() { //Parameterless constructer
        this.name = " ";
        this.severity = 0;
        this.age = 0;
        this.next = null;
        this.id = 0;
    }

    public Patient(String name, int severity, int age) {
        boolean condition = true;
        Scanner input = new Scanner(System.in);
        this.severity = severity;
        while (condition) { //Iterates until the user enter a correct severity value
            if (this.severity > 10 || this.severity < 1) {
                System.out.println("Invalid severity, please enter a number between 1 and 10");
                setSeverity(input.nextInt());
            }else {
                condition = false;
            }
        }
        this.name = name;
        this.age = age;
        this.next = null;
        this.id = idCounter;
    }

    public void increaseId() {
        id = idCounter;
        ++idCounter;
    }

    public String getName() {return name;}

    public int getSeverity() {return severity;}

    public int getAge() {return age;}

    public Patient getNext() {return next;}

    public int getId() {return id;}

    public static int getIdCounter() {return idCounter;}

    public void setName(String name) {this.name = name;}

    public void setSeverity(int severity) {this.severity = severity;}

    public void setAge(int age) {this.age = age;}

    public void setNext(Patient next) {this.next = next;}

    public void setId(int id) {this.id = id;}

    public static void setIdCounter(int idCounter) {Patient.idCounter = idCounter;}
}
