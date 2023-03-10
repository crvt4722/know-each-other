/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ProcessTamTrang extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String[] arrTamTrang = {"happy", "chill", "normal", "sad", "heartbroken"};
        //request.setAttribute("song", "https://www.youtube.com/watch?v=pX6nutvtDnI&ab_channel=YEAH1MUSIC");
        String[][] listSong = {
            {"https://www.youtube.com/watch?v=umqzEWyMw2U&ab_channel=ST.319Entertainment", 
                "https://www.youtube.com/watch?v=o_lN37OAJ9U&ab_channel=GalaNh%E1%BA%A1cVi%E1%BB%87t",
                "https://www.youtube.com/watch?v=__kGJZ-kPno&ab_channel=%C4%90%E1%BB%A8CPH%C3%9ACOFFICIAL"
            },
            {
                "https://www.youtube.com/watch?v=LZN4I3K8SC0&ab_channel=Chillies",
                "https://www.youtube.com/watch?v=ddaEtFOsFeM&ab_channel=%C4%90enV%C3%A2uOfficial",
                "https://www.youtube.com/watch?v=GgQFO8dL5XQ&ab_channel=DaLABOfficial"
            },
            {
                "https://www.youtube.com/watch?v=AE3eD-XV4vg&ab_channel=Chillies",
                "https://www.youtube.com/watch?v=vVhKA9Av6vA&list=RDGMEMQ1dJ7wXfLlqCjwV0xfSNbA&index=9&ab_channel=14Casper",
                "https://www.youtube.com/watch?v=v1ADEPnPt54&list=RDGMEMQ1dJ7wXfLlqCjwV0xfSNbA&index=17&ab_channel=Ph%E1%BA%A1mNguy%C3%AAnNg%E1%BB%8Dc"
                
            },
            {
                "https://www.youtube.com/watch?v=NLBTbCfR-Fg&ab_channel=V%C5%A9Official",
                "https://www.youtube.com/watch?v=mMljgrcqdB4&ab_channel=V%C5%A9Official",
                "https://www.youtube.com/watch?v=F5tS5m86bOI&ab_channel=V%C5%A9Official"
            },
            {
                "https://www.youtube.com/watch?v=11XkLOIsLHI&list=RDmMljgrcqdB4&index=2&ab_channel=V%C5%A9Official",
                "https://www.youtube.com/watch?v=xB2qsCnqAXA&list=RDGMEMQ1dJ7wXfLlqCjwV0xfSNbA&index=6&ab_channel=Nguy%C3%AAnH%C3%A0Official",
                "https://www.youtube.com/watch?v=yTj9Owe40do&ab_channel=V%C5%A9Official"
            }
        };
        String[][] listAnUi = {
            {
                "????? n???ng hoa s??? n???, ????? gi?? m??y s??? bay<br>????? y??u th????ng h???nh ph??c s??? ??ong ?????y!", 
                "T??nh y??u kh??ng ph???i l?? nh???ng l???i th??? non h???n bi???n<br> ch??? ????n gi???n l?? c??ng nhau b??nh y??n qua ng??y!", 
                "Khi b???n y??u cu???c ?????i th?? cu???c ?????i c??ng s??? y??u l???i b???n ?????m say!"
            },
            {
                "V?? khi em c?????i, c??? th??? gi???i nh?? ng???ng l???i v?? ng???m nh??n em!", 
                "M??n ????m k??o nh???ng m???ng m?? n??u anh v??o s??u m???t em", 
                "M???i c??y m???i hoa <br> M???i nh?? m???i m??nh em"
            },
            {
                "Sau t???t c??? cu???c vui<br>T??i v???n l?? ng?????i r???a b??t!", 
                "Thu ??i ????? l???i l?? v??ng<br>Thi xong ????? l???i mu??n v??i l???i lo", 
                "Tr???i sinh nh??n t??nh diu hi???n <br> Sao kh??ng sinh v?? ti???n ?????y lu??n ??i!"
            },
            {
                "Con ng?????i m??, ai ch???ng mu???n b??nh y??n<br>Cu???c s???ng m??, ????u ch???ng c?? mu???n phi???n!",
                "H??y m???m c?????i, ?????ng ????? cu???c s???ng m???t m???i m???i ng??y l??m b???n bu???n!",
                "Lo l??m b??i t???p ??i, bu???n m??o g??"
            },
            {
                //"M???c d?? kh??ng th??? c??ng c???u c???m nh???n n???i ??au<br>Nh??ng c?? th??? l?? ng?????i l???ng nghe t???t nh???t c???a c???u", 
                "M??y ngu l???m! ????ng ?????i!", 
                "M??y ngu l???m! ????ng ?????i!", 
                //"M??y ngu l???m! ????ng ?????i!",
                "Th???t nghi???p m???i ch???t, Th???t t??nh kh??ng sao<br>M???t ti???n m???i kh???, m???t b??? kh??ng sao!"
            }
        };
        for(int i = 0; i < 5; i++){
            if(request.getParameter(arrTamTrang[i]) != null){
                Random generator = new Random();
                int index = generator.nextInt(3);
                request.setAttribute("currentEmotion", arrTamTrang[i]);
                request.setAttribute("chon", listAnUi[i][index]);
                request.setAttribute("song", listSong[i][index]);
                break;
            }
        }
        
        request.getRequestDispatcher("WEB-INF/news-feed.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
