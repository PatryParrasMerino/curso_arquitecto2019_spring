package model;

public class CursoView {
	private Curso curso;
	private int numAlumnos;
	public CursoView(Curso curso, int numAlumnos) {
		super();
		this.curso = curso;
		this.numAlumnos = numAlumnos;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public int getNumAlumnos() {
		return numAlumnos;
	}
	public void setNumAlumnos(int numAlumnos) {
		this.numAlumnos = numAlumnos;
	}
	
}
