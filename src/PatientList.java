public class PatientList {
    Patient head,tail;

    PatientList() {
        this.head = null;
        this.tail = null;
    }

    public void addPatient(Patient patient) {
        if (head == null) {
            head = tail = patient;
            System.out.println("The patient " + patient.getName() + " is added to the list");
            patient.increaseId(); //increases the id value to prevent id confusion
            return;
        }
        tail.setNext(patient);
        tail = patient;
        patient.increaseId();
        System.out.println("The patient " + patient.getName() + " is added to the list");
    }

    public void removePatient(int id) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Patient current = head;
        Patient previous = head;
        while (current != null) { //iterates through the list
            if (current.getId() == id && current == head) { //executes if the head of the list is the patient that we want to find
                head = current.getNext();
                System.out.println("The patient " + current.getName() + " is removed from the list");
                return;
            } else if (current.getId() == id) {
                previous.setNext(current.getNext());
                System.out.println("The patient " + current.getName() + " is removed from the list");
                return;
            }
            previous = current;
            current = current.getNext();
        }
       System.out.println("The patient with " + id + " id is not in the list");
    }

    public Patient findPatient(int id) {
        Patient current = head;
        while (current != null) {
            if (current.getId() == id) {
                return current;
            }
            current = current.getNext();
        }
        System.out.println("The patient is not found");
        return current;
    }

    public void printList() {
        Patient current = head;
        System.out.println("=====PATIENT LIST=====");
        while (current != null) {
            System.out.println(current.getName());
            current = current.getNext();
        }
    }
}
