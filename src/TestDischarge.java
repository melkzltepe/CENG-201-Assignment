public class TestDischarge {
    public static void main(String[] args) {
        Patient p1 = new Patient("Melike Kızıltepe", 2, 21);
        Patient p2 = new Patient("Merve Kızıltepe", 6, 29);
        Patient p3 = new Patient("Saliha Çolak", 4, 32);
        Patient p4 = new Patient("Zeynep Kızıltepe", 3, 51);
        Patient p5 = new Patient("İsmail Kızıltepe", 1, 65);

        TreatmentRequest request1 = new TreatmentRequest(p1,true);
        TreatmentRequest request2 = new TreatmentRequest(p2,false);
        TreatmentRequest request3 = new TreatmentRequest(p3,true);
        TreatmentRequest request4 = new TreatmentRequest(p4, false);
        TreatmentRequest request5 = new TreatmentRequest(p5, false);

        DischargeRecord record1 = new DischargeRecord(request1);
        DischargeRecord record2 = new DischargeRecord(request2);
        DischargeRecord record3 = new DischargeRecord(request3);
        DischargeRecord record4 = new DischargeRecord(request4);
        DischargeRecord record5 = new DischargeRecord(request5);

        DischargeStack stack = new DischargeStack();
        stack.push(record1);
        stack.push(record2);
        stack.push(record3);
        stack.push(record4);
        stack.push(record5);

        stack.pop();
        stack.pop();
        stack.pop();

        stack.printStack();
    }
}
