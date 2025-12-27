public class TreatmentRequest {
    private int patientId;
    private long arrivalTime;
    private long[] arrivalTimeArray = new long[3];
    private int gmt = 3;
    private TreatmentRequest next;
    private boolean priority;
    private Patient patient;

    public TreatmentRequest(Patient patient, boolean priority) {
        this.patient = patient;
        this.patientId = patient.getId();
        this.arrivalTime = System.currentTimeMillis();
        this.arrivalTimeArray = computeTime(arrivalTime, gmt);
        this.next = null;
        this.priority = priority;
    }

    public int getPatientId() {return patientId;}

    public long getArrivalTime() {return arrivalTime;}

    public long[] getTime() {return arrivalTimeArray;}

    public int getGmt() {return gmt;}

    public TreatmentRequest getNext() {return next;}

    public boolean getPriority() {return priority;}

    public Patient getPatient() {return patient;}

    public void setPatientId(int patientId) {this.patientId = patientId;}

    public void setArrivalTime(long arrivalTime) {this.arrivalTime = arrivalTime;}

    public void setTime(long[] time) {this.arrivalTimeArray = time;}

    public void setGmt(int gmt) {this.gmt = gmt;}

    public void setNext(TreatmentRequest next) {this.next = next;}

    public void setPriority(boolean priority) {this.priority = priority;}

    public void setPatient(Patient patient) {this.patient = patient;}

    public long[] computeTime(long milliSec, int gmt) {
        long seconds = milliSec / 1000;
        long remainedSeconds = seconds % 60;
        long minutes = seconds / 60;
        long remainedMinutes = minutes % 60;
        long hours = minutes / 60;
        long remainedHours = (hours + gmt) % 24;
        long[] time = {remainedHours, remainedMinutes, remainedSeconds};
        return time;
    }

    public String printTime(long[] time) {
        return (time[0] + ":" + time[1] + ":" + time[2]);
    }
}
