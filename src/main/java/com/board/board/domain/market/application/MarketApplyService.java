package com.board.board.domain.market.application;

import com.board.board.domain.Image.domain.Image;
import com.board.board.domain.free.dto.FreeBoardResponse;
import com.board.board.domain.market.domain.Market;
import com.board.board.domain.market.dto.MarketRequest;
import com.board.board.domain.market.dto.MarketResponse;
import com.board.board.domain.market.persistence.MarketRepository;
import com.board.board.domain.user.domain.User;
import com.board.board.global.FileUtil.FileUpload;
import com.board.board.global.error.FileSaveException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MarketApplyService {

    private final MarketRepository repository;

    public MarketResponse createMarket(MarketRequest request, User user, List<MultipartFile> images) {
        Market market = new Market(request, user);

        repository.save(market);

        images.forEach(image -> {
            final String IMAGE_LOCATION = "/post/image" + market.getId() + "/" + image.getOriginalFilename();

            try {
                FileUpload.uploadImage(image, IMAGE_LOCATION);

                Image postImage = Image.create(market, IMAGE_LOCATION);

                market.addImage(postImage);
            } catch (Exception e) {
                throw new FileSaveException(image.getOriginalFilename());
            }
        });
        return new MarketResponse(market);
    }
}
