package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class data_pelanggan {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String kd_pelanggan;
    public String nama;
    public String alamat;
    public String telp;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO pelanggan(kd_pelanggan,nama,alamat,telp)VALUE(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,kd_pelanggan);
        pst.setString(2,nama);
        pst.setString(3,alamat);
        pst.setString(4,telp);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE pelanggan set nama=?, alamat=?, telp=? where kd_pelanggan=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama);
        pst.setString(2,alamat);
        pst.setString(3,telp);
        pst.setString(4,kd_pelanggan);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from pelanggan where kd_pelanggan=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, kd_pelanggan);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatepelangganTBL()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select kd_pelanggan,nama,alamat,telp from pelanggan";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
