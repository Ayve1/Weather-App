package weather.app.database.writer;

import weather.app.database.entity.Measurement;

import java.util.List;

/**
 * @author Wojciech Sankowski
 *
 * defines saving measurement objects to database
 */
public interface IWriter {
    /**
     * saves list of {@link Measurement} objects
     * @param measurementList list of {@link Measurement} objects
     * @return true if managed to save data correctly, otherwise returns false
     */
    boolean save(final List<Measurement> measurementList);
    /**
     * saves single {@link Measurement} object
     * @param measurement {@link Measurement} object
     * @return true if managed to save data correctly, otherwise returns false
     */
    boolean save(final Measurement measurement);
}
