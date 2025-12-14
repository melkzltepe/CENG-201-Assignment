public class Patient {
    static int idCounter = 1000000;
    String name;
    int severity;
    int age;
    Patient next;
    int id;

    Patient() {
        this.name = " ";
        this.severity = 0;
        this.age = 0;
        this.next = null;
        this.id = 0;
    }

    Patient(String name, int severity, int age) {
        this.name = name;
        if (severity > 10) {
            this.severity = 10;
        }else if (severity < 0){
            this.severity = 1;
        }else {
            this.severity = severity;
        }
        this.age = age;
        this.next = null;
        this.id = idCounter;
        idCounter++;
    }
}
