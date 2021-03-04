public class CriteresUtilisateur {
    private String typesVacances;
    private String lieu;
    private String localisation;
    private String typePlage;
    private String Activite;

    public CriteresUtilisateur(String lieu, String typePlage) {
        this.lieu = lieu;
        this.typePlage = typePlage;
    }

    public String getTypesVacances() {
        return typesVacances;
    }

    public void setTypesVacances(String typesVacances) {
        this.typesVacances = typesVacances;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getTypePlage() {
        return typePlage;
    }

    public void setTypePlage(String typePlage) {
        this.typePlage = typePlage;
    }

    public String getActivite() {
        return Activite;
    }

    public void setActivite(String activite) {
        Activite = activite;
    }
}
