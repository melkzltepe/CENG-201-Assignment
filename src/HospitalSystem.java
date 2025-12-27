import java.util.HashMap;

public class HospitalSystem {
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

    public void printSystem() {
        patientList.printList();
        System.out.println(" ");
        treatmentQueue.printQueue();
        System.out.println(" ");
        dischargeStack.printStack();
        System.out.println(" ");
    }

    private TreatmentQueue[] split(TreatmentQueue queue,boolean priority) {
        TreatmentQueue[] treatmentQueues = new TreatmentQueue[2];
        if (priority) {
            TreatmentRequest prev = queue.getHead();
            TreatmentRequest current = queue.getHead().getNext();
            while (current.getPriority()) {
                prev = current;
                current = current.getNext();
            }
            prev.setNext(null);
            treatmentQueues[0] = new TreatmentQueue();
            treatmentQueues[0].setHead(queue.getHead());
            treatmentQueues[0].setTail(prev);
            treatmentQueues[1] = new TreatmentQueue();
            treatmentQueues[1].setHead(current);
            treatmentQueues[1].setTail(queue.getTail());
            return treatmentQueues;
        }else {
            if (queue.isEmpty()) {
                treatmentQueues[0] = queue;
                return treatmentQueues;
            }
            TreatmentRequest first = queue.getHead();
            TreatmentRequest second = queue.getHead();
            while (first != null && first.getNext() != null) {
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

    private TreatmentQueue merge(TreatmentQueue queue1, TreatmentQueue queue2, boolean bySeverity) {
        TreatmentQueue newQueue = new TreatmentQueue();

        if (queue1.isEmpty()) {
            return queue2;
        } else if (queue2.isEmpty()) {
            return queue1;
        }

        if (bySeverity) {
            TreatmentRequest request1 = queue1.getHead();
            TreatmentRequest request2 = queue2.getHead();

            while (request1 != null && request2 != null) {
                if (request1.getPatient().getSeverity() > request2.getPatient().getSeverity()) {
                    newQueue.enqueue(request1, false);
                    request1 = request1.getNext();
                } else if (request1.getPatient().getSeverity() < request2.getPatient().getSeverity()) {
                    newQueue.enqueue(request2, false);
                    request2 = request2.getNext();
                } else {
                    newQueue.enqueue(request1, false);
                    newQueue.enqueue(request2, false);
                    request1 = request1.getNext();
                    request2 = request2.getNext();
                }
            }
            if (request1 == null) {
                while (request2.getNext() != null) {
                    newQueue.enqueue(request2, false);
                    request2 = request2.getNext();
                }
                newQueue.enqueue(request2, false);
                newQueue.setTail(request2);
            }else {
                while (request1.getNext() != null) {
                    newQueue.enqueue(request1, false);
                    request1 = request1.getNext();
                }
                newQueue.enqueue(request1, false);
                newQueue.setTail(request1);
            }
        }else {
            TreatmentRequest request1 = queue1.getHead().getNext();
            TreatmentRequest request2 = queue2.getHead().getNext();
            while (request1 != null && request2 != null) {
                if (request1.getArrivalTime() > request2.getArrivalTime()) {
                    newQueue.enqueue(request1, false);
                    request1 = request1.getNext();
                } else if (request1.getArrivalTime() < request2.getArrivalTime()) {
                    newQueue.enqueue(request2, false);
                    request2 = request2.getNext();
                } else {
                    newQueue.enqueue(request1, false);
                    newQueue.enqueue(request2, false);
                    request1 = request1.getNext();
                    request2 = request2.getNext();
                }
            }
            if (request1 == null) {
                while (request2.getNext() != null) {
                    newQueue.enqueue(request2, false);
                    request2 = request2.getNext();
                }
                newQueue.enqueue(request2,false);
                newQueue.setTail(request2);
            }else {
                while (request1.getNext() != null) {
                    newQueue.enqueue(request1, false);
                    request1 = request1.getNext();
                }
                newQueue.enqueue(request1,false);
                newQueue.setTail(request1);
            }
        }
        return newQueue;
    }

    private TreatmentQueue mergeSort(TreatmentQueue givenQueue, boolean bySeverity) {
        if (givenQueue.getHead() == null || givenQueue.getHead().getNext() == null) {
            return givenQueue;
        }

        TreatmentQueue[] queues = split(givenQueue, false);

        TreatmentQueue first = mergeSort(queues[0], bySeverity);
        TreatmentQueue second = mergeSort(queues[1], bySeverity);

        return merge(first, second, bySeverity);
    }

    public void sort(TreatmentQueue queue, boolean bySeverity) {
        TreatmentQueue[] queues= split(queue, true);

        queues[0] = mergeSort(queues[0], bySeverity);
        queues[1] = mergeSort(queues[1], bySeverity);

        TreatmentQueue newQueue = queues[0];
        newQueue.getTail().setNext(queues[1].getHead());
        newQueue.setTail(queues[1].getTail());
        this.setTreatmentQueue(newQueue);
    }

}
