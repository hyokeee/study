package com.ykh.merong.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/redir")
public class RedirectController {
   
   @GetMapping("/test2")
   public String test() {
      return "retest";
   }

   
   @PostMapping("/test")
   public String pTest(RedirectAttributes redirAttr) 
      throws Exception {
      // 한번만 쓸 일회성 메세지, Session에 담기는 부담스럽고
      // 모델에 담자니 URL을 리다이렉트해야 해서 담을 수 없을 떄
      // ?뒤에 붙여서 보내자니, 왠지 보안이 걱정될 때
      // Redirect라서 실제로는 Session에 담는데, 스프링이 알아서
      // 담았다가 지워줌, 그래서 이름에 flash가 들어감
      // 주의사항은 직접 HttpServletResponse를 이용하면 스프링이 중간에 끼지 못해서
      // 제대로 동작 안함!
      redirAttr.addFlashAttribute("oneTimeMessage", "너머지면 바보");
      
      //직접 Response를 이용하면 값이 담기지 않음(스프링이 중간에 끼어야 함, 자주하는 실수)
      //resp.sendRedirect("/merong/redir/test");

      return "redirect:/redir/test2";
   }
   
}