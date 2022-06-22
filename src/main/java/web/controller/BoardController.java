package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.BoardDao;
import web.dto.BoardDto;
import web.service.BoardService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("list",boardService.getlist());
        System.out.println(boardService.getlist());
        return "list";
    }
    @GetMapping("/write")
    public String write(){
        return "write";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute BoardDto boardDto){
       boardService.save(boardDto);
        return "list";
    }




}
