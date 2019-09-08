package com.zzuli.library.controller;

import com.zzuli.library.domain.LendInfo;
import com.zzuli.library.domain.ReaderCard;
import com.zzuli.library.service.LendAndReturnService;
import com.zzuli.library.service.LendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  图书借阅&归还 控制器
 * @author hejjon
 * @date 2019/8/23 8:09
 */
@Controller
public class LendAndReturnController {

    @Autowired
    private LendInfoService lendInfoService;

    @Autowired
    private LendAndReturnService lendAndReturnService;

    // 管理员页面展示图书借换日志
    @RequestMapping("/lendlist.html")
    public ModelAndView showLendInfoList() {
        ModelAndView mav = new ModelAndView("admin_lend_list");
        List<LendInfo> lendInfos = lendInfoService.listAllLendInfo();
        mav.addObject("lendList", lendInfos);
        return mav;
    }

    // 管理员删除图书借阅信息
    @RequestMapping("/deletelend_do")
    public String deleteLendInfo(HttpServletRequest req, RedirectAttributes ra) {
        long serNum = Long.parseLong(req.getParameter("serNum"));
        if (lendInfoService.removeLendInfo(serNum) > 0) {
            ra.addFlashAttribute("success", "记录删除成功!");
        } else {
            ra.addFlashAttribute("error", "记录删除失败!");
        }

        return "redirect:/lendlist.html";
    }

    // 读者借阅读书
    @RequestMapping("lendbook_do")
    public String lendBook(HttpServletRequest req, RedirectAttributes ra) {
        long bookId = Long.parseLong(req.getParameter("bookId"));
        long readerId = ((ReaderCard) req.getSession().getAttribute("readerCard")).getReader_id();
        int index = lendAndReturnService.lendBook(bookId, readerId);
        if (index > 0) {
            ra.addFlashAttribute("success", "借书成功!");
        } else {
            ra.addFlashAttribute("error", "借书失败!");
        }
        return "redirect:/reader_books.html";
    }

    // 读者归还图书
    @RequestMapping("returnbook_do")
    public String returnBook(HttpServletRequest req, RedirectAttributes ra) {
        long bookId = Long.parseLong(req.getParameter("bookId"));
        long readerId = ((ReaderCard) req.getSession().getAttribute("readerCard")).getReader_id();
        int index = lendAndReturnService.returnBook(bookId, readerId);
        if (index > 0) {
            ra.addFlashAttribute("success", "还书成功!");
        } else {
            ra.addFlashAttribute("error", "还书失败!");
        }
        return "redirect:/reader_books.html";
    }

}
