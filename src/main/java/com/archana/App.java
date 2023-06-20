package com.archana;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.archana.model.Address;
import com.archana.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	 Configuration cfg = new Configuration().configure()
	               .addAnnotatedClass(Student.class)
                 .addAnnotatedClass(Address.class);
SessionFactory sf = cfg.buildSessionFactory();
                           
Session session = sf.openSession();
                        
session.beginTransaction();
//--------------------
Student s1= new Student();

s1.setRollno(1);
s1.setName("archana");
s1.setMobile(1234);

session.save(s1);


Address a1 = new Address();
a1.setId(100);
a1.setCity("pune");
a1.setPincode(234);
//a1.setStd(s1);

session.save(a1);

Address a2 = new Address();

a2.setId(101);
a2.setCity("surat");
a2.setPincode(987);
//a2.setStd(s1);

session.save(a2);

List<Address> addresses = new ArrayList<Address>();

addresses.add(a1);
addresses.add(a2);

s1.setAddresses(addresses);

session.save(s1);

    
Student s2= new Student();

s2.setRollno(2);
s2.setName("dhondu");
s2.setMobile(1235);

s2.setAddresses(addresses);

session.save(s2);

//----------------------

session.getTransaction().commit();
session.close();
    }
}
