package school.feetracker;

/**
 * Represents a student with a fixed 30% scholarship discount.
 */
public class ScholarshipStudent extends Student {
    // Fixed scholarship rate
    private static final double DISCOUNT_PERCENTAGE = 30.0;

    /**
     * Constructor for a scholarship student.
     * Reduces totalFee by 30% automatically.
     *
     * @param studentId Unique student ID entered by user
     * @param name      Student's full name
     * @param route     BusRoute chosen by the student
     */
    public ScholarshipStudent(String studentId, String name, BusRoute route) {
        super(studentId, name, route);
        // Apply 30% discount immediately
        this.totalFee = route.getRouteFee() * (1 - DISCOUNT_PERCENTAGE / 100);
    }

    /**
     * Display student details including scholarship info.
     */
    @Override
    public void showDetails() {
        System.out.println("Student ID           : " + studentId);
        System.out.println("Name                 : " + name);
        System.out.println("Route                : " + route.getRouteName());
        System.out.println("Scholarship Discount : " + DISCOUNT_PERCENTAGE + "%");
        System.out.println("Discounted Fee (RWF) : " + totalFee);
        System.out.println("Paid Amount (RWF)    : " + paidAmount);
        System.out.println("Remaining Fee (RWF)  : " + getRemainingFee());
    }
}
