public class TestDischarge {
    public static void main(String[] args) {
        DischargeRecord record1 = new DischargeRecord("Melike Kızıltepe", 2, 21, true);
        DischargeRecord record2 = new DischargeRecord("Merve Kızıltepe", 6, 29, false);
        DischargeRecord record3 = new DischargeRecord("Saliha Çolak", 4, 32, false);
        DischargeRecord record4 = new DischargeRecord("Zeynep Kızıltepe", 3, 51, true);
        DischargeRecord record5 = new DischargeRecord("İsmail Kızıltepe", 1, 65, false);

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
