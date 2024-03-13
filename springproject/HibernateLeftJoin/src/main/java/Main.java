import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.otp.hibernate.pojo.HibernateUtility;


public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Query qry= session.createQuery("select c.customerName, c.customerCity, i.itemName,i.price from Customer c "
				+ "left join c.items i");
		List l = qry.list();
		Iterator it=l.iterator();
		while(it.hasNext())
		{
			Object rows[] = (Object[])it.next();
			System.out.println(rows[0]+ " -- " +rows[1] + "--"+rows[2]+"--"+rows[3]);
		}
		session.clear();
		session.close();
	}

}
