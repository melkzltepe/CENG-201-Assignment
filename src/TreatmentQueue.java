public class TreatmentQueue {
    private TreatmentRequest head,tail;
    private int size;

    public TreatmentQueue() {
        super();
        this.size = 0;
        this.head = this.tail = null;
    }

    public boolean isEmpty() {return (head == null);}

    public void enqueue(TreatmentRequest request) {
        if (request.getPriority()) {
            if (isEmpty()) {
                head = tail = request;
                size++;
                System.out.println("The treatment request of the patient " + request.getName() + " with the id " + request.getPatientId() + " is created \nTime: " + request.printTime(request.getTime()));
            }else {
                TreatmentRequest current = head;
                TreatmentRequest prev = head;
                while (current.getPriority()) {
                    prev = current;
                    current = current.getNext();
                }
                prev.setNext(request);
                request.setNext(current);
                System.out.println("The treatment request of the patient " + request.getName() + " with the id " + request.getPatientId() + " is created \nTime: " + request.printTime(request.getTime()));
                size++;
            }
        }else {
            if (isEmpty()) {
                head = tail = request;
                size++;
                System.out.println("The treatment request of the patient " + request.getName() + " with the id " + request.getPatientId() + " is created \nTime: " + request.printTime(request.getTime()));
                return;
            }
            tail.setNext(request);
            tail = request;
            size++;
            System.out.println("The treatment request of the patient " + request.getName() + " with the id " + request.getPatientId() + " is created \nTime: " + request.printTime(request.getTime()));
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
        System.out.println("The treatment request of the patient " + temp.getName() + " with the id " + temp.getPatientId() + " is removed from the queue");
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
            System.out.println(current.getName());
            current = current.getNext();
        }
    }
}
