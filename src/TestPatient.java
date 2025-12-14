public class TestPatient {

    public static void main(String[] args) {
        Patient p1 = new Patient("Derya Deniz", 2, 31);
        Patient p2 = new Patient("Ahmet Suyabatmaz", 1, 65);
        Patient p3 = new Patient("Ayşe Fırıncı", 4, 70);
        Patient p4 = new Patient("İrem Kaynarca", 8, 32);
        Patient p5 = new Patient("Aleyna Mollahamzaoğlu", 6, 29);

        PatientList patients = new PatientList();
        patients.addPatient(p1);
        patients.addPatient(p2);
        patients.addPatient(p3);
        patients.addPatient(p4);
        patients.addPatient(p5);
        patients.removePatient(1000003);
        patients.findPatient(1000004);
        patients.printList();
    }

}
