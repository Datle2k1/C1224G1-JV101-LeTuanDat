public class Classes {
    private String idClasses;
    private String nameClasses;
    private String idTeacher;

    public Classes() {
    }

    public Classes(String idClasses, String nameClasses, String idTeacher) {
        this.idClasses = idClasses;
        this.nameClasses = nameClasses;
        this.idTeacher = idTeacher;
    }

    public String getIdClasses() {
        return idClasses;
    }

    public void setIdClasses(String idClasses) {
        this.idClasses = idClasses;
    }

    public String getNameClasses() {
        return nameClasses;
    }

    public void setNameClasses(String nameClasses) {
        this.nameClasses = nameClasses;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }
}
