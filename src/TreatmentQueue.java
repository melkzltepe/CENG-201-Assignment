public class TreatmentQueue {
    private TreatmentRequest head,tail;
    private int size;

    public TreatmentQueue() {
        super();
        this.size = 0;
        this.head = this.tail = null;
    }

    public boolean isEmpty() {return (head == null);}

    public void enqueue(TreatmentRequest request, boolean print) {
        if (request.getPriority()) {
            if (head == null) {
                head = tail = request;
                size++;
                if (print) {
                    System.out.println("The treatment request of the patient " + request.getPatient().getName() + " with the id " + request.getPatientId() + " is created \nTime: " + request.printTime(request.getTime()));
                }
            }else {
                TreatmentRequest current = head;
                TreatmentRequest prev = head;
                while (current != null && current.getPriority()) {
                    prev = current;
                    current = current.getNext();
                }
                prev.setNext(request);
                request.setNext(current);
                if (print) {
                    System.out.println("The treatment request of the patient " + request.getPatient().getName() + " with the id " + request.getPatientId() + " is created \nTime: " + request.printTime(request.getTime()));
                }
                size++;
            }
        }else {
            if (isEmpty()) {
                head = tail = request;
                size++;
                if (print) {
                    System.out.println("The treatment request of the patient " + request.getPatient().getName() + " with the id " + request.getPatientId() + " is created \nTime: " + request.printTime(request.getTime()));
                }
                return;
            }
            tail.setNext(request);
            tail = request;
            size++;
            if (print) {
                System.out.println("The treatment request of the patient " + request.getPatient().getName() + " with the id " + request.getPatientId() + " is created \nTime: " + request.printTime(request.getTime()));
            }
        }
    }

    public TreatmentRequest dequeue() {
        if (isEmpty()) {
            System.out.println("The treatment queue is empty");
            return head;
        }
        TreatmentRequest temp = head;
        head = head.getNext();
        size--;
        System.out.println("The treatment request of the patient " + temp.getPatient().getName() + " with the id " + temp.getPatientId() + " is removed from the queue");
        if (head == null) {
            tail = null;
        }
        return temp;
    }

    public int size() {return size;}

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }
        TreatmentRequest current = head;
        System.out.println("=====TREATMENT REQUESTS LIST=====");
        while (current != null) {
            System.out.println(current.getPatient().getName());
            current = current.getNext();
        }
    }

    public TreatmentRequest getHead() {return head;}

    public TreatmentRequest getTail() {return tail;}

    public void setHead(TreatmentRequest head) {this.head = head;}

    public void setTail(TreatmentRequest tail) {this.tail = tail;}

    public TreatmentRequest findRequest(int id) {
        TreatmentRequest current = head;
        while (current != null) {
            if (current.getPatient().getId() == id) {
                return current;
            }
            current = current.getNext();
        }
        System.out.println("The treatment request is not found");
        return current;
    }
}
