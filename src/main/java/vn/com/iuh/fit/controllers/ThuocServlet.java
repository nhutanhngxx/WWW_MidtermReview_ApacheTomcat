package vn.com.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.iuh.fit.repositories.LoaiThuocDAO;
import vn.com.iuh.fit.repositories.ThuocDAO;
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
    private void setThuocList(HttpServletRequest req) {
        List<Thuoc> thuocList = thuocDAO.getAllThuoc();
        req.setAttribute("thuocList", thuocList);
    }
    private void setLoaiThuocList(HttpServletRequest req) {
        List<LoaiThuoc> loaiThuocList = loaiThuocDAO.getAllLoaiThuoc();
        req.setAttribute("loaiThuocList", loaiThuocList);
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
                setThuocList(req);
                req.getRequestDispatcher("thuocList.jsp").forward(req, resp);
                break;
            case "thuocForm":
                setLoaiThuocList(req);
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
                req.getRequestDispatcher("/thuoc?action=thuocList").forward(req, resp);
                break;
            case "searchThuoc":
                setLoaiThuocList(req);
                req.getRequestDispatcher("searchThuoc.jsp").forward(req, resp);
                break;
            case "searchThuocByName":
                List<Thuoc> thuocListByName = thuocDAO.getThuocByName(req.getParameter("tenThuoc"));
                req.setAttribute("thuocList", thuocListByName);
                List<LoaiThuoc> loaiThuocListForName = loaiThuocDAO.getAllLoaiThuoc();
                req.setAttribute("loaiThuocList", loaiThuocListForName);
                req.getRequestDispatcher("searchThuoc.jsp").forward(req, resp);
                break;
            case "searchThuocByLoaiThuoc":
                int loaiThuoc1 = Integer.parseInt(req.getParameter("loaiThuoc"));
                List<Thuoc> thuocListByLoaiThuoc = thuocDAO.getThuocbyLoaiThuoc(loaiThuoc1);
                req.setAttribute("thuocList", thuocListByLoaiThuoc);
                setLoaiThuocList(req);
                req.getRequestDispatcher("searchThuoc.jsp").forward(req, resp);
                break;
            case "editThuoc":
                int maThuoc = Integer.parseInt(req.getParameter("maThuoc"));
                req.setAttribute("thuocID", maThuoc);
                Thuoc thuoc1 = thuocDAO.getThuocById(maThuoc);
                req.setAttribute("thuoc", thuoc1);
                setLoaiThuocList(req);
                req.getRequestDispatcher("thuocForm.jsp").forward(req, resp);
                break;
            case "updateThuoc":
                int maThuoc1 = Integer.parseInt(req.getParameter("maThuoc"));
                String tenThuoc1 = req.getParameter("tenThuoc");
                double gia1 = Double.parseDouble(req.getParameter("gia"));
                int namSX1 = Integer.parseInt(req.getParameter("namSX"));
                int loaiThuocId1 = Integer.parseInt(req.getParameter("loaiThuoc"));

                Thuoc thuocUpdate = new Thuoc();
                thuocUpdate.setMaThuoc(maThuoc1);
                thuocUpdate.setTenThuoc(tenThuoc1);
                thuocUpdate.setGia(gia1);
                thuocUpdate.setNamSX(namSX1);

                LoaiThuoc loaiThuocUpdate = new LoaiThuoc();
                loaiThuocUpdate.setMaLoai(loaiThuocId1);
                thuocUpdate.setLoaiThuoc(loaiThuocUpdate);
                System.out.println(thuocUpdate);
                thuocDAO.updateThuoc(thuocUpdate);
                req.getRequestDispatcher("/thuoc?action=thuocList").forward(req, resp);
                break;
            default:
                break;
        }
    }
}
