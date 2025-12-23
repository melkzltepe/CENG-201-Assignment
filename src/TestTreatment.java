public class TestTreatment {
    public static void main(String[] args) {
        TreatmentRequest request1 = new TreatmentRequest("Melike Kızıltepe", 2, 21, true);
        TreatmentRequest request2 = new TreatmentRequest("Merve Kızıltepe", 6, 29, false);
        TreatmentRequest request3 = new TreatmentRequest("Saliha Çolak", 4, 32 , true);
        TreatmentRequest request4 = new TreatmentRequest("Zeynep Kızıltepe", 3, 51, false);
        TreatmentRequest request5 = new TreatmentRequest("İsmail Kızıltepe", 1, 65, false);
        TreatmentRequest request6 = new TreatmentRequest("Alparslan Çolak", 5, 4,true);
        TreatmentRequest request7 = new TreatmentRequest("Hümeyra Güneş", 8, 21, true);
        TreatmentRequest request8 = new TreatmentRequest("Cengizhan Çolak", 7, 34, true);

        TreatmentQueue queue = new TreatmentQueue();
        queue.enqueue(request1);
        queue.enqueue(request2);
        queue.enqueue(request3);
        queue.enqueue(request4);
        queue.enqueue(request5);
        queue.enqueue(request6);
        queue.enqueue(request7);
        queue.enqueue(request8);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();

    }
}
