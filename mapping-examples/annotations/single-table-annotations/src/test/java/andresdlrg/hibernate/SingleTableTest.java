package andresdlrg.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import andresdlrg.model.SingleTable;
import andresdlrg.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class SingleTableTest {

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
		System.out.println("☺☻♥♦♣♠•◘○◙♂♀♪♫☼►◄↕‼¶§▬↨↑↓→←↔∟▲▼ !\u239e");
		SingleTable singleTable = new SingleTable();
		singleTable.setAnotherNumber(2);
		singleTable.setNumber(1);
		singleTable.setSomeString("something");
		
		session.save(singleTable);
		session.getTransaction().commit();
		
		// retrieving object saved
		session.beginTransaction();
		
		singleTable = session.get(SingleTable.class, singleTable.getSingleTableId());
		session.getTransaction().commit();
		assertNotNull("Could not get object from DB", singleTable);
		
		// deleting the object
		session.beginTransaction();
		
		session.delete(singleTable);
		session.getTransaction().commit();
		
		// checking database has no more registers as we deleted the only created
		session.beginTransaction();
		
		List<SingleTable> singleList = (List<SingleTable>)session.createQuery("from SingleTable").list();
		session.getTransaction().commit();
		
		assertEquals("Object was not deleted", 0, singleList.size());
		
		session.close();
	}
	
}
