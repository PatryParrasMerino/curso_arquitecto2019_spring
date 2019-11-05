package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
		Optional<Curso> curso=daoCursos.findById(idCurso); //findById devuelve un optional, si quieres que te de el curso debes usar el método .get()
		al.setCurso(curso.get());
		//Si existe un alumno con ese dni se lanza la excepción
		if(daoAlumnos.existsById(al.getDni())) {
			throw new RuntimeException();
		}
		daoAlumnos.save(al);
	}
	@Transactional
	@Override
	public void eliminarCurso(int idCurso) {
		daoCursos.deleteById(idCurso);
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
			CursoView cView=new CursoView(c,daoAlumnos.alumnosCurso(c.getIdCurso()));
			cursosView.add(cView);
		}
		return cursosView;
	}

	@Override
	public List<Curso> obtenerCursos() {		
		return daoCursos.findAll();
	}

}
