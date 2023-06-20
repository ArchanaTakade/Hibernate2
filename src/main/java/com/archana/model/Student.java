package com.archana.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
        private int rollno;
        private String name;
        private int mobile;
        
        @OneToMany//(mappedBy = "std")
        @JoinTable
            (name = "std_add", 
            joinColumns = {@JoinColumn(name = "s_r")} ,
            inverseJoinColumns = {@JoinColumn(name = "r_id")})
            
        private List<Address>addresses;

		public int getRollno() {
			return rollno;
		}

		public void setRollno(int rollno) {
			this.rollno = rollno;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getMobile() {
			return mobile;
		}

		public void setMobile(int mobile) {
			this.mobile = mobile;
		}

		public List<Address> getAddresses() {
			return addresses;
		}

		public void setAddresses(List<Address> addresses) {
			this.addresses = addresses;
		}
        
        
        
}
