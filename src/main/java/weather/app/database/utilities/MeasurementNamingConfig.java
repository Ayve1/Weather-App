package weather.app.database.utilities;

/**
 * @author Wojciech Sankowski
 *
 * config class contains names of table and columns used for mapping purposes
 */
public class MeasurementNamingConfig {
    public static final String MEASUREMENT_TABLE_NAME = "measurement";

    public static final String ID_COLUMN = "id";
    public static final String COMPONENT_ID_COLUMN = "component_id";
    public static final String DISTRICT_ID_COLUMN = "district_id";
    public static final String DATETIME_COLUMN = "datetime";
    public static final String VALUE_COLUMN = "value";
}
