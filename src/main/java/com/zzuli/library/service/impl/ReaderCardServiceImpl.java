package com.zzuli.library.service.impl;

import com.zzuli.library.domain.ReaderCard;
import com.zzuli.library.domain.ReaderInfo;
import com.zzuli.library.mapper.ReaderCardMapper;
import com.zzuli.library.service.ReaderCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hejjon
 * @date 2019/8/17 21:08
 */
@Service
public class ReaderCardServiceImpl implements ReaderCardService {

    @Autowired
    private ReaderCardMapper readerCardMapper;

    @Override
    public ReaderCard getReaderCard(ReaderCard readerCard) {
        return readerCardMapper.getReaderCardByIdAndPwd(readerCard.getReader_id(), readerCard.getPassword());
    }

    @Override
    public int updateReaderCard(ReaderInfo readerInfo) {
        return readerCardMapper.updateReaderCard(readerInfo);
    }

    @Override
    public int removeReaderCard(long id) {
        return readerCardMapper.deleteReaderCard(id);
    }

    @Override
    public int saveReaderCard(ReaderCard readerCard) {
        return readerCardMapper.insertReaderCard(readerCard);
    }

    @Override
    public int updatePassword(ReaderCard readerCard) {
        return readerCardMapper.updatePassword(readerCard);
    }
}