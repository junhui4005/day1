package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.BoardDao;
import web.dto.BoardDto;
import web.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BoardController {


    @Autowired
    private HttpServletRequest request;
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

    @GetMapping("/update")
    public String update(){
        return "update";
    }

    @GetMapping("/view/{bno}")
    public String view(@PathVariable("bno") int bno , Model model){
        BoardDto boardDto = boardService.board(bno);
        model.addAttribute("board",boardDto);
        request.getSession().setAttribute("bno", bno);
        return "view";
    }


    @PostMapping("/write")
    public String write(@ModelAttribute BoardDto boardDto,Model model){
       boardService.save(boardDto);
        model.addAttribute("list",boardService.getlist());
        return "list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDto boardDto,Model model){
        int bno =  (Integer) request.getSession().getAttribute("bno");
        boardDto.setBno( bno );
        boardService.update(boardDto);
        request.getSession().setAttribute("bno", bno);
        return "view";
    }

    @GetMapping("/delete/{bno}")
    public String delete(@PathVariable("bno") int bno , Model model){
        boolean result = boardService.delete(bno);
        if(result){
            model.addAttribute("list",boardService.getlist());
            return "list";
        }
        model.addAttribute("list",boardService.getlist());
        return "list";
    }


}
