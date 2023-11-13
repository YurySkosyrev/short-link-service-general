package com.example.general.links;

import com.example.general.common.ShortLink;

public interface LinksService {

    void save(ShortLink shortLink);

    void remove(String key);

    ShortLink get(String code);

    String randomKey();

    ShortLink randomPull();

}
