package idusw.springboot.boardthymeleaf.controller;

import idusw.springboot.boardthymeleaf.domain.Memo;
import idusw.springboot.boardthymeleaf.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemoController {
    MemoService memoService;
    // 생성자 주입 (Constructor ID)
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }
    @GetMapping("/memo")
    public String initialize(Model model) {
        List<Memo> result = new ArrayList<>();
        memoService.readList();
        model.addAttribute("attr", result);
        return "list";
    }
    @GetMapping("/memo/{mno}")
    public String getList(@PathVariable("mno") Long mno, Model model) {
        Memo result = new Memo();
        Memo m = new Memo();
        m.setMno(mno);
        result = memoService.read(m);
        model.addAttribute("attr", result);
        return "one";
    }
}
