import org.hibernate.Session;

public class MainApp {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Check database version
        String sql = "select version()";

        String result = (String) session.createSQLQuery(sql).list().get(0);
        System.out.println(result);

        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();
    }
}