package com.libbooks.library.service.interfaceService;

import com.libbooks.library.model.entity.FeedBack;

import java.util.List;
import java.util.Optional;

public interface FeedBackService {
    public Optional<FeedBack> getFeedBackById(Integer feedBackId);
    public List<FeedBack> getFeedBacks();

    public void addFeedBack(FeedBack feedBack);
    public void updateFeedBack(Integer feedBackId,FeedBack feedBack);
    public void deleteFeedBack(Integer feedBackId);

}
