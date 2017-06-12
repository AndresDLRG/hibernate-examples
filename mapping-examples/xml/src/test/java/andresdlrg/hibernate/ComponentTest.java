package andresdlrg.hibernate;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import andresdlrg.model.Address;
import andresdlrg.model.Person;
import andresdlrg.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class ComponentTest {

	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void init() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Test
	public void testHibernate() {
		Session session = sessionFactory.openSession();
		// saving object part
		session.beginTransaction();
		
		Person person = new Person();
		person.setAge(18);
		person.setName("Manuel");
		
		Address address = new Address();
		address.setStreet("some street");
		address.setCity("some city");
		address.setState("some state");
		person.setAddress(address);
		
		session.save(person);
			
		session.getTransaction().commit();
		
		// retrieving object saved
		session.beginTransaction();
		
		person = session.get(Person.class, person.getName());
		session.getTransaction().commit();
		assertNotNull("Could not get object from DB", person);
		assertNotNull("Address is null", person.getAddress());
		
		// deleting the object
		session.beginTransaction();
		
		session.delete(person);
		session.getTransaction().commit();
		
		// checking database has no more registers as we deleted the only created
		session.beginTransaction();
		
		List<Person> personList = (List<Person>)session.createQuery("from Person").list();
		session.getTransaction().commit();
		
		assertEquals("Person was not deleted", 0, personList.size());
		
		session.close();
	}
	
}
