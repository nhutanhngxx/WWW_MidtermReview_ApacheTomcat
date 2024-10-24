package vn.com.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.iuh.fit.dao.LoaiThuocDAO;
import vn.com.iuh.fit.dao.ThuocDAO;
import vn.com.iuh.fit.models.LoaiThuoc;
import vn.com.iuh.fit.models.Thuoc;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "thuoc", value = "/thuoc")
public class ThuocServlet extends HttpServlet {
    private ThuocDAO thuocDAO;
    private LoaiThuocDAO loaiThuocDAO;
    @Override
    public void init() throws ServletException {
        thuocDAO = new ThuocDAO();
        loaiThuocDAO = new LoaiThuocDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.printf("Action = %s\n", action);
        if (action == null || action.isEmpty()) {
            resp.sendRedirect("index.jsp");
            return;
        }
        switch (action) {
            case "thuocList":
                List<Thuoc> thuocList = thuocDAO.getAllThuoc();
                req.setAttribute("thuocList", thuocList);
                req.getRequestDispatcher("thuocList.jsp").forward(req, resp);
                break;
            case "thuocForm":
                List<LoaiThuoc> loaiThuocList = loaiThuocDAO.getAllLoaiThuoc();
                req.setAttribute("loaiThuocList", loaiThuocList);
                req.getRequestDispatcher("thuocForm.jsp").forward(req, resp);
                break;
            case "addThuoc":
                String tenThuoc = req.getParameter("tenThuoc");
                double gia = Double.parseDouble(req.getParameter("gia"));
                int namSX = Integer.parseInt(req.getParameter("namSX"));
                int loaiThuocId = Integer.parseInt(req.getParameter("loaiThuoc"));

                Thuoc thuoc = new Thuoc();
                thuoc.setTenThuoc(tenThuoc);
                thuoc.setGia(gia);
                thuoc.setNamSX(namSX);

                LoaiThuoc loaiThuoc = new LoaiThuoc();
                loaiThuoc.setMaLoai(loaiThuocId);

                thuoc.setLoaiThuoc(loaiThuoc);

                thuocDAO.addThuoc(thuoc);

                break;
            case "search":
                break;
            default:
                break;
        }
    }
}
