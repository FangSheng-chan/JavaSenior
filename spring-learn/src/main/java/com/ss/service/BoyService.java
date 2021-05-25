package com.ss.service;

import com.ss.mapper.BoyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fangsheng
 * @date 2021/5/24 2:51 下午
 */
@Service
public class BoyService {

    @Autowired
    private BoyMapper boyMapper;

    @Transactional
    public void delBoy() {
        boyMapper.delBoy(4);
        int i = 1 / 0;
        boyMapper.delBoy(5);
    }
}
