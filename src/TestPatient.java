public class TestPatient {

    public static void main(String[] args) {
        Patient p1 = new Patient("Melike Kızıltepe",2, 21);
        Patient p2 = new Patient("Merve Kızıltepe", 6, 29);
        Patient p3 = new Patient("Saliha Çolak", 4, 32);
        Patient p4 = new Patient("Zeynep Kızıltepe", 3, 51);
        Patient p5 = new Patient("İsmail Kızıltepe", 1, 65);

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
