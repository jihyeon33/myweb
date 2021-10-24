package com.example.week03_hwk2.controller;


import com.example.week03_hwk2.models.Memo;
import com.example.week03_hwk2.models.MemoRepository;
import com.example.week03_hwk2.models.MemoRequestDto;
import com.example.week03_hwk2.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @GetMapping("/api/memos")
    public List<Memo> getMemos(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }
    @PostMapping("/api/memos")
    public Memo postMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo=new Memo(requestDto);
        return memoRepository.save(memo);

    }
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){
        return memoService.updateMemo(id,requestDto);
    }
}
