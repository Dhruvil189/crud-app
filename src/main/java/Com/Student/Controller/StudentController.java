package Com.Student.Controller;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import Com.Student.Dto.StudentDto;
@RestController
public class StudentController {
	@Autowired
	EntityManagerFactory factory;

	

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView search(@ModelAttribute StudentDto employee) { //search data
		System.out.println("print data");
		EntityManager manager = factory.createEntityManager();

		try {
			manager.getTransaction().begin();
			Query query = manager.createQuery("select student from StudentDto student");
			List list = query.getResultList();
			System.out.println(list.toString());
			if (list != null) { 		// list null check.
				Iterator<?> iterator = list.iterator();
				while (iterator.hasNext())

				{
					System.out.println("print details");
					
					return new ModelAndView("Search", "list", list);

				}

			} else {

				return new ModelAndView("Display");
			}

		}

		catch (Exception e) {
			System.out.println(e);
		} finally {
			manager.close();

		}

		return null;

	}
	
	
	
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public ModelAndView save_update(@ModelAttribute StudentDto student) { // save
																			// or
																			// update
																	// method
		System.out.println("hello");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction et = manager.getTransaction();
		StudentDto change = manager.find(StudentDto.class, student.getId()); 
		  System.out.println(student.getId());
		  System.out.println(student.getFirstname());
		  System.out.println(student.getLastname());
		  try 
		  {
			  if (change == null) //if id is null then insert
			  { 
				  et.begin(); 
				  manager.merge(student);
				  et.commit(); 
				  System.out.println("hi");
				 
			  }

		
			 else {        //id is not null then update
				
				System.out.println("edit.....");
				change.setFirstname(student.getFirstname());

				change.setLastname(student.getLastname());

				
				System.out.println("update");
				change.setMobileno(student.getMobileno());

				change.setCity(student.getCity());

				change.setPincode(student.getPincode());
				et.begin();
				manager.merge(change);
				et.commit();
			}
		}

		catch (Exception e) {
			System.out.println(e);
		} finally {
			if (null != manager) {
				manager.clear();
				manager.close();
			}
		}
		return  new ModelAndView("redirect:/welcome");
	
		  
	}
	@RequestMapping(value = "/edit") 		//retrive old data in form
	public ModelAndView getdata(@ModelAttribute StudentDto student, @RequestParam String id) {
		System.out.println("edit");
		student.setId(id);
		System.out.println(student.getId());
		EntityManager manager = factory.createEntityManager();

		try {

			StudentDto old = manager.find(StudentDto.class, student.getId());

			student.setFirstname(old.getFirstname());

			student.setLastname(old.getLastname());

			System.out.println("is it!");
		

			student.setMobileno(old.getMobileno());

			student.setCity(old.getCity());

			student.setPincode(old.getPincode());

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (null != manager) {
				manager.clear();
				manager.close();
			}
		}
		return new ModelAndView("Save", "student", student);
	
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)  //delete record
	public ModelAndView delete(@ModelAttribute StudentDto student, @RequestParam String id) {
		System.out.println("delete");

		student.setId(id);
		System.out.println("delete ok");

		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();

			StudentDto dto = manager.find(StudentDto.class, student.getId());
			if (dto != null) {

				manager.remove(dto);

				manager.getTransaction().commit();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			manager.close();
		}
		return new ModelAndView("redirect:/welcome");
	}
	@RequestMapping("/insert") 	//insert record
	public ModelAndView insert()
	{
		System.out.println("hi");
		return new ModelAndView("Save");
	}
	
}
