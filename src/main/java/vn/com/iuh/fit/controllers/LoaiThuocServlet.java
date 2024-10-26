package vn.com.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.iuh.fit.repositories.LoaiThuocDAO;
import vn.com.iuh.fit.models.LoaiThuoc;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "loaiThuoc", value = "/loaiThuoc")
public class LoaiThuocServlet extends HttpServlet {

    private LoaiThuocDAO loaiThuocDAO;

    @Override
    public void init() throws ServletException {
        loaiThuocDAO = new LoaiThuocDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("thuocForm".equals(action)) {
            List<LoaiThuoc> loaiThuocList = loaiThuocDAO.getAllLoaiThuoc();
            req.setAttribute("loaiThuocList", loaiThuocList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("thuocForm.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
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
            case "addLoaiThuoc":
                String tenLoaiThuoc = req.getParameter("loaiThuoc");
                LoaiThuoc loaiThuoc = new LoaiThuoc(tenLoaiThuoc);
                loaiThuocDAO.addLoaiThuoc(loaiThuoc);
                resp.sendRedirect("loaiThuoc?action=loaiThuocList");
                break;
            case "loaiThuocList":
                List<LoaiThuoc> loaiThuocList = loaiThuocDAO.getAllLoaiThuoc();
                req.setAttribute("loaiThuocList", loaiThuocList);
                RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("loaiThuocList.jsp");
                requestDispatcher2.forward(req, resp);
                break;
            case "loaiThuocForm":
                resp.sendRedirect("loaiThuocForm.jsp");
                break;
            case "searchLoaiThuoc":
                String tenLoai = req.getParameter("loaiThuoc");
                List<LoaiThuoc> loaiThuocs = loaiThuocDAO.searchLoaiThuoc(tenLoai);
                req.setAttribute("loaiThuocList", loaiThuocs);
                RequestDispatcher requestDispatcher3 = req.getRequestDispatcher("loaiThuocList.jsp");
                requestDispatcher3.forward(req, resp);
                break;
            default:
                resp.sendRedirect("index.jsp");
                break;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
