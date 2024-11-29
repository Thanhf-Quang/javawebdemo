package dao;

import model.TotNghiep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TotNghiepDAO {
    public boolean insertTotNghiep(TotNghiep tn) {
        String sql = "INSERT INTO TOT_NGHIEP (SoCMND, MaTruong, MaNganh, HeTN, NgayTN, LoaiTN) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tn.getSoCMND());
            ps.setString(2, tn.getMaTruong());
            ps.setString(3, tn.getMaNganh());
            ps.setString(4, tn.getHeTN());
            ps.setDate(5, java.sql.Date.valueOf(tn.getNgayTN()));
            ps.setString(6, tn.getLoaiTN());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
