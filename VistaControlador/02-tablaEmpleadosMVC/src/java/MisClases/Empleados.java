package MisClases;

public class Empleados {

    private int empno;
    private String apellido;
    private String oficio;
    private int dir;
    private String fecha_alt;
    private double salario;
    private double comision;
    private int deptno;
    private String dnombre;

    public Empleados() {
    }

    public Empleados(int empno, String apellido, String oficio, int dir, String fecha_alt, double salario, double comision, int deptno, String dnombre) {
        this.empno = empno;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.fecha_alt = fecha_alt;
        this.salario = salario;
        this.comision = comision;
        this.deptno = deptno;
        this.dnombre = dnombre;
    }

    public int getEmpno() {
        return this.empno;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getOficio() {
        return this.oficio;
    }

    public int getDir() {
        return this.dir;
    }

    public String getFecha_alt() {
        return this.fecha_alt;
    }

    public double getSalario() {
        return this.salario;
    }

    public double getComision() {
        return this.comision;
    }

    public int getDeptno() {
        return this.deptno;
    }

    public String getDnombre() {
        return this.dnombre;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public void setFecha_alt(String fecha_alt) {
        this.fecha_alt = fecha_alt;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

}
