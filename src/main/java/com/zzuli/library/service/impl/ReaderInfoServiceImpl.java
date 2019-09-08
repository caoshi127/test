package com.zzuli.library.service.impl;

import com.zzuli.library.domain.ReaderInfo;
import com.zzuli.library.mapper.ReaderInfoMapper;
import com.zzuli.library.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReaderInfoServiceImpl implements ReaderInfoService {

    @Autowired
    private ReaderInfoMapper readerInfoMapper;

    @Override
    public ReaderInfo getReaderInfo(ReaderInfo readerInfo) {
        return readerInfoMapper.getReaderInfoById(readerInfo.getReader_id());
    }

    @Override
    public List<ReaderInfo> listAllReaderInfo() {
        return readerInfoMapper.listAllReaderInfo();
    }

    @Override
    public ReaderInfo getReaderInfoById(long readerId) {
        return readerInfoMapper.getReaderInfoById(readerId);
    }

    @Override
    public long getReaderId(ReaderInfo readerInfo) {
        return readerInfoMapper.getReaderId(readerInfo);
    }

    @Override
    public int updateReaderInfo(ReaderInfo readerInfo) {
        return readerInfoMapper.updateReaderInfo(readerInfo);
    }

    @Override
    public int removeReaderInfo(long id) {
        return readerInfoMapper.deleteReaderInfo(id);
    }

    @Override
    public int saveReaderInfo(ReaderInfo readerInfo) {
        return readerInfoMapper.insertReaderInfo(readerInfo);
    }
}
