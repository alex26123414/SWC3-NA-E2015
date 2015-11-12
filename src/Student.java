public class Student implements Comparable<Student> {

    private String name;
    private long cpr; // 31_12_99_9999   3_112_999_999

    public Student(String name, long cpr) {
        this.name = name;
        this.cpr = cpr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCpr() {
        return cpr;
    }

    public void setCpr(long cpr) {
        this.cpr = cpr;
    }

    public String getGender() {
        if (cpr % 2 == 0) {
            return "F";
        }
        return "M";
    }

    @Override
    public String toString() {
        return cpr + " " + name + " (" + getGender() + ") ";
    }

    @Override
    public int compareTo(Student t) {
        return this.name.compareTo(t.name);
    }
}