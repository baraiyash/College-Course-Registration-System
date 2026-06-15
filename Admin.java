public class Admin extends Person {

    public Admin(int id, String name) {
        super(id, name);
    }

    @Override
    public void dashboard() {
        System.out.println("\n===== Admin Panel =====");
    }
}