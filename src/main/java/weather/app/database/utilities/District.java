package weather.app.database.utilities;

/**
 * @author Wojciech Sankowski
 *
 * represents database keys for District table
 */
public enum District {
    DOLNOSLASKIE("dolnoslaskie"), KUJAWSKO("kujawsko"), LUBELSKIE("lubelskie"), LUBUSKIE("lubuskie"),
    LODZKIE("lodzkie"), MALOPOLSKIE("malopolskie"), MAZOWIECKIE("mazowieckie"), OPOLSKIE("opolskie"),
    PODKARPACKIE("podkarpackie"), PODLASKIE("podlaskie"), POMORSKIE("pomorskie"), SLASKIE("slaskie"),
    SWIETOKRZYSKIE("swietokrzyskie"), WARMINSKO("warminsko"), WIELKOPOLSKIE("wielkopolskie"), ZACHODNIOPOMORSKIE("zachodniopomorskie");

    /**
     * database key for single district
     */
    private final String name;

    District(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}