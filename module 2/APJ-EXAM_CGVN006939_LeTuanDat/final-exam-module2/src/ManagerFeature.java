public interface ManagerFeature {
    void display();
    void add();
    void remove() throws NotFoundStudentException;
    void searchStudent();
    void searchTeacher();
}
