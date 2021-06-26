package com.cg.StudentCrudApp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.StudentCrudApp.domain.StudentCrud;
import com.cg.StudentCrudApp.repository.StudentCrudRepository;
@Service
public class StudentCrudService {
	@Autowired
    private StudentCrudRepository repo;
	
	public List<StudentCrud> listAll() {
        return repo.findAll();
    }
     
    public void save(StudentCrud std) {
        repo.save(std);
    }
     
    public StudentCrud get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}
