package wizard_Handler;

import java.io.IOException;
import java.sql.SQLException;

import data_base.db.prosthetics.SQLInsert;
import data_base.db.prostheticsJPA.*;
import pojos.db.prosthetics.*;

public class WizardHandlerJPA {
	JPAConnect estoyLlorandoEnMiHabitacion = new JPAConnect();

	public WizardHandlerJPA() {
		estoyLlorandoEnMiHabitacion.establishConnection();
	}
	public String newUser(User user,int privilege_id){
		String report="";
		try {
			System.out.println(user.getName()+"\n"+user.getPassword()+"\n");
			JPACreate.create(user);
	
		}
		catch(IOException e) {
			e.printStackTrace();
			report="Failed user insertion";
		}

		
		return report;
	} 
	
	public String newPrivilege(Privilege privilege,int user_id){
		String report="";
		try {
			System.out.println(privilege.getPrivilege()+"\n");
			JPACreate.create(privilege);
	
		}
		catch(IOException e) {
			e.printStackTrace();
			report="Failed privilege insertion";
		}

		
		return report;
	} 
}
