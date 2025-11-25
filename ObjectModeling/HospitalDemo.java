import java.util.ArrayList;
import java.util.List;

class Patient{
    private String name;
    private List<Doctor> doctorsConsulted;

    public Patient(String name){
        this.name = name;
        doctorsConsulted = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void addDoctor(Doctor doctor){
        doctorsConsulted.add(doctor);
    }
    public void showDoctors() {
        System.out.println(name + " consulted the following doctors:");
        for (Doctor d : doctorsConsulted) {
            System.out.println("  - " + d.getName());
        }
    }
}

class Doctor{
    private String name;
    private List<Patient> patients;

    public Doctor(String name){
        this.name = name;
        patients = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void consult(Patient patient) {
        System.out.println("Doctor " + name + " is consulting patient " + patient.getName());

        patients.add(patient);
        patient.addDoctor(this);
    }

    public void showPatients() {
        System.out.println("Patients consulted by Dr. " + name + ":");
        for (Patient p : patients) {
            System.out.println("  - " + p.getName());
        }
    }
}
class Hospital{
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.hospitalName = name;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addDoctor(Doctor d){
        doctors.add(d);
    }
    public void addPatient(Patient p){
        patients.add(p);
    }
    public void showDoctors() {
        System.out.println("Doctors in " + hospitalName + ":");
        for (Doctor d : doctors) {
            System.out.println("  - " + d.getName());
        }
    }

    public void showPatients() {
        System.out.println("Patients in " + hospitalName + ":");
        for (Patient p : patients) {
            System.out.println("  - " + p.getName());
        }
    }
}
public class HospitalDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor d1 = new Doctor("Dr. Mehta");
        Doctor d2 = new Doctor("Dr. Roy");

        Patient p1 = new Patient("Aman");
        Patient p2 = new Patient("Neha");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        d1.consult(p1);
        d1.consult(p2);

        d2.consult(p1);  
        System.out.println();

        hospital.showDoctors();
        hospital.showPatients();

        System.out.println();
        d1.showPatients();
        d2.showPatients();

        System.out.println();

        p1.showDoctors();
        p2.showDoctors();
    }
}
