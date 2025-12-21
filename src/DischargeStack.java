public class DischargeStack {
    private DischargeRecord top;

    public DischargeStack() {
        this.top = null;
    }

    public void setTop(DischargeRecord top) {this.top = top;}

    public void push(DischargeRecord record) {
        if (record == null) {
            System.out.println("Heap overflow");
            return;
        }
        record.setNext(top);
        top = record;
        System.out.println("The patient " + record.getName() + " with the id " + record.getPatientId() + " is discharged. \nTime: " + record.printTime(record.getDischargeTimeArray()));
    }

    public DischargeRecord pop() {
        if (top == null) {
            System.out.println("The stack is empty");
            return top;
        }
        setTop(top.getNext());
        return top;
    }

    public DischargeRecord peek() {return top;}

    public void printStack() {
        DischargeRecord temp = top;
        System.out.println("=====DISCHARGE STACK=====");
        while (temp != null) {
            System.out.println(temp.getName() + " " + temp.printTime(temp.getDischargeTimeArray()));
            temp = temp.getNext();
        }
    }


}
