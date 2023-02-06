package jsp_practice1_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jsp_practice1_dto.Employee;

public class Employeedao {

	public EntityManager getEManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	public Employee saveEmployee(Employee employee) {
		EntityManager entityManager=getEManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}
public Employee getEmployeebyId(String email) {
	EntityManager entityManager=getEManager();
	Query query=entityManager.createQuery("select e from Employee e where e.email=?1");
	query.setParameter(1, email);
	Employee employee=(Employee)query.getSingleResult();
	return employee;
}
public List<Employee> getAllEmployee(){
	EntityManager entityManager=getEManager();
	Query query=entityManager.createQuery("select e from Employee e ");
	List<Employee> list=query.getResultList();
	return list;
}
public boolean deleteEmployee(int id) {
	EntityManager  entityManager=getEManager();
	Employee employee=entityManager.find(Employee.class, id);
	EntityTransaction entityTransaction=entityManager.getTransaction();
	if(employee!=null) {
		entityTransaction .begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		return true;
	}
	return false;
}
public Employee getStudentById(int id) {
	return getEManager().find(Employee.class, id);
}
public Employee updateEmployee(Employee employee) {
	EntityManager entityManager=getEManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.merge(employee);
	entityTransaction.commit();
	return employee;
}
	
}
