package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class data_transaksi{
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String kd_penjualan;
    public String kd_pelanggan;
    public String kd_buku;
    public String jumlah;
    public String harga;
    public String hasil;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO penjualan(kd_penjualan,kd_pelanggan,kd_buku,jumlah,harga,hasil)VALUE(?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,kd_penjualan);
        pst.setString(2,kd_pelanggan);
        pst.setString(3,kd_buku);
        pst.setString(4,jumlah);
        pst.setString(5,harga);
        pst.setString(6,hasil);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE penjualan set kd_pelanggan=?, kd_buku=?, jumlah=?, harga=?, hasil=? where kd_penjualan=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,kd_pelanggan);
        pst.setString(2,kd_buku);
        pst.setString(3,jumlah);
        pst.setString(4,harga);
        pst.setString(5,hasil);
        pst.setString(6,kd_penjualan);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from penjualan where kd_penjualan=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, kd_penjualan);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet Updatepenjualan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select kd_penjualan,kd_pelanggan,kd_buku,jumlah,harga,hasil from penjualan";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
