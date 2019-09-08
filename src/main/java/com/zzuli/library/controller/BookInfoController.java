package com.zzuli.library.controller;

import com.zzuli.library.domain.BookInfo;
import com.zzuli.library.domain.LendInfo;
import com.zzuli.library.domain.ReaderCard;
import com.zzuli.library.service.BookInfoService;
import com.zzuli.library.service.LendInfoService;
import com.zzuli.library.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
public class BookInfoController {

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private LendInfoService lendInfoService;

    // 管理员主页显示所有图书信息
    @RequestMapping("/admin_books.html")
    public ModelAndView adminBooks() {
        ModelAndView mav = new ModelAndView("admin_books");
        List<BookInfo> bookInfos = bookInfoService.listAllBookInfo();
        mav.addObject("bookInfos", bookInfos);
        return mav;
    }

    // 管理员查询图书信息
    @RequestMapping("/admin_querybooks_do")
    public ModelAndView adminQueryBook(String searchWords) {
        List<BookInfo> bookInfos;
        if (searchWords == null || "".equals(searchWords)) {        // 如果搜索框内容为空则查询全部
            bookInfos = bookInfoService.listAllBookInfo();
        } else {
            bookInfos = bookInfoService.listBooksBySearchWords(searchWords);
        }
        ModelAndView mav = new ModelAndView("admin_books");
        mav.addObject("bookInfos", bookInfos);
        return mav;
    }

    // 跳转到图书详情页面 admin_book_detail, 显示图书信息
    @RequestMapping("/admin_book_detail.html")
    public ModelAndView showBookDetail(HttpServletRequest req) {
        long id = Long.parseLong(req.getParameter("bookId"));
        BookInfo bookInfo = bookInfoService.getBookById(id);
        ModelAndView mav = new ModelAndView("admin_book_detail");
        mav.addObject("detail", bookInfo);
        return mav;
    }

    // 管理员删除图书操作
    @RequestMapping("/admin_deletebook_do")
    public String deleteBook(HttpServletRequest req, RedirectAttributes ra) {
        // System.out.println("BookInfoController.deleteBook" + req.getParameter("bookId"));
        long id = Long.parseLong(req.getParameter("bookId"));
        int index = bookInfoService.removeBookById(id);
        if (index > 0) {
            ra.addFlashAttribute("success", "图书删除成功");
        } else {
            ra.addFlashAttribute("error", "图书删除失败");
        }
        return "redirect:/admin_books.html";
    }

    // 跳转到修改图书信息页面admin_book_edit.jsp
    @RequestMapping("/admin_updatebook.html")
    public ModelAndView toEditBookInfoPage(HttpServletRequest req) {
        // 获取要修改的图书对象 ---> 旧的图书信息
        long id = Long.parseLong(req.getParameter("bookId"));
        BookInfo oldBookInfo = bookInfoService.getBookById(id);     // 旧图书信息
        ModelAndView mav = new ModelAndView("admin_book_edit"); // 跳转到图书编辑页面
        mav.addObject("oldBookInfo", oldBookInfo);
        return mav;
    }

    // 实际进行图书编辑操作
    @RequestMapping("/admin_book_edid_do")
    public String editBookInfo(@RequestParam("pubDateStr") String pubDateStr, BookInfo bookInfo, RedirectAttributes ra) {
        // System.out.println("BookInfoController.editBookInfo-----" + pubDateStr);
        try {
            Date date = DateUtil.getDate(pubDateStr);
            bookInfo.setPub_date(date);
            // System.out.println("BookInfoController.editBookInfo     " + bookInfo);
            if (bookInfoService.updateBookInfo(bookInfo) > 0) {     // 图书信息修改成功
                System.out.println("BookInfoController.editBookInfo" + "图书信息修改成功");
                ra.addFlashAttribute("success", "图书修改成功");
            } else {
                ra.addFlashAttribute("error", "图书修改失败");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/admin_books.html";
    }

    // 跳转到新增图书信息页面admin_book_add.jsp
    @RequestMapping("/book_add.html")
    public ModelAndView toAddBookInfoPage() {
        return new ModelAndView("admin_book_add");
    }

    // 管理员添加图书操作
    @RequestMapping("/admin_book_add_do")
    public String addBookInfo(@RequestParam("pubDateStr") String pubDateStr, BookInfo bookInfo, RedirectAttributes ra) {
        try {
            Date date = DateUtil.getDate(pubDateStr);
            bookInfo.setPub_date(date);
            if (bookInfoService.saveBookInfo(bookInfo) > 0) {
                ra.addFlashAttribute("success", "图书添加成功");
            } else {
                ra.addFlashAttribute("error", "图书添加失败");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "redirect:/admin_books.html";
    }

    // 读者页面显示所有图书
    @RequestMapping("/reader_books.html")
    public ModelAndView readerBooks(HttpServletRequest req) {
        List<BookInfo> bookInfos = bookInfoService.listAllBookInfo();
        // 获取当前读者卡
        ReaderCard readerCard = (ReaderCard) req.getSession().getAttribute("readerCard");
        // 当前读者的借阅信息列表
        List<LendInfo> myLendInfos = lendInfoService.listReadersLendInfo(readerCard.getReader_id());
        // 当前读者未归还图书的book_id列表
        List<Long> noReturnBooksIds = lendInfoService.listNoReturnBooksId(readerCard.getReader_id());
        ModelAndView mav = new ModelAndView("reader_books");
        mav.addObject("bookInfos", bookInfos);
        mav.addObject("noReturnBooksIds", noReturnBooksIds);
//        System.out.println("BookInfoController.readerBooks---bookInfos: " + bookInfos);
//        System.out.println("BookInfoController.readerBooks---not    " + noReturnBooksIds);
        return mav;
    }

    // 读者用户跳转到图书详情页面, 显示图书信息
    @RequestMapping("/reader_book_detail.html")
    public ModelAndView readerBookDetail(HttpServletRequest req) {
        long id = Long.parseLong(req.getParameter("bookId"));
        BookInfo bookInfo = bookInfoService.getBookById(id);
        ModelAndView mav = new ModelAndView("reader_book_detail");
        mav.addObject("detail", bookInfo);
        return mav;
    }

    // 读者查询图书信息
    @RequestMapping("/reader_querybooks_do")
    public ModelAndView readerQueryBook(String searchWords) {
        ModelAndView mav = new ModelAndView("reader_books");
        List<BookInfo> bookInfos;
        if (searchWords == null || "".equals(searchWords)) {        // 如果搜索框内容为空则查询全部
            bookInfos = bookInfoService.listAllBookInfo();
        } else {
            bookInfos = bookInfoService.listBooksBySearchWords(searchWords);
        }
        mav.addObject("bookInfos", bookInfos);
        return mav;
    }

}
