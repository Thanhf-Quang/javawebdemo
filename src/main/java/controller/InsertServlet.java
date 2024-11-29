package controller;

import dao.SinhVienDAO;
import dao.TotNghiepDAO;
import model.SinhVien;
import model.TotNghiep;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String soCMND = request.getParameter("soCMND");
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");
        String soDT = request.getParameter("soDT");
        String diaChi = request.getParameter("diaChi");

        String maTruong = request.getParameter("maTruong");
        String maNganh = request.getParameter("maNganh");
        String heTN = request.getParameter("heTN");
        String ngayTN = request.getParameter("ngayTN");
        String loaiTN = request.getParameter("loaiTN");

        // Kiểm tra dữ liệu bắt buộc
        if (soCMND == null || maTruong == null || maNganh == null || ngayTN == null) {
            request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin bắt buộc!");
            request.getRequestDispatcher("form.jsp").forward(request, response);
            return;
        }

        // Tạo đối tượng SinhVien và TotNghiep
        SinhVien sv = new SinhVien();
        sv.setSoCMND(soCMND);
        sv.setHoTen(hoTen);
        sv.setEmail(email);
        sv.setSoDT(soDT);
        sv.setDiaChi(diaChi);

        TotNghiep tn = new TotNghiep();
        tn.setSoCMND(soCMND);
        tn.setMaTruong(maTruong);
        tn.setMaNganh(maNganh);
        tn.setHeTN(heTN);
        tn.setNgayTN(ngayTN);
        tn.setLoaiTN(loaiTN);

        // Gọi DAO để lưu vào database
        SinhVienDAO svDAO = new SinhVienDAO();
        TotNghiepDAO tnDAO = new TotNghiepDAO();

        boolean successSV = svDAO.insertSinhVien(sv);
        boolean successTN = tnDAO.insertTotNghiep(tn);

        if (successSV && successTN) {
            request.setAttribute("message", "Thêm thành công!");
        } else {
            request.setAttribute("error", "Đã xảy ra lỗi khi thêm dữ liệu!");
        }

        request.getRequestDispatcher("form.jsp").forward(request, response);
    }
}
