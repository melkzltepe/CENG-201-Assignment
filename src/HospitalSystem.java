import java.util.HashMap;

public class HospitalSystem {  //this class combines other classes functions into a single class
    private PatientList patientList;
    private TreatmentQueue treatmentQueue;
    private DischargeStack dischargeStack;
    private HashMap<Integer,Patient> hashMap;

    public HospitalSystem() {
        this.patientList = new PatientList();
        this.treatmentQueue = new TreatmentQueue();
        this.dischargeStack = new DischargeStack();
        this.hashMap = new HashMap<>();
    }

    public PatientList getPatientList() {return patientList;}

    public TreatmentQueue getTreatmentQueue() {return treatmentQueue;}

    public DischargeStack getDischargeStack() {return dischargeStack;}

    public void setPatientList(PatientList patientList) {this.patientList = patientList;}

    public void setTreatmentQueue(TreatmentQueue treatmentQueue) {this.treatmentQueue = treatmentQueue;}

    public void setDischargeStack(DischargeStack dischargeStack) {this.dischargeStack = dischargeStack;}

    public void addPatient(String name, int severity, int age) {
        Patient patient = new Patient(name, severity, age);
        hashMap.put(patient.getId(),patient);
        patientList.addPatient(patient);
    }

    public void addTreatmentRequest(int id, boolean priority) {
        Patient patient = patientList.findPatient(id);
        TreatmentRequest treatmentRequest =  new TreatmentRequest(patient, priority);
        treatmentQueue.enqueue(treatmentRequest, true);
    }

    public void dischargeRecord(int id) {
        TreatmentRequest request = treatmentQueue.findRequest(id);
        DischargeRecord record = new DischargeRecord(request);
        dischargeStack.push(record);
    }

    public void removePatient() {
        TreatmentRequest request = treatmentQueue.dequeue();
        DischargeRecord record = new DischargeRecord(request);
        dischargeStack.push(record);
        hashMap.remove(request.getPatientId());
    }

    public void printSystem() {  //this method uses the other classes' methods for convenience
        patientList.printList();
        System.out.println(" ");
        treatmentQueue.printQueue();
        System.out.println(" ");
        dischargeStack.printStack();
        System.out.println(" ");
    }

    private TreatmentQueue[] split(TreatmentQueue queue,boolean priority) {  //this method is used for dividing the queue into two smaller queues
        TreatmentQueue[] treatmentQueues = new TreatmentQueue[2];
        if (priority) {  //This if block is used for dividing queue into two smaller queues according to priority. At the end of this block, we have a queue that only consist of patient has priority and a queue that only consist of patient that does not have priority
            TreatmentRequest prev = queue.getHead();
            TreatmentRequest current = queue.getHead().getNext();
            while (current.getPriority()) {  //find the last patient with priority
                prev = current;
                current = current.getNext();
            }
            prev.setNext(null); //sets the first queue's tail to the null
            treatmentQueues[0] = new TreatmentQueue();
            treatmentQueues[0].setHead(queue.getHead());
            treatmentQueues[0].setTail(prev);
            treatmentQueues[1] = new TreatmentQueue();
            treatmentQueues[1].setHead(current);
            treatmentQueues[1].setTail(queue.getTail());
            return treatmentQueues;
        }else { // this else block used for normal dividing in the merge sort
            if (queue.isEmpty()) {
                treatmentQueues[0] = queue;
                return treatmentQueues;
            }
            TreatmentRequest first = queue.getHead();
            TreatmentRequest second = queue.getHead();
            while (first != null && first.getNext() != null) { //finds the middle element in the queue
                first = first.getNext().getNext();
                if (first != null) {
                    second = second.getNext();
                }
            }
            treatmentQueues[0] = new TreatmentQueue();
            treatmentQueues[0].setHead(queue.getHead());
            treatmentQueues[0].setTail(second);
            treatmentQueues[1] = new TreatmentQueue();
            treatmentQueues[1].setHead(second.getNext());
            treatmentQueues[1].setTail(queue.getTail());
            second.setNext(null);
            return treatmentQueues;
        }
    }

    private TreatmentQueue merge(TreatmentQueue queue1, TreatmentQueue queue2, boolean bySeverity) { //the merge method for merge sort
        TreatmentQueue newQueue = new TreatmentQueue();

        if (queue1.isEmpty()) {
            return queue2;
        } else if (queue2.isEmpty()) {
            return queue1;
        }

        TreatmentRequest request1 = queue1.getHead();
        TreatmentRequest request2 = queue2.getHead();

        if (bySeverity) { //if we want to sort the queue by severity, we execute this if block
            while (request1 != null && request2 != null) {
                if (request1.getPatient().getSeverity() > request2.getPatient().getSeverity()) {
                    newQueue.enqueue(request1, false);
                    request1 = request1.getNext();
                } else if (request1.getPatient().getSeverity() < request2.getPatient().getSeverity()) {
                    newQueue.enqueue(request2, false);
                    request2 = request2.getNext();
                } else { //if both patients have the same severity, the patient in the first queue is added first
                    newQueue.enqueue(request1, false);
                    newQueue.enqueue(request2, false);
                    request1 = request1.getNext();
                    request2 = request2.getNext();
                }
            }
        }else {  //if we want to sort the queue by waiting time, we execute this if block
            while (request1 != null && request2 != null) {
                if (request1.getArrivalTime() < request2.getArrivalTime()) { //if the patient arrives first, its arriving time value would be smaller so it waits more than other patients
                    newQueue.enqueue(request1, false);
                    request1 = request1.getNext();
                } else if (request1.getArrivalTime() > request2.getArrivalTime()) {
                    newQueue.enqueue(request2, false);
                    request2 = request2.getNext();
                } else { //if both patients have the same waiting time, the patient in the first queue is added first
                    newQueue.enqueue(request1, false);
                    newQueue.enqueue(request2, false);
                    request1 = request1.getNext();
                    request2 = request2.getNext();
                }
            }
        }
        if (request1 == null) { //if first queue is empty, add all the elements in the second queue to our new queue
            while (request2.getNext() != null) {
                newQueue.enqueue(request2, false);
                request2 = request2.getNext();
            }
            newQueue.enqueue(request2,false);
            newQueue.setTail(request2);
        }else { //if second queue is empty, add all the elements in the first queue to our new queue
            while (request1.getNext() != null) {
                newQueue.enqueue(request1, false);
                request1 = request1.getNext();
            }
            newQueue.enqueue(request1,false);
            newQueue.setTail(request1);
        }
        return newQueue;
    }

    private TreatmentQueue mergeSort(TreatmentQueue givenQueue, boolean bySeverity) {  //it applies merge sort to our queue
        if (givenQueue.getHead() == null || givenQueue.getHead().getNext() == null) {
            return givenQueue;
        }

        TreatmentQueue[] queues = split(givenQueue, false);

        TreatmentQueue first = mergeSort(queues[0], bySeverity);
        TreatmentQueue second = mergeSort(queues[1], bySeverity);

        return merge(first, second, bySeverity);
    }

    public void sort(TreatmentQueue queue, boolean bySeverity) { //split the first queue by priority and then applies merge sort to both queues
        TreatmentQueue[] queues= split(queue, true);

        queues[0] = mergeSort(queues[0], bySeverity);
        queues[1] = mergeSort(queues[1], bySeverity);

        TreatmentQueue newQueue = queues[0];
        newQueue.getTail().setNext(queues[1].getHead());
        newQueue.setTail(queues[1].getTail());
        this.setTreatmentQueue(newQueue);
    }

}
