package controller.state;

public final class State {

	private static boolean isLogged = false;
	private static String currentUser = "new@qq.com";
	private static String currentCollege = "";
	private static String currentMajor = "";
	
	
	public static boolean isLogged() {
		return isLogged;
	}
	public static void setLogged(boolean isLogged) {
		State.isLogged = isLogged;
	}
	public static String getCurrentUser() {
		return currentUser;
	}
	public static void setCurrentUser(String currentUser) {
		State.currentUser = currentUser;
	}
	public static String getCurrentCollege() {
		return currentCollege;
	}
	public static void setCurrentCollege(String currentCollege) {
		State.currentCollege = currentCollege;
	}
	public static String getCurrentMajor() {
		return currentMajor;
	}
	public static void setCurrentMajor(String currentMajor) {
		State.currentMajor = currentMajor;
	}
	
}
