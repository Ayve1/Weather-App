package weather.app.database.writer;

import weather.app.database.connection.SessionManager;
import weather.app.database.entity.Measurement;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static weather.app.config.ComponentNamesConfig.WRITER_COMPONENT_NAME;
import static weather.app.utilities.errorMessages.WriterErrorMessages.COULD_NOT_SAVE_DATA;
import static weather.app.utilities.infoMessages.WriterInfoMessages.NOTHING_TO_SAVE;

/**
 * @author Wojciech Sankowski
 *
 * class responsible for saving Measurement objects to database
 */
@Component(WRITER_COMPONENT_NAME)
public class Writer implements IWriter {

    /**
     * database connector which manages session
     */
    private final SessionManager sessionManager;

    @Autowired
    public Writer(final SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    /**
     * saves list of {@link Measurement} objects
     * @param measurementList list of {@link Measurement} objects
     * @return true if managed to save data correctly, otherwise returns false
     */
    public boolean save(final List<Measurement> measurementList) {
        if (measurementList == null) {
            System.out.println(NOTHING_TO_SAVE);
            return false;
        }
        Session session = sessionManager.getSession();
        if (session == null) {
            System.out.println(COULD_NOT_SAVE_DATA);
            return false;
        }
        session.beginTransaction();
        for (Measurement measurement : measurementList) {
            session.save(measurement);
        }
        session.getTransaction().commit();
        sessionManager.closeSession();
        return true;
    }

    /**
     * saves single {@link Measurement} object
     * @param measurement {@link Measurement} object
     * @return true if managed to save data correctly, otherwise returns false
     */
    public boolean save(final Measurement measurement) {
        if (measurement == null) {
            System.out.println(NOTHING_TO_SAVE);
            return false;
        }
        Session session = sessionManager.getSession();
        if (session == null) {
            System.out.println(COULD_NOT_SAVE_DATA);
            return false;
        }
        session.beginTransaction();
        session.save(measurement);
        session.getTransaction().commit();
        sessionManager.closeSession();
        return true;
    }
}
