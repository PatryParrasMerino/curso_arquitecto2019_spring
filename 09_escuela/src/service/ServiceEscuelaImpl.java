package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoAlumnos;
import dao.DaoCursos;
import model.Alumno;
import model.Curso;
import model.CursoView;
@Service(value = "serviceEscuela")
public class ServiceEscuelaImpl implements ServiceEscuela {
	@Autowired
	DaoCursos daoCursos;
	@Autowired
	DaoAlumnos daoAlumnos;
	@Transactional
	@Override
	public void altaAlumno(Alumno al, int idCurso) {
		Curso curso=daoCursos.findByIdCurso(idCurso);
		al.setCurso(curso);
		if(daoAlumnos.findByDni(al.getDni())!=null) {
			throw new RuntimeException();
		}
		daoAlumnos.saveAlumno(al);
	}
	@Transactional
	@Override
	public void eliminarCurso(int idCurso) {
		daoCursos.deleteCurso(idCurso);
	}

	@Override
	public List<CursoView> obtenerCursosFecha(Date fecha) {
		List<Curso> cursos=daoCursos.findByFechaInicio(fecha);
		List<CursoView> cursosView=new ArrayList<>();
		if(cursos==null||cursos.size()==0) {
			return null;
		}
		for(Curso c:cursos) {
			//CursoView cView=new CursoView(c,c.getAlumnos().size());
			CursoView cView=new CursoView(c,daoCursos.alumnosCurso(c.getIdCurso()));
			cursosView.add(cView);
		}
		return cursosView;
	}

	@Override
	public List<Curso> obtenerCursos() {		
		return daoCursos.findAll();
	}

}
