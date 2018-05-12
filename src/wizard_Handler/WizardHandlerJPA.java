package wizard_Handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import data_base.db.prosthetics.SQLInsert;
import data_base.db.prostheticsJPA.*;
import pojos.db.prosthetics.*;

public class WizardHandlerJPA {
	JPAConnect estoyLlorandoEnMiHabitacion = new JPAConnect();

	public WizardHandlerJPA() {
		estoyLlorandoEnMiHabitacion.establishConnection();
	}
	public User newUser(User user){
		int user_id=-1;
		try {
			System.out.println(user.getName()+"\n"+user.getPassword()+"\n");
			JPACreate.create(user);
	
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Failed user insertion");
		}

		
		return user;
	} 
	
	public int newPrivilege(Privilege privilege){
		
		try {
			System.out.println(privilege.getPrivilege()+"\n");
			JPACreate.create2(privilege);
	
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Failed privilege insertion");
		}

		
		return privilege.getId();
	} 
	//porfa modificad el código para que me devuelva los id de todos los usuarios
	
	public List<User> getUser() {
		
		try{
			
			return JPARead.readUser();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}
	public List<Privilege> getPrivilege() {
		
		try{
			
			return JPARead.readPrivilege();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public void deleteUser(User user) throws Exception{
		JPADelete.deleteUser(user);
		
	}
	public void deletePrivilege(Privilege privilege) throws Exception{
		JPADelete.deletePrivilege(privilege);
		
	}
	
	public void EditUser(User user) throws Exception{
		String name="";
		JPAUpdate.EditUser(user,name);
		
	}
	
	
	public void EditPrivilege(Privilege privilege) throws Exception{
		int option=0;
		JPAUpdate.EditPrivilege(privilege, option);		
		
	}	
}
