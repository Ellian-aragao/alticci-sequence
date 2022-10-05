package ellian.aragao.com.github.infra.repository;

import ellian.aragao.com.github.domain.repository.AlticciSequenceCacheRepository;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.hash.HashCommands;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class AlticciSequenceCacheRepositoryImpl implements AlticciSequenceCacheRepository {
    private final String cacheKey;
    private final HashCommands<String, String, Long> redisClient;

    @Inject
    public AlticciSequenceCacheRepositoryImpl(
            RedisDataSource highLevelApi,
            @ConfigProperty(name = "quarkus.redis.key", defaultValue = "alticci::sequence") String cacheKey
    ) {
        this.redisClient = highLevelApi.hash(Long.class);
        this.cacheKey = cacheKey;
    }

    @Override
    public void save(Long size, Long value) {
        redisClient.hset(cacheKey, size.toString(), value);
    }

    @Override
    public Optional<Long> findFromIndex(Long size) {
        return Optional.ofNullable(redisClient.hget(cacheKey, size.toString()));
    }
}
