public class PatientList {
    Patient head,tail;

    PatientList() {
        this.head = null;
        this.tail = null;
    }

    public void addPatient(Patient patient) {
        if (head == null) {
            head = tail = patient;
            System.out.println("The patient " + patient.name + " is added to the list");
            return;
        }
        tail.next = patient;
        tail = patient;
        System.out.println("The patient " + patient.name + " is added to the list");
    }

    public void removePatient(int id) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Patient current = head;
        Patient previous = head;
        while (current != null) {
            if (current.id == id && current == head) {
                head = current.next;
                System.out.println("The patient " + current.name + " is removed from the list");
                return;
            } else if (current.id == id) {
                previous.next = current.next;
                System.out.println("The patient " + current.name + " is removed from the list");
                return;
            }
            previous = current;
            current = current.next;
        }
       System.out.println("The patient with " + id + " id is not in the list");
    }

    public Patient findPatient(int id) {
        Patient current = head;
        while (current != null) {
            if (current.id == id) {
                System.out.println("The patient is found: " + current.name);
                return current;
            }
            current = current.next;
        }
        System.out.println("The patient is not found");
        return current;
    }

    public void printList() {
        Patient current = head;
        System.out.println("PATIENT LIST");
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }
}
