package LIBRARY;

public class Transaksi {
    
    private String id_paket, nama_paket;
    private int quantity, sub_total, harga;

    public Transaksi() {
        
    }

    public Transaksi(String id_paket, int quantity, int sub_total) {
        this.id_paket = id_paket;
        this.quantity = quantity;
        this.sub_total = sub_total;
    }
    
    public Transaksi(String id_paket, String nm_paket, int harga, int quantity, int sub_total) {
        this.id_paket = id_paket;
        this.nama_paket = nm_paket;
        this.quantity = quantity;
        this.sub_total = sub_total;
        this.harga = harga;
    }

    public void setIDPaket(String id_paket) {
        this.id_paket = id_paket;
    }

    public void setNamapaket(String nama_paket) {
        this.nama_paket = nama_paket;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubTotal(int sub_total) {
        this.sub_total = sub_total;
    }

    public String getIDPaket() {
        return id_paket;
    }

    public String getNamapaket() {
        return nama_paket;
    }

    public int getHarga() {
        return harga;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSubTotal() {
        return sub_total;
    }
    
}
