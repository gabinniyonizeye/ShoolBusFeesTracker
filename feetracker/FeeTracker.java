package school.feetracker;

import java.util.*;

/**
 * Main application to register students, handle payments, and display details.
 */
public class FeeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        // Predefined Rwandan routes with fees
        List<BusRoute> routes = Arrays.asList(
                new BusRoute("R1", "Kigali City Center", 15000),
                new BusRoute("R2", "Nyamirambo",        12000),
                new BusRoute("R3", "Kimironko",         13000),
                new BusRoute("R4", "Remera",            12500),
                new BusRoute("R5", "Kanombe",           14000)
        );

        while (true) {
            System.out.println("\n==== School Bus Fee Tracker ====");
            System.out.println("1. Add Student");
            System.out.println("2. Pay Fee");
            System.out.println("3. View Details");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice;
            try {
                System.out.println("KUndan Kumar");
                choice = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    // 1) Input Student ID
                    String studentId;
                    do {
                        System.out.print("Enter Student ID: ");
                        studentId = sc.nextLine().trim();
                    } while (studentId.isEmpty());

                    // 2) Input Name
                    String name;
                    do {
                        System.out.print("Enter Name: ");
                        name = sc.nextLine().trim();
                    } while (name.isEmpty());

                    // 3) Select Route
                    BusRoute chosenRoute = null;
                    while (chosenRoute == null) {
                        System.out.println("Available Routes:");
                        for (int i = 0; i < routes.size(); i++) {
                            BusRoute r = routes.get(i);
                            System.out.printf("%d. %s – %.0f RWF%n",
                                    i+1, r.getRouteName(), r.getRouteFee());
                        }
                        System.out.print("Choose Route (1-" + routes.size() + "): ");
                        try {
                            int idx = Integer.parseInt(sc.nextLine()) - 1;
                            if (idx >= 0 && idx < routes.size()) {
                                chosenRoute = routes.get(idx);
                            } else {
                                System.out.println("Choice out of range.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }

                    // 4) Scholarship or not
                    boolean isScholar = false;
                    while (true) {
                        System.out.print("Is Scholarship student? (yes/no): ");
                        String ans = sc.nextLine().trim();
                        if (ans.equalsIgnoreCase("yes")) {
                            isScholar = true;
                            break;
                        }
                        if (ans.equalsIgnoreCase("no")) {
                            break;
                        }
                        System.out.println("Enter 'yes' or 'no'.");
                    }

                    // Create appropriate object
                    if (isScholar) {
                        students.add(new ScholarshipStudent(studentId, name, chosenRoute));
                    } else {
                        students.add(new Student(studentId, name, chosenRoute));
                    }
                    System.out.println("✅ Student added successfully!");
                    break;

                case 2:
                    // Pay Fee
                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine().trim();
                    Student found = null;
                    for (Student s : students) {
                        if (s.getStudentId().equalsIgnoreCase(sid)) {
                            found = s;
                            break;
                        }
                    }
                    if (found == null) {
                        System.out.println("Student ID not found.");
                        break;
                    }
                    // Amount
                    System.out.print("Enter payment amount in RWF (0 for default 1000): ");
                    try {
                        double amt = Double.parseDouble(sc.nextLine());
                        if (amt == 0) {
                            found.payFee();
                        } else {
                            found.payFee(amt);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number entered.");
                    }
                    break;

                case 3:
                    // View all details
                    for (Student s : students) {
                        s.showDetails();
                        System.out.println("-----");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
