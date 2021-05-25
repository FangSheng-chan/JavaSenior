package com.ss.mapper;

import com.ss.model.Boy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fangsheng
 * @date 2021/5/24 2:01 下午
 */
@Mapper
public interface BoyMapper {

    Boy getBoyById(int id);

    int delBoy(int id);

}
