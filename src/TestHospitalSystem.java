public class TestHospitalSystem {
    public static void main(String[] args) {
        HospitalSystem hospitalSystem = new HospitalSystem();

        hospitalSystem.addPatient("Melike Kızıltepe",2, 21);
        hospitalSystem.addPatient("Merve Kızıltepe", 6, 29);
        hospitalSystem.addPatient("Saliha Çolak", 4, 32);
        hospitalSystem.addPatient("Zeynep Kızıltepe", 3, 51);
        hospitalSystem.addPatient("İsmail Kızıltepe", 1, 65);
        hospitalSystem.addPatient("Alparslan Çolak", 5, 4);
        hospitalSystem.addPatient("Hümeyra Güneş", 8, 21);
        hospitalSystem.addPatient("Cengizhan Çolak", 7, 34);
        hospitalSystem.addPatient("Begüm Uğur", 9, 21);
        hospitalSystem.addPatient("Özlem Türk", 10, 21);

        System.out.println(" ");

        hospitalSystem.addTreatmentRequest(1000000, true);
        hospitalSystem.addTreatmentRequest(1000001, false);
        hospitalSystem.addTreatmentRequest(1000002, true);
        hospitalSystem.addTreatmentRequest(1000003, false);
        hospitalSystem.addTreatmentRequest(1000004, true);
        hospitalSystem.addTreatmentRequest(1000005, false);
        hospitalSystem.addTreatmentRequest(1000006, false);
        hospitalSystem.addTreatmentRequest(1000007, false);

        System.out.println(" ");

        hospitalSystem.dischargeRecord(1000005);
        hospitalSystem.dischargeRecord(1000006);

        System.out.println(" ");

        hospitalSystem.sort(hospitalSystem.getTreatmentQueue(), true);

        hospitalSystem.removePatient();
        hospitalSystem.removePatient();
        hospitalSystem.removePatient();
        hospitalSystem.removePatient();

        System.out.println(" ");

        hospitalSystem.printSystem();

    }
}
