package ellian.aragao.com.github.domain.repository;

import java.util.Optional;

public interface AlticciSequenceCacheRepository {
    void save(Long size, Long value);
    Optional<Long> findFromIndex(Long size);
}
