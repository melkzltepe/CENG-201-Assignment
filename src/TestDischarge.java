public class TestDischarge {
    public static void main(String[] args) {
        DischargeRecord record1 = new DischargeRecord("Melike Kızıltepe", 2, 21);
        DischargeRecord record2 = new DischargeRecord("Merve Kızıltepe", 6, 29);
        DischargeRecord record3 = new DischargeRecord("Saliha Çolak", 4, 32);
        DischargeRecord record4 = new DischargeRecord("Zeynep Kızıltepe", 3, 51);
        DischargeRecord record5 = new DischargeRecord("İsmail Kızıltepe", 1, 65);

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
