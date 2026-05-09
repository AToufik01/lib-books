package com.libbooks.library.service.interfaceService;

import com.libbooks.library.model.dto.FeedBackDTO;
import com.libbooks.library.model.entity.FeedBack;

import java.util.List;
import java.util.Optional;

public interface FeedBackService {
    FeedBackDTO getFeedBackById(Integer feedBackId);
    List<FeedBackDTO> getFeedBacks();

    FeedBackDTO addFeedBack(FeedBackDTO feedBack);
    FeedBackDTO updateFeedBack(Integer feedBackId,FeedBackDTO feedBack);
    void deleteFeedBack(Integer feedBackId);

}
