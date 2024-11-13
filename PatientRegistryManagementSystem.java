package crt;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientRegistryManagementSystem {

	
	
	    // Inner Patient class
	    static class Patient {
	        private String name;
	        private int age;
	        private String gender;
	        private String contact;

	        public Patient(String name, int age, String gender, String contact) {
	            this.name = name;
	            this.age = age;
	            this.gender = gender;
	            this.contact = contact;
	        }

	        public String getName() {
	            return name;
	        }

	        public void setName(String name) {
	            this.name = name;
	        }

	        public int getAge() {
	            return age;
	        }

	        public void setAge(int age) {
	            this.age = age;
	        }

	        public String getGender() {
	            return gender;
	        }

	        public void setGender(String gender) {
	            this.gender = gender;
	        }

	        public String getContact() {
	            return contact;
	        }

	        public void setContact(String contact) {
	            this.contact = contact;
	        }

	        @Override
	        public String toString() {
	            return "Patient{" +
	                    "name='" + name + '\'' +
	                    ", age=" + age +
	                    ", gender='" + gender + '\'' +
	                    ", contact='" + contact + '\'' +
	                    '}';
	        }
	    }

	    // Patient Registry class
	    static class PatientRegistry {
	        private List<Patient> patients;

	        public PatientRegistry() {
	            patients = new ArrayList<>();
	        }

	        public void addPatient(Patient patient) {
	            patients.add(patient);
	        }

	        public void updatePatient(String name, Patient updatedPatient) {
	            for (Patient patient : patients) {
	                if (patient.getName().equals(name)) {
	                    patient.setName(updatedPatient.getName());
	                    patient.setAge(updatedPatient.getAge());
	                    patient.setGender(updatedPatient.getGender());
	                    patient.setContact(updatedPatient.getContact());
	                    return;
	                }
	            }
	            System.out.println("Patient not found.");
	        }

	        public void deletePatient(String name) {
	            patients.removeIf(patient -> patient.getName().equals(name));
	        }

	        public List<Patient> getAllPatients() {
	            return patients;
	        }
	    }

	    // Main method
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        PatientRegistry registry = new PatientRegistry();

	        while (true) {
	            System.out.println("\n--- Patient Registry Management System ---");
	            System.out.println("1. Add Patient");
	            System.out.println("2. Update Patient");
	            System.out.println("3. Delete Patient");
	            System.out.println("4. View All Patients");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();  // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter age: ");
	                    int age = scanner.nextInt();
	                    scanner.nextLine();  // Consume newline
	                    System.out.print("Enter gender: ");
	                    String gender = scanner.nextLine();
	                    System.out.print("Enter contact: ");
	                    String contact = scanner.nextLine();
	                    registry.addPatient(new Patient(name, age, gender, contact));
	                    break;
	                case 2:
	                    System.out.print("Enter name of the patient to update: ");
	                    String nameToUpdate = scanner.nextLine();
	                    System.out.print("Enter new name: ");
	                    String newName = scanner.nextLine();
	                    System.out.print("Enter new age: ");
	                    int newAge = scanner.nextInt();
	                    scanner.nextLine();  // Consume newline
	                    System.out.print("Enter new gender: ");
	                    String newGender = scanner.nextLine();
	                    System.out.print("Enter new contact: ");
	                    String newContact = scanner.nextLine();
	                    registry.updatePatient(nameToUpdate, new Patient(newName, newAge, newGender, newContact));
	                    break;
	                case 3:
	                    System.out.print("Enter name of the patient to delete: ");
	                    String nameToDelete = scanner.nextLine();
	                    registry.deletePatient(nameToDelete);
	                    break;
	                case 4:
	                    System.out.println("List of all patients:");
	                    for (Patient patient : registry.getAllPatients()) {
	                        System.out.println(patient);
	                    }
	                    break;
	                case 5:
	                    System.out.println("Exiting the system. Goodbye!");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }
	}
