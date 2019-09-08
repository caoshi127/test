package com.zzuli.library.controller;

import com.zzuli.library.domain.Admin;
import com.zzuli.library.domain.ReaderCard;
import com.zzuli.library.domain.ReaderInfo;
import com.zzuli.library.service.AdminService;
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
 * @date 2019/8/17 20:31
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ReaderInfoService readerInfoService;

    @Autowired
    private ReaderCardService readerCardService;

    // 管理员主页导航栏
    @RequestMapping("/admin_header.html")
    public ModelAndView toAdmin_header() {
        return new ModelAndView("admin_header");
    }

    // 跳转到修改密码页面
    @RequestMapping("/admin_updatepwd.html")
    public ModelAndView toUpdatePwdPage() {
        return new ModelAndView("admin_updatePwd");
    }

    // 进行修改密码操作
    @RequestMapping("/admin_updatepwd_do")
    public String updatePassword(HttpServletRequest req, String oldPassword, String newPassword, RedirectAttributes ra) {
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        long id = admin.getAdmin_id();
        String password = adminService.getPasswordById(id);
        if (password.equals(oldPassword)) {
            Admin reAdmin = new Admin();
            reAdmin.setAdmin_id(id);
            reAdmin.setPassword(newPassword);
            if (adminService.updatePassword(reAdmin) > 0) {
                ra.addFlashAttribute("success", "密码修改成功!");
            } else {
                ra.addFlashAttribute("error", "密码修改失败!");
            }
        } else {
            ra.addFlashAttribute("error", "旧密码错误!");
        }
        return "redirect:/admin_updatepwd.html";
    }

    // 显示所有读者
    @RequestMapping("/allreaders.html")
    public ModelAndView showAllReaders() {
        List<ReaderInfo> readers = readerInfoService.listAllReaderInfo();
        ModelAndView mav = new ModelAndView("admin_readers");
        mav.addObject("readers", readers);
        return mav;
    }

    // 跳转到读者信息编辑页面
    @RequestMapping("/reader_edit.html")
    public ModelAndView toEditReaderInfoPage(String reader_id) {
        ReaderInfo oldReaderInfo = readerInfoService.getReaderInfoById(Long.parseLong(reader_id));
        ModelAndView mav = new ModelAndView("admin_reader_edit");
        mav.addObject("oldReaderInfo", oldReaderInfo);
        return mav;
    }

    // 编辑读者信息操作
    @RequestMapping("/reader_edit_do")
    public String editReaderInfo(@RequestParam("birthday") String birthday, ReaderInfo readerInfo, RedirectAttributes ra) {
        // System.out.println("ReaderController.editReaderInfo" + "走控制器");
        try {
            Date date = DateUtil.getDate(birthday);
            readerInfo.setBirthday(date);
            // System.out.println("ReaderController.editReaderInfo ---" + readerInfo);
            if (readerInfoService.updateReaderInfo(readerInfo) > 0 && readerCardService.updateReaderCard(readerInfo) > 0) {       // 读者信息修改成功
                // System.out.println("ReaderController.editReaderInfo" + "修改读者信息成功");
                ra.addFlashAttribute("success", "读者信息修改成功");
            } else {
                ra.addFlashAttribute("error", "读者信息修改失败");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/allreaders.html";
    }

    // 删除读者信息操作
    @RequestMapping("/reader_delete_do")
    public String deleteReader(HttpServletRequest req, RedirectAttributes ra) {
        long reader_id = Long.parseLong(req.getParameter("reader_id"));
        // 删除读者信息的同时需要将其借阅卡销毁
        if (readerInfoService.removeReaderInfo(reader_id) > 0 && readerCardService.removeReaderCard(reader_id) > 0) {
            ra.addFlashAttribute("success", "删除读者成功");
        } else {
            ra.addFlashAttribute("error", "删除读者失败");
        }
        return "redirect:/allreaders.html";     // 删除完再查询全部
    }

    // 跳转到新增读者信息界面
    @RequestMapping("/reader_add.html")
    public ModelAndView toAddReaderInfoPage() {
        return new ModelAndView("admin_reader_add");
    }

    // 新增读者信息操作
    @RequestMapping("/reader_add_do")
    public String addReaderInfo(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("birthday") String birthday, ReaderInfo readerInfo, RedirectAttributes ra) {
        try {
            // 先新增读者信息
            Date date = DateUtil.getDate(birthday); // 处理出生日期
            readerInfo.setBirthday(date);
            int i = readerInfoService.saveReaderInfo(readerInfo);   // 保存读者信息
            // 获取读者读者证号
            long readerId = readerInfoService.getReaderId(readerInfo);
            // 新增借阅卡
            ReaderCard newCard = new ReaderCard();
            newCard.setUserName(name);
            newCard.setPassword(password);
            newCard.setReader_id(readerId);
            int j = readerCardService.saveReaderCard(newCard);      // 保存借阅卡信息
            if (i > 0 && j > 0) {
                ra.addFlashAttribute("success", "新增读者信息成功");
            } else {
                ra.addFlashAttribute("error", "新增读者信息失败");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/allreaders.html";
    }
}
