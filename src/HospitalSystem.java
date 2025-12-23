import java.util.HashMap;

public class HospitalSystem {
    private PatientList patientList;
    private TreatmentQueue treatmentQueue;
    private DischargeStack dischargeStack;
    private HashMap hashMap;


    public void addPatient(String name, int severity, int age) {
        Patient patient = new Patient(name, severity, age);
        patientList.addPatient(patient);
    }

    public void addTreatmentRequest(int id, boolean priority) {
        Patient patient = patientList.findPatient(id);
        TreatmentRequest treatmentRequest =  new TreatmentRequest(patient.getName(), patient.getSeverity(), patient.getAge(), priority);
        treatmentQueue.enqueue(treatmentRequest);
    }

    public void dischargePatient(int id) {
        TreatmentRequest request = treatmentQueue.dequeue();
        DischargeRecord record = new DischargeRecord(request.getName(), request.getSeverity(), request.getAge(), request.getPriority());
        dischargeStack.push(record);
    }

    public void printSystem() {
        patientList.printList();
        treatmentQueue.printQueue();
        dischargeStack.printStack();
    }
}
