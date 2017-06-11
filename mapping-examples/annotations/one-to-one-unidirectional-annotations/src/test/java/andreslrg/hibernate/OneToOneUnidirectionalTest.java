package andreslrg.hibernate;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import andresdlrg.model.Car;
import andresdlrg.model.CarOwner;
import andresdlrg.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class OneToOneUnidirectionalTest {

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
		
		CarOwner owner = new CarOwner();
		owner.setName("Jose Martinez");
		session.save(owner);
		
		Car car = new Car();
		car.setLicensePlate("abc-1234");
		car.setOwner(owner);
		session.save(car);
		
		session.getTransaction().commit();
		
		// retrieving object saved
		session.beginTransaction();
		
		String id = car.getCarId();
		car = null;
		car = session.get(Car.class, id);
		session.getTransaction().commit();
		assertNotNull("Could not get object from DB", car);
		assertNotNull("one to one mapping not got", car.getOwner());
		
		// deleting the object
		session.beginTransaction();
		
		session.delete(car.getOwner());
		session.delete(car);
		session.getTransaction().commit();
		
		// checking database has no more registers as we deleted the only created
		session.beginTransaction();
		
		List<Car> carList = (List<Car>)session.createQuery("from Car").list();
		List<CarOwner> carOwnerList = (List<CarOwner>)session.createQuery("from CarOwner").list();
		session.getTransaction().commit();
		
		assertEquals("Car was not deleted", 0, carList.size());
		assertEquals("CarOwner was not deleted", 0, carOwnerList.size());
		
		session.close();
	}
	
}
