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
		 
		try {
			//System.out.println(JPARead.readUser());
			if (JPARead.readUser() == null || JPARead.readUser().isEmpty()) {
				System.out.println("no users detected at JPAHandler ");
				User root = new User("Root", "BlueBubbleBerrie");
				Privilege pr1 = new Privilege(1);
				Privilege pr2 = new Privilege(0);
				Privilege pr3 = new Privilege(2);
				root.setUserType(pr1);
				pr1.setUser(root);
				JPACreate.createPrivilege(pr1);
				JPACreate.createPrivilege(pr2);
				JPACreate.createPrivilege(pr3);
				//System.out.println("paso");
				JPACreate.createUser(root);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public User newUser(User user) {
		int user_id = -1;
		try {
			//System.out.println(user.getName() + "\n" + user.getPassword() + "\n");
			JPACreate.createUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed user insertion");
		}
		return user;
	}

	public Privilege newPrivilege(Privilege privilege) {
		try {
			//System.out.println(privilege.getPrivilege() + "\n");
			JPACreate.createPrivilege(privilege);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed privilege insertion");
		}
		return privilege;
	}

	public List<User> getUser() {

		try {
			return JPARead.readUser();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Privilege> getPrivilege() {
		try {
			return JPARead.readPrivilege();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void deleteUser(User user) {
		try {
		JPADelete.deleteUser(user);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deletePrivilege(Privilege privilege) throws Exception {
		JPADelete.deletePrivilege(privilege);

	}

	public void EditUser(User user) throws Exception {
		JPAUpdate.EditUser(user);
	}

	public void EditPrivilege(Privilege privilege) {
		try {
			JPAUpdate.EditPrivilege(privilege);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Privilege getStatus(int stat) {
		try {
			return JPARead.getStatus(stat);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
