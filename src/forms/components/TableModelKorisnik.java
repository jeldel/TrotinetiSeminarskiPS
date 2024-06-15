package forms.components;

import domain.GradEnum;
import domain.Korisnik;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModelKorisnik extends AbstractTableModel {
    private List<Korisnik> korisnici;
    private String[] columnNames = new String[]{"korisnikID", "ime", "prezime", "email", "grad", "telefon", "username","sifra"};
    private Class[] columnClass = new Class[]{Long.class, String.class,String.class, String.class, GradEnum.class, String.class, String.class, String.class};

    public TableModelKorisnik(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    @Override
    public int getRowCount() {
        if(korisnici == null){
            return 0;
        }else{
            return korisnici.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "Nije dostupno";
        }
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex > columnClass.length) {
            return Object.class;
        }
        return columnClass[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0)
            return false;
        else
            return true;
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik korisnik = korisnici.get(rowIndex);

        switch (columnIndex){
            case 0:
                return korisnik.getkorisnikID();
            case 1:
                return korisnik.getIme();
            case 2:
                return korisnik.getPrezime();
            case 3:
                return korisnik.getEmail();
            case 4:
                return korisnik.getGrad();
            case 5:
                return korisnik.getTelefon();
            case 6:
                return korisnik.getUsername();
            case 7:
                return korisnik.getSifra();
            default:
                return "Nije dostupno";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Korisnik korisnik = korisnici.get(rowIndex);
        switch (columnIndex) {
            case 0:
                korisnik.setkorisnikID((Long) aValue);
                break;
            case 1:
                korisnik.setIme((String) aValue);
                break;
            case 2:
                korisnik.setPrezime((String) aValue);
                break;
            case 3:
                korisnik.setEmail((String) aValue);
                break;
            case 4:
                korisnik.setGrad((GradEnum) aValue);
                break;
            case 5:
                korisnik.setTelefon((String)aValue);
                break;
            case 6:
                korisnik.setUsername((String)aValue);
                break;
            case 7:
                korisnik.setSifra((String) aValue);
                break;
        }
    }
}
