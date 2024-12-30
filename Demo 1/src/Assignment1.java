// Parent Class: BioData
class BioData {
    String name;
    String dob;
    String address;
    String contact;
    String email;

    public BioData(String name, String dob, String address, String contact, String email) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public void displayPersonalInfo() {
        System.out.println("\n =============================================== Personal Information ===============================================");
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contact);
        System.out.println("Email: " + email);
        System.out.println();
    }
}

// Subclass: Education
class Education extends BioData {
    String[][] qualifications;

    public Education(String name, String dob, String address, String contact, String email, String[][] qualifications) {
        super(name, dob, address, contact, email);
        this.qualifications = qualifications;
    }

    public void displayEducation() {
        System.out.println("\n=============================================== Educational Qualifications ===============================================");
        for (String[] qualification : qualifications) {
            System.out.println("Level: " + qualification[0]);
            System.out.println("Institution: " + qualification[1]);
            System.out.println("Year of Passing: " + qualification[2]);
            System.out.println("Percentage/CGPA: " + qualification[3]);
            System.out.println();
        }
    }
}

// Subclass: Skills
class Skills extends BioData {
    String[] technicalSkills;

    public Skills(String name, String dob, String address, String contact, String email, String[] technicalSkills) {
        super(name, dob, address, contact, email);
        this.technicalSkills = technicalSkills;
    }

    public void displaySkills() {
        System.out.println("\n=============================================== Technical Skills ===============================================");
        for (String skill : technicalSkills) {
            System.out.println("- " + skill);
        }
        System.out.println();
    }
}

// Subclass: Projects
class Projects extends BioData {
    String[][] projects;

    public Projects(String name, String dob, String address, String contact, String email, String[][] projects) {
        super(name, dob, address, contact, email);
        this.projects = projects;
    }

    public void displayProjects() {
        System.out.println("\n=============================================== Projects ===============================================");
        for (String[] project : projects) {
            System.out.println("Title: " + project[0]);
            System.out.println("Technologies: " + project[1]);
            System.out.println("Description: " + project[2]);
            System.out.println();
        }
    }
}

class Parents extends BioData {

    String[][] Details;

    public Parents(String name, String dob, String address, String contact, String email, String[][] Details) {
        super(name, dob, address, contact, email);
        this.Details = Details;
    }

    public void displayParentsDetails() {
        System.out.println("\n=============================================== Display Parents Details ===============================================");
        for (String[] Detail : Details) {
            System.out.println(Detail[0] + "Name : " + Detail[1]);
            System.out.println(Detail[0] + "Occupation : " + Detail[2]);
            System.out.println(Detail[0] + "Work : " + Detail[3]);
            System.out.println();
        }
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        // Personal Information
        String name = "Tanmay Sandeep Kanase";
        String dob = "06 July 2004";
        String address = "A-8/3-5 , Om Saguru Soc. , CHS, Sec-24, Nerul , Navi Mumbai - 400706";
        String contact = "+91-9702210707";
        String email = "tanmaykanase06@gmail.com";

        // Educational Qualifications
        String[][] qualifications = {
                { "10th Standard", "PVG's Vidabhawan Nerul", "2020", "83%" },
                { "12th Standard", "PVG's Vidyabhawan College of Science and commerce", "2022", "72%" },
                { "Engineering", "Samarth College of Engineering", "1st Sem : ", "7.36 CGPA" },
                { "Engineering", "Samarth College of Engineering", "2nd Sem : ", "7.57 CGPA" },
                { "Engineering", "Samarth College of Engineering", "3rd Sem : ", "--" },
                { "Engineering", "Samarth College of Engineering", "4th Sem : ", "8.32 CGPA" }

        };

        // Technical Skills
        String[] technicalSkills = {
                "Java", "Spring Boot", "ReactJS", "MongoDB", "Docker", "Jenkins", "AWS Basics"
        };

        // Projects
        String[][] projects = {
                { "Full Stack Real Estate Application", "MERN Stack",
                        "A real estate platform with Google authentication, agreement generation, and educational features." },
                { "Real-Time Chat Application", "Spring Boot, React, MongoDB",
                        "A chat application for real-time messaging." },
                { "Bookstore Management System", "Spring Boot", "An application to manage bookstore operations." }
        };
        // Parents
        String[][] Details = { { "Mother", "Sujata Sandeep Kanase", "12th Pass", "House Wife" },
                { "Father", "Sandeep Tukaram Kanase", "12th Pass","Farmer" } };

        // Objects
        Education education = new Education(name, dob, address, contact, email, qualifications);
        Skills skills = new Skills(name, dob, address, contact, email, technicalSkills);
        Projects project = new Projects(name, dob, address, contact, email, projects);
        Parents parents = new Parents(name, dob, address, contact, email, Details);

        // Display BioData
        education.displayPersonalInfo();
        education.displayEducation();
        skills.displaySkills();
        project.displayProjects();
        parents.displayParentsDetails();
    }
}
