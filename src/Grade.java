public class Grade implements Comparable<Grade>{

    private Integer grade;//EJ
    private Exam exam;
    private Student student;

    public Grade(Integer garde, Exam exam, Student student) {
        this.grade = garde;
        this.exam = exam;
        this.student = student;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        if (grade==null) {
            return "EJ";
        }
        return "" + grade;
    }

    @Override
    public int compareTo(Grade t) {
        return this.student.compareTo(t.getStudent()); //To change body of generated methods, choose Tools | Templates.
    }
}
