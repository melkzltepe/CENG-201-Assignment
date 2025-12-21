public class TreatmentRequest extends Patient{
    private int patientId;
    private long arrivalTime;
    private long[] arrivalTimeArray = new long[3];
    private int gmt = 3;
    private TreatmentRequest next;

    public TreatmentRequest(String name, int severity, int age) {
        super(name, severity, age);
        this.patientId = super.getId();
        this.arrivalTime = System.currentTimeMillis();
        this.arrivalTimeArray = computeTime(arrivalTime, gmt);
        this.next = null;
    }

    public int getPatientId() {return patientId;}

    public long getArrivalTime() {return arrivalTime;}

    public long[] getTime() {return arrivalTimeArray;}

    public int getGmt() {return gmt;}

    public TreatmentRequest getNext() {return next;}

    public void setPatientId(int patientId) {this.patientId = patientId;}

    public void setArrivalTime(long arrivalTime) {this.arrivalTime = arrivalTime;}

    public void setTime(long[] time) {this.arrivalTimeArray = time;}

    public void setGmt(int gmt) {this.gmt = gmt;}

    public void setNext(TreatmentRequest next) {this.next = next;}

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
