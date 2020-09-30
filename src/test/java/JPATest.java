import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nicklaus.bean.Project;
import com.nicklaus.dao.ProjectDAO;
import com.nicklaus.dao.UserDAO;
import com.nicklaus.dao.impl.ProjectDAOImpl;
import com.nicklaus.dao.impl.UserDAOImpl;
import com.nicklaus.util.JPAUtilities;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JPATest {

    /**
     * test derby connection in embedded mode
     */
    @Test
    public void testConnection(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
        EntityManager emg = factory.createEntityManager();
        emg.close();
    }

    /**
     * add some projects into database
     */
    @Test
    public void testPersistProjects(){
        EntityManager emg = JPAUtilities.getEntityManager();
        EntityTransaction ts = emg.getTransaction();
        ts.begin();
        Project p1 = new Project();
        p1.setUid(1);
        p1.setName("Hexo Project");
        p1.setKey("blog,hexo");
        p1.setDescription("Use Hexo framework and github pages to build up your own blog!");
        p1.setSummary("I build up my blog with NEXT theme of Hexo framework locally, and host this project in github! At the same time, I learn how to use git tool and markdown syntax from this project.");
        p1.setLinkInfo("Dylan's Blog");
        p1.setLinkDetail("https://dylan-club.github.io");

        Project p2 = new Project();
        p2.setUid(1);
        p2.setName("MySQL learning");
        p2.setKey("SQL");
        p2.setDescription("Learn SQL language and use MySQL database server to mange data!");
        p2.setSummary("I use MySQL to store some data in MySQL server with the documentation in the project. At the same time, I learn how to use JDBC to connect MySQL server.");
        p2.setLinkInfo("Oracle MySQL");
        p2.setLinkDetail("http://mysql.com");

        emg.persist(p1);
        emg.persist(p2);

        ts.commit();
        emg.close();
    }


    public void testPersistUser(){}


    /**
     * test findAll method in ProjectDAOImpl
     */
    @Test
    public void testFindAll(){
        ProjectDAO dao = new ProjectDAOImpl();

        System.out.println(dao.findAll(1));
    }

    /**
     * test find method in ProjectDAOImpl
     */
    @Test
    public void testFind(){
        ProjectDAO dao = new ProjectDAOImpl();
        Project project = dao.find(1);
        System.out.println(project);
    }

    @Test
    public void testJDBC() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("org.apache.derby.jdbc.EmbeddedDriver");
        dataSource.setJdbcUrl("jdbc:derby:project;create=true");
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        boolean execute = statement.execute("select * from project_table");
        System.out.println(execute);
    }

    @Test
    public void testFindByUsernameAndPassword(){
        UserDAO dao = new UserDAOImpl();
        dao.findByUsernameAndPassword("123","123");
    }
}
