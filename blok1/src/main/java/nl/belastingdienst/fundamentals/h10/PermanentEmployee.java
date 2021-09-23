package nl.belastingdienst.fundamentals.h10;

public class PermanentEmployee extends Employee {

    private int position = 2;

    @Override
    public void doWork() {
        super.doWork(); // vergelijkbaar met this, maar dan uit de superclass.
        System.out.println("Relaxing a bit...." + getId());
    }


    public long getSalary() {
        super.doWork();
        return 2500 * position;
    }

    public int getPosition() {
        return position;
    }
}
