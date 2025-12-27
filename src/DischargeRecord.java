public class DischargeRecord {
    private int patientId;
    private long dischargeTime;
    private long[] dischargeTimeArray;
    private DischargeRecord next;
    private TreatmentRequest request;  //we have treatment request object to reach patient object and its data field

    public DischargeRecord(TreatmentRequest request) {
        this.request = request;
        patientId = request.getPatientId();
        dischargeTime = System.currentTimeMillis();
        dischargeTimeArray = request.computeTime(dischargeTime, 3); //uses the method of TreatmentRequest class
        this.next = null;
    }

    public long getDischargeTime() {return dischargeTime;}

    public long[] getDischargeTimeArray() {return dischargeTimeArray;}

    public DischargeRecord getNext() {return next;}

    public int getPatientId() {return patientId;}

    public TreatmentRequest getRequest() {return request;}

    public void setDischargeTime(long dischargeTime) {this.dischargeTime = dischargeTime;}

    public void setDischargeTimeArray(long[] dischargeTimeArray) {this.dischargeTimeArray = dischargeTimeArray;}

    public void setNext(DischargeRecord next) {this.next = next;}

    public void setPatientId(int patientId) {this.patientId = patientId;}

    public void setRequest(TreatmentRequest request) {this.request = request;}
}
