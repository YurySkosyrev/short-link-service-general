package com.example.general.links;

import com.example.general.common.ShortLink;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LinksServiceGeneral implements LinksService{

    private final Long SAVE_TIMEOUT_MS = 5000L;

    private final RedisTemplate<String, ShortLink> template;

    public LinksServiceGeneral(RedisTemplate<String, ShortLink> template) {
        this.template = template;
    }

    @Override
    public void save(ShortLink link) {
        template.opsForValue().set(link.getCode(), link, SAVE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    @Override
    public void remove(String key) {
        template.delete(key);
    }

    @Override
    public ShortLink get(String code) {
        return template.opsForValue().get(code);
    }

    @Override
    public String randomKey() {
        return template.randomKey();
    }

    @Override
    public ShortLink randomPull() {
        return get(randomKey());
    }
}
