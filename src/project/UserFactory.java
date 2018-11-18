package project;

public class UserFactory   {
	public User getUser(String username, String pass) {
		if (username.contains("-")) {
			for (Teacher t : Database.teachers) {
				if (t.login(username, pass)) 
					return t;
			}
		}
		else if (username.contains("_")) {
			for (Student s : Database.students) {
				if (s.login(username, pass)) 
					return s;
			}
		}
		else if (username.contains(".")) {
			if (Database.admin.login(username, pass))
				return Database.admin;
		}
		else if (username.contains("+")) {
			for (Executor e : Database.executors) {
				if (e.login(username, pass)) 
					return e;
			}

		}
		else if (username.contains("=")) {
			for (Manager m : Database.managers) {
				if (m.login(username, pass)) 
					return m;
			}

		}
		return null;
	}
}
