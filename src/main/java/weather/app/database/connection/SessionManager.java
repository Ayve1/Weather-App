package weather.app.database.connection;

import weather.app.database.entity.Measurement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Component;

import static weather.app.utilities.errorMessages.SessionManagerErrorMessages.COULD_NOT_CONNECT_TO_DATABASE;

/**
 * @author Wojciech Sankowski
 *
 * class responsible for creating new connection with database and closing it after transactions are finished
 */
@Component
public class SessionManager {
    private final String HIBERNATE_CONFIG_LOCATION = "config/hibernate.cfg.xml";

    private SessionFactory sessionFactory;

    /**
     * @return hibernate Session object
     */
    public Session getSession() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            try {
                createNewSessionFactory();
            } catch (ServiceException e) {
                System.out.println(COULD_NOT_CONNECT_TO_DATABASE);
                return null;
            }
        }
        return sessionFactory.getCurrentSession();
    }

    /**
     * closes SessionFactory
     */
    public void closeSession() {
        sessionFactory.close();
    }

    /**
     * creates new session factory in case last one was closed
     * @throws ServiceException if couldn't connect to database
     */
    private void createNewSessionFactory() throws ServiceException {
        sessionFactory = new Configuration()
                .configure(HIBERNATE_CONFIG_LOCATION)
                .addAnnotatedClass(Measurement.class)
                .buildSessionFactory();
    }
}
