package lab1;

/**This class extends the employee class.  All of the basic employee info is
 * entered with the Employee class, allowing for other Classes to be created
 * such as something for insurance ect.. created a method "goThroughOrientation"
 * allowing for 
 */


/**
 *
 * @author dworgolet
 */
public class EmployeeStatus extends Employee{
    
    private boolean metWithHr = false;
    private boolean metDeptStaff = false;
    private boolean reviewedDeptPolicies = false;
    private boolean movedIn = false;
    private String cubeId;

    public EmployeeStatus(String firstName, String lastName, String ssn, String birthDate) {
        super(firstName, lastName, ssn, birthDate);
    }
     

//allows for user to input if the employee did this or not
    public void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public boolean isMetWithHr() {
        return metWithHr;
    }

    public void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    
    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }


    public void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }

    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }
    
    //public method that checks/puts the employee through orientation
    public void goThroughOrientation(){
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
        System.out.println(getStatus());
    }
 

    // Assume this is must be performed second
    private void meetDepartmentStaff() {
        if(metWithHr == false) {
            System.out.println("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third
    private void reviewDeptPolicies() {
        if(metWithHr && metDeptStaff) {
            reviewedDeptPolicies = true;
        } else {
            System.out.println("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }

    // Assume this must be performed 4th
    private void moveIntoCubicle(String cubeId) {
        if(metWithHr && metDeptStaff && reviewedDeptPolicies) {
            this.cubeId = cubeId;
            this.movedIn = true;
        } else {
            System.out.println("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
        }
    }

    private String getStatus() {
        if(metWithHr && metDeptStaff
           && reviewedDeptPolicies && movedIn) {
            return "Orientation is complete";
        } else {
           return "Orientation in progress...";
        }
    }
    
    
}
