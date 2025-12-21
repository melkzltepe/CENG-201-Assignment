public class DischargeRecord extends TreatmentRequest {
    private int patientId;
    private long dischargeTime;
    private long[] dischargeTimeArray;
    private DischargeRecord next;

    public DischargeRecord(String name, int severity, int age) {
        super(name, severity, age);
        patientId = super.getPatientId();
        dischargeTime = System.currentTimeMillis();
        dischargeTimeArray = computeTime(dischargeTime, 3);
        this.next = null;
    }

    public long getDischargeTime() {return dischargeTime;}

    public long[] getDischargeTimeArray() {return dischargeTimeArray;}

    @Override
    public DischargeRecord getNext() {return next;}

    public void setDischargeTime(long dischargeTime) {this.dischargeTime = dischargeTime;}

    public void setDischargeTimeArray(long[] dischargeTimeArray) {this.dischargeTimeArray = dischargeTimeArray;}

    public void setNext(DischargeRecord next) {this.next = next;}
}
