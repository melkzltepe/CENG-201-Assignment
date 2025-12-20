public class TestTreatment {
    public static void main(String[] args) {
        TreatmentRequest request1 = new TreatmentRequest("Melike Kızıltepe", 2, 21);
        TreatmentRequest request2 = new TreatmentRequest("Merve Kızıltepe", 6, 29);
        TreatmentRequest request3 = new TreatmentRequest("Saliha Çolak", 4, 32 );
        TreatmentRequest request4 = new TreatmentRequest("Zeynep Kızıltepe", 3, 51);
        TreatmentRequest request5 = new TreatmentRequest("İsmail Kızıltepe", 1, 65);
        TreatmentRequest request6 = new TreatmentRequest("Alparslan Çolak", 5, 4);
        TreatmentRequest request7 = new TreatmentRequest("Hümeyra Güneş", 8, 21);
        TreatmentRequest request8 = new TreatmentRequest("Cengizhan Çolak", 7, 34);

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
