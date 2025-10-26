public class WalidatorUzytkownikow {
    private static final String name = "tajniak";
    private static final String password = "1234";

    public static boolean authenticate(String name, String password) {
        if(WalidatorUzytkownikow.name.equals(name) & WalidatorUzytkownikow.password.equals(password))
            return true;
        else
            return false;
    }
}
