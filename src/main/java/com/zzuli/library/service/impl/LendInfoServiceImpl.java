package com.zzuli.library.service.impl;

import com.zzuli.library.domain.LendInfo;
import com.zzuli.library.mapper.LendInfoMapper;
import com.zzuli.library.service.LendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hejjon
 * @date 2019/8/22 11:31
 */
@Service
public class LendInfoServiceImpl implements LendInfoService {

    @Autowired
    private LendInfoMapper lendInfoMapper;

    @Override
    public List<LendInfo> listAllLendInfo() {
        return lendInfoMapper.listAllLendInfo();
    }

    @Override
    public List<LendInfo> listReadersLendInfo(long readerId) {
        return lendInfoMapper.listReadersLendInfo(readerId);
    }

    @Override
    public int removeLendInfo(long serNum) {
        return lendInfoMapper.deleteLendInfoBySerNum(serNum);
    }

    @Override
    public List<Long> listNoReturnBooksId(long readerId) {
        return lendInfoMapper.listNoReturnBooksId(readerId);
    }
}
