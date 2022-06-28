package web.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String main(){
        return "list";
    }

    @PostMapping("/list")
    @ResponseBody
    public void list(HttpServletResponse response){
        JSONObject json = boardService.getlist();
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(json);
        }catch( Exception e ){ System.out.println( e );}
    }

    @GetMapping("/write")
    public String write(){
        return "write";
    }

    @GetMapping("/update")
    public String update(){
        return "update";
    }

    @GetMapping("/getview")
    public void view(HttpServletResponse response ) {
        int bno =  (Integer) request.getSession().getAttribute("bno");
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(boardService.board(bno));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @GetMapping("/view/{bno}")
    public String view( @PathVariable("bno") int bno ) {
        request.getSession().setAttribute("bno", bno);
        return "boardview";
    }


        @PostMapping("/write")
    @ResponseBody
    public boolean write(BoardDto boardDto){
       boolean result = boardService.save(boardDto);
       return result;
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(@ModelAttribute BoardDto boardDto,Model model){
        int bno =  (Integer) request.getSession().getAttribute("bno");
        boardDto.setBno( bno );
        boardService.update(boardDto);
        return "redirect:view/"+bno;
    }

    @GetMapping("/delete")
    @ResponseBody
    public String delete( Model model){
        int bno =  (Integer) request.getSession().getAttribute("bno");
         boardService.delete(bno);
            model.addAttribute("list",boardService.getlist());
            return "list";
    }

}
