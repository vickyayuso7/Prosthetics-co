package wizard_Handler;

import data_base.db.prostheticsJPA.*;
import pojos.db.prosthetics.*;

public class WizardHandlerJPA {
	JPAConnect estoyLlorandoEnMiHabitacion = new JPAConnect();

	public WizardHandlerJPA() {
		estoyLlorandoEnMiHabitacion.establishConnection();
	}
	public String newUser(User user,int privilege_id){
		
		
	} 
}
