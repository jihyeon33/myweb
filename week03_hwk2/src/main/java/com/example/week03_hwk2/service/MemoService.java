package com.example.week03_hwk2.service;

import com.example.week03_hwk2.models.Memo;
import com.example.week03_hwk2.models.MemoRepository;
import com.example.week03_hwk2.models.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Long updateMemo(Long id,MemoRequestDto requestDto){
        Memo memo= memoRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();

    }
}
