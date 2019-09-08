package com.zzuli.library.controller;

import com.zzuli.library.domain.LendInfo;
import com.zzuli.library.domain.ReaderCard;
import com.zzuli.library.domain.ReaderInfo;
import com.zzuli.library.service.LendInfoService;
import com.zzuli.library.service.ReaderCardService;
import com.zzuli.library.service.ReaderInfoService;
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

/**
 * @author hejjon
 * @date 2019/8/18 8:34
 */

@Controller
public class ReaderController {

    @Autowired
    private ReaderInfoService readerInfoService;

    @Autowired
    private ReaderCardService readerCardService;

    @Autowired
    private LendInfoService lendInfoService;

    // 读者主页导航栏
    @RequestMapping("/reader_header.html")
    public ModelAndView toReader_header() {
        // System.out.println("ReaderController.toReader_header+++++++++++++++");
        return new ModelAndView("reader_header");
    }


    // 个人信息页面
    @RequestMapping("/reader_info.html")
    public ModelAndView showMyInfo(HttpServletRequest req) {
        // 获取当前读者id
        long readerId = ((ReaderCard) req.getSession().getAttribute("readerCard")).getReader_id();
        ReaderInfo readerInfo = readerInfoService.getReaderInfoById(readerId);
        ModelAndView mav = new ModelAndView("reader_info");
        mav.addObject("readerInfo", readerInfo);

        return mav;
    }

    // 跳转到个人信息编辑页面
    @RequestMapping("/reader_info_edit.html")
    public ModelAndView toInfoEditPage(HttpServletRequest req) {
        ReaderCard readerCard = (ReaderCard) req.getSession().getAttribute("readerCard");
        ReaderInfo OldReaderInfo = readerInfoService.getReaderInfoById(readerCard.getReader_id());
        ModelAndView mav = new ModelAndView("reader_info_edit");
        mav.addObject("OldReaderInfo", OldReaderInfo);
        return mav;
    }

    // 读者编辑个人信息
    @RequestMapping("/reader_edit_r_do")
    public String editMyInfo(@RequestParam("birthday") String birthday, ReaderInfo readerInfo, RedirectAttributes ra) {
        try {
            Date date = DateUtil.getDate(birthday);
            readerInfo.setBirthday(date);
            if (readerInfoService.updateReaderInfo(readerInfo) > 0 && readerCardService.updateReaderCard(readerInfo) > 0) {       // 读者信息修改成功
                ra.addFlashAttribute("success", "个人信息修改成功");
            } else {
                ra.addFlashAttribute("error", "个人信息修改失败");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/reader_info.html";
    }

    // 跳转到我的借还日志界面
    @RequestMapping("/mylend.html")
    public ModelAndView showMyLend(HttpServletRequest req) {
        ReaderCard readerCard = (ReaderCard) req.getSession().getAttribute("readerCard");
        long readerId = readerCard.getReader_id();
        List<LendInfo> lendInfos = lendInfoService.listReadersLendInfo(readerId);
        System.out.println("ReaderController.showMyLend     " + lendInfos);
        ModelAndView mav = new ModelAndView("reader_lend_list");
        mav.addObject("lendInfos", lendInfos);
        return mav;
    }

    // 跳转到修改密码的界面
    @RequestMapping("/reader_updatepwd.html")
    public ModelAndView toUpdatePwdPage() {
        return new ModelAndView("reader_updatePwd");
    }

    // 进行修改密码操作
    @RequestMapping("/reader_updatepwd_do")
    public String updateReadersPwd(HttpServletRequest req, String oldPassword, String newPassword, RedirectAttributes ra) {
        ReaderCard readerCard = (ReaderCard) req.getSession().getAttribute("readerCard");
        String password = readerCardService.getReaderCard(readerCard).getPassword();

        if (password.equals(oldPassword)) {
            readerCard.setPassword(newPassword);
            if (readerCardService.updatePassword(readerCard) > 0) {
                ra.addFlashAttribute("success", "密码修改成功!");
            } else {
                ra.addFlashAttribute("error", "密码修改失败!");
            }
        } else {
            ra.addFlashAttribute("error", "旧密码错误");
        }

        return "redirect:/reader_updatepwd.html";
    }

}
