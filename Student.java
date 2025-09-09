package school.feetracker;

/**
 * Base class representing a student paying for the school bus.
 */
public class Student {
    // Manually-assigned student identifier
    protected String studentId;
    protected String name;
    protected BusRoute route;

    // Total fee (before scholarship) and amount paid so far
    protected double totalFee;
    protected double paidAmount;

    /**
     * Constructor for a regular student.
     *
     * @param studentId      Unique student ID entered by user
     * @param name           Student's full name
     * @param route          BusRoute chosen by the student
     */
    public Student(String studentId, String name, BusRoute route) {
        this.studentId = studentId;
        this.name = name;
        this.route = route;
        this.totalFee = route.getRouteFee();  // base fee
        this.paidAmount = 0.0;                // none paid yet
    }

    /**
     * Pay a custom amount toward the fee.
     * @param amount the amount in RWF
     */
    public void payFee(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount.");
            return;
        }
        paidAmount += amount;
        System.out.println("Payment successful. Total paid: " + paidAmount);
    }

    /**
     * Pay a default amount of 1000 RWF.
     */
    public void payFee() {
        payFee(1000);
    }

    /**
     * Calculate how much fee remains.
     * @return remaining balance
     */
    public double getRemainingFee() {
        return totalFee - paidAmount;
    }

    /**
     * Display all student details to console.
     */
    public void showDetails() {
        System.out.println("Student ID      : " + studentId);
        System.out.println("Name            : " + name);
        System.out.println("Route           : " + route.getRouteName());
        System.out.println("Total Fee (RWF) : " + totalFee);
        System.out.println("Paid Amount     : " + paidAmount);
        System.out.println("Remaining Fee   : " + getRemainingFee());
    }

    /** Accessor for ID lookup. */
    public String getStudentId() {
        return studentId;
    }
}
