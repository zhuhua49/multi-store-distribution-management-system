package com.ruanku.controller;

import com.ruanku.domain.*;
import com.ruanku.service.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import sun.plugin.javascript.navig.LinkArray;

import java.util.List;

@Controller
@RequestMapping("/message")
@SessionAttributes(names = {"Admin","Name","MemberId"},types = {Administrator.class,String.class,Integer.class})
public class MessageController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private ChartMessageService chartMessageService;

    //店长跳转消息推送界面
    @RequestMapping("/jumpmessage")
    public String jumpmessage(@ModelAttribute("Admin") Administrator Admin, Model model){
        List<Member> list = memberService.FindAll();
        List<Member> listSM = memberService.FindAdministratorId(Admin.getAdministratorId());
        List<Store> listS = storeService.FindAdministratorId(Admin.getAdministratorId());
        for (int i=0;i<listSM.size();i++){
            System.out.println("memberId:"+listSM.get(i).getMemberId()+"   administratorId:"+Admin.getAdministratorId()+"   Name:"+listS.get(0).getName());
            List<ChartMessage> listcm = chartMessageService.FindMAIsRead(listSM.get(i).getMemberId(),Admin.getAdministratorId(),listS.get(0).getName());
            listSM.get(i).setMessagen(listcm.size());
        }
        model.addAttribute("listSM",listSM);
        //model.addAttribute("list",list);
        return "admin/push/query";
    }

    //分店长跳转消息推送界面
    @RequestMapping("/jumpstoremessage")
    public String jumpstoremessage(@ModelAttribute("Admin") Administrator Admin, Model model){
        List<Member> list = memberService.FindAll();
        List<Member> listSM = memberService.FindAdministratorId(Admin.getAdministratorId());
        List<Store> listS = storeService.FindAdministratorId(Admin.getAdministratorId());
        for (int i=0;i<listSM.size();i++){
            System.out.println("memberId:"+listSM.get(i).getMemberId()+"   administratorId:"+Admin.getAdministratorId()+"   Name:"+listS.get(0).getName());
            List<ChartMessage> listcm = chartMessageService.FindMAIsRead(listSM.get(i).getMemberId(),Admin.getAdministratorId(),listS.get(0).getName());
            listSM.get(i).setMessagen(listcm.size());
        }
        model.addAttribute("listSM",listSM);
        //model.addAttribute("list",list);
        return "admin/push/storequery";
    }


    //根据年龄范围和性别查询
    @RequestMapping("/findageandsex")
    public String findageandsex(@ModelAttribute("Admin") Administrator Admin, Integer ageA, Integer ageB, String sex, Model model){
        System.out.println("传入数据为： ageA"+ageA+"  ageB:"+ageB+"  sex:"+sex);
        //List<Member> list = memberService.FindAgeAndSex(ageA,ageB,sex);
        List<Member> listSM = memberService.FindAgeAndSex(Admin.getAdministratorId(),ageA,ageB,sex);
        List<Store> listS = storeService.FindAdministratorId(Admin.getAdministratorId());
        for (int i=0;i<listSM.size();i++){
            //System.out.println("memberId:"+listSM.get(i).getMemberId()+"   administratorId:"+Admin.getAdministratorId()+"   Name:"+listS.get(0).getName());
            List<ChartMessage> listcm = chartMessageService.FindMAIsRead(listSM.get(i).getMemberId(),Admin.getAdministratorId(),listS.get(0).getName());
            listSM.get(i).setMessagen(listcm.size());
        }
        model.addAttribute("listSM",listSM);
        model.addAttribute("Admin",Admin);
        //model.addAttribute("list",list);
        if (ageA==null){
            model.addAttribute("ageA","");
        }else {
            model.addAttribute("ageA",ageA);
        }
        if (ageB==null){
            model.addAttribute("ageB","");
        }else {
            model.addAttribute("ageB",ageB);
        }
        return "admin/push/query";
    }

    //根据年龄范围和性别查询
    @RequestMapping("/storefindageandsex")
    public String storefindageandsex(@ModelAttribute("Admin") Administrator Admin, Integer ageA, Integer ageB, String sex, Model model){
        System.out.println("传入数据为： ageA"+ageA+"  ageB:"+ageB+"  sex:"+sex);
        //List<Member> list = memberService.FindAgeAndSex(ageA,ageB,sex);
        List<Member> listSM = memberService.FindAgeAndSex(Admin.getAdministratorId(),ageA,ageB,sex);
        List<Store> listS = storeService.FindAdministratorId(Admin.getAdministratorId());
        for (int i=0;i<listSM.size();i++){
            //System.out.println("memberId:"+listSM.get(i).getMemberId()+"   administratorId:"+Admin.getAdministratorId()+"   Name:"+listS.get(0).getName());
            List<ChartMessage> listcm = chartMessageService.FindMAIsRead(listSM.get(i).getMemberId(),Admin.getAdministratorId(),listS.get(0).getName());
            listSM.get(i).setMessagen(listcm.size());
        }
        model.addAttribute("listSM",listSM);
        model.addAttribute("Admin",Admin);
        //model.addAttribute("list",list);
        if (ageA==null){
            model.addAttribute("ageA","");
        }else {
            model.addAttribute("ageA",ageA);
        }
        if (ageB==null){
            model.addAttribute("ageB","");
        }else {
            model.addAttribute("ageB",ageB);
        }
        return "admin/push/storequery";
    }

    //指定会员推送消息
    @RequestMapping("/sendmessage")
    public String sendmessage(@RequestParam("recipient") Integer[] recipientId, @ModelAttribute("Admin") Administrator Admin, Message message, Model model){
        for (int i=0;i<recipientId.length;i++){
            message.setAdministratorId(Admin.getAdministratorId());
            message.setMemberId(recipientId[i]);
            message.setIsRead(1);
            System.out.println("遍历输出message为："+message);
            messageService.SendMessage(message);
        }
        return "admin/push/query";
    }

    //根据用户名查询所有消息,并且跳转到会员消息页面
    @RequestMapping("/membermsg")
    public String membermsg(@ModelAttribute("MemberId") Integer MemberId,@ModelAttribute("Name") String Name, Model model){
        System.out.println("memberId:" + MemberId  + "   Name:" + Name);
        List<Message> list = messageService.FindMemberId(MemberId);
        if (list.size()!=0) {
            List<Store> list1 = storeService.FindAdministratorId(list.get(0).getAdministratorId());
            //发消息超链接接受新消息的数量
            List<ChartMessage> listCM = chartMessageService.FindMAIsRead(MemberId, list.get(0).getAdministratorId(), Name);
            //System.out.println("memberId:" + MemberId + "   administratorId:" + list.get(0).getAdministratorId() + "   Name:" + Name);
            //System.out.println("ListCM的值为：" + listCM);
            //点击导航栏消息跳转同时更新message的isRead为2（已读）
            messageService.Update(MemberId);
            Message message = new Message();
            message.setIsRead(1);
            message.setMemberId(MemberId);
            List<Message> list2 = messageService.FindMemberIdIsRead(message);
            model.addAttribute("Msgnumber", list2.size());
            model.addAttribute("messagen", listCM.size());
            model.addAttribute("list1", list1);
            model.addAttribute("list", list);
            System.out.println("已经执行if");
            }else {
            System.out.println("memberId:"+MemberId);
            List<Member> list2 = memberService.FindMemberId(MemberId);
            List<Store> list1 = storeService.FindAdministratorId(list2.get(0).getAdministratorId());
            System.out.println("list2:"+list2);
            System.out.println("list1:"+list1);
            List<ChartMessage> listCM = chartMessageService.FindMAIsRead(MemberId, list2.get(0).getAdministratorId(), Name);
            model.addAttribute("Msgnumber", 0);
            model.addAttribute("messagen", listCM.size());
            model.addAttribute("list1", list1);
            model.addAttribute("list", list);
        }


        return "member/message";
    }

    //管理员跳转聊天页面
    @RequestMapping("jumpwebsocket")
    public String jumpwebsocket(@ModelAttribute("Admin") Administrator Admin,int memberId,Model model){
        List<Store> listS = storeService.FindAdministratorId(Admin.getAdministratorId());
        chartMessageService.Update(memberId,Admin.getAdministratorId(),listS.get(0).getName());
        List<Member> list = memberService.FindId(memberId);
        List<Store> list1 = storeService.FindAdministratorId(Admin.getAdministratorId());
        List<ChartMessage> list2 = chartMessageService.FindChartMessage(memberId,Admin.getAdministratorId());
        model.addAttribute("list2",list2);
        model.addAttribute("receiver",list.get(0).getName());
        model.addAttribute("name",Admin.getAdminName());
        model.addAttribute("sender",list1.get(0).getName());
        model.addAttribute("administratorId",Admin.getAdministratorId());
        model.addAttribute("memberId",memberId);
        model.addAttribute("ms","多店铺分销管理系统——店长端");
        model.addAttribute("rt","/msdm_war/admin/logincenter");
        model.addAttribute("close","/msdm_war/admin/loginout");
        return "websocket";
    }

    //会员跳转聊天页面
    @RequestMapping("mjumpwebsocket")
    public String mjumpwebsocket(@ModelAttribute("MemberId") Integer MemberId,@ModelAttribute("Name") String Name,Integer storeId,Model model){
        List<Store> list = storeService.FindId(storeId);
        List<ChartMessage> list2 = chartMessageService.FindChartMessage(MemberId,list.get(0).getAdministratorId());
        chartMessageService.Update(MemberId,list.get(0).getAdministratorId(),Name);
        model.addAttribute("list2",list2);
        model.addAttribute("receiver",list.get(0).getName());
        model.addAttribute("name",Name);
        model.addAttribute("sender",Name);
        model.addAttribute("administratorId",list.get(0).getAdministratorId());
        model.addAttribute("memberId",MemberId);
        model.addAttribute("ms","多店铺分销管理系统——会员端");
        model.addAttribute("rt","/msdm_war/member/logincenter");
        model.addAttribute("close","/msdm_war/member/loginout");
        return "websocket";
    }


}
