package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class data_buku {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String kd_buku;
    public String judul;
    public String penulis;
    public String harga;
    public String kd_pelanggan;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO buku(kd_buku,judul,penulis,harga)VALUE(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,kd_buku);
        pst.setString(2,judul);
        pst.setString(3,penulis);
        pst.setString(4,harga);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE buku set judul=?, penulis=?, harga=? where kd_buku=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,judul);
        pst.setString(2,penulis);
        pst.setString(3,harga);
        pst.setString(4,kd_buku);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from buku where kd_buku=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, kd_buku);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatebukuTBL()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select kd_buku,judul,penulis,harga from buku";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
