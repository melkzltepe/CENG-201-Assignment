public class TestTreatment {
    public static void main(String[] args) {
        Patient p1 = new Patient("Melike Kızıltepe", 2, 21);
        Patient p2 = new Patient("Merve Kızıltepe", 6, 29);
        Patient p3 = new Patient("Saliha Çolak", 4, 32);
        Patient p4 = new Patient("Zeynep Kızıltepe", 3, 51);
        Patient p5 = new Patient("İsmail Kızıltepe", 1, 65);
        Patient p6 = new Patient("Alparslan Çolak", 5, 4);
        Patient p7 = new Patient("Hümeyra Güneş", 8, 21);
        Patient p8 = new Patient("Cengizhan Çolak", 7, 34);

        TreatmentRequest request1 = new TreatmentRequest(p1,true);
        TreatmentRequest request2 = new TreatmentRequest(p2,false);
        TreatmentRequest request3 = new TreatmentRequest(p3,true);
        TreatmentRequest request4 = new TreatmentRequest(p4, false);
        TreatmentRequest request5 = new TreatmentRequest(p5, false);
        TreatmentRequest request6 = new TreatmentRequest(p6,true);
        TreatmentRequest request7 = new TreatmentRequest(p7, true);
        TreatmentRequest request8 = new TreatmentRequest(p8, true);

        TreatmentQueue queue = new TreatmentQueue();
        queue.enqueue(request1, true);
        queue.enqueue(request2,true);
        queue.enqueue(request3,true);
        queue.enqueue(request4,true);
        queue.enqueue(request5, true);
        queue.enqueue(request6,true);
        queue.enqueue(request7,true);
        queue.enqueue(request8,true);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();

    }
}
